/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.LogicApplicativa;

//import logicaapplicativa.FourPlayersBrain;
import centralbriscolaserver.Protocollo;
import centralbriscolaserver.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MainBrain {
    
    //private ArrayList carteGiocate;
    protected ArrayList mazzo;
    private String[] semi = {"d", "c", "s", "b"};
    protected Carta briscola;
    protected ArrayList<User> users;
    private int nGiocatori;
    public static Writer game;
    public String roomName;
    private Protocollo p;
    
    public MainBrain(int ng, String name) throws IOException{
        mazzo = new ArrayList();
        users = new ArrayList();
        nGiocatori = ng;
        creaMazzo();
        this.roomName = name;
        System.out.println("************************************");
        System.out.println("Per giocare inserisci semplicemente due cifre per il numero (es: 04, 02, 10, 07) e l'iniziale del seme\n"
                + "Un esempio di giocata è: 04d, 10s, 03c. Il primo Gioca si riferisci a chi spetta il turno.");
        System.out.println("************************************\n");
    }

    public MainBrain() {
        
    }
    
    private void stampaMazzo(){
        for(int i = 0; i < 40; i++){
            Carta c = (Carta) mazzo.get(i);
            System.out.println(i + ": " + c.getNumero() + " di " + c.getSeme() + ". Briscola: " + c.isBriscola());
        }
    }
    
    private void creaMazzo() throws IOException{
        int n, i;
        for(n = 1; n < 11; n++){
            for(i = 0; i < semi.length; i++){
                    mazzo.add(new Carta(n, semi[i]));
            }
        }
        Collections.shuffle(mazzo);
    }
    
    
    
    public void addUser(User user) throws IOException{
        if (users.isEmpty()){
            p = new Protocollo(user);
        }
        
        users.add(user);
        if (users.size() == nGiocatori){
            if (nGiocatori == 2) {
                new TwoPlayersBrain(mazzo);
            } else if (nGiocatori == 4) {
                new FourPlayersBrain(mazzo);
            }
            game = new Writer(users);
            for(int i = 0; i < nGiocatori; i++){
                //Reader r = new Reader(users.get(i));
            }
        }
    }
    
    public void removeUser(User user){
        p.exitGame(user.getNickname());
        if (user.equals(users.get(0))){
            destroy(user);
        }
        else {
            
            users.remove(user);
        }
    }
    //quando un creatore esce dalla propria stanza essa viene distutta
    private void destroy(User host) {
        Protocollo p = new Protocollo(host);
        p.removeRoom(this.roomName);
        p.exitGame(host.getNickname());
        
    }
}