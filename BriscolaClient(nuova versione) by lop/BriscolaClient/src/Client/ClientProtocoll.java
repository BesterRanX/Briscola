/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.GUI.JPanelLogin;



/**
 *
 * @author n.lo piccolo
 */

/*
Legenda:
- ** = fatto;
- *? = fato da testare;
- *- = da fare;
*/
public class ClientProtocoll {
    
    private static final String bootstrap = "01.";
    
    private static final String turno_giocatore = "02.";
    
    private static final String gameHeader = "04.";
    private static final String joinGame = "jon.";
    private static final String exitGame = "exg.";
    
    private static final String winRound = "05.";
    
    private static final String cardHeader = "06.";
    private static final String get_mano = "hnd.";
    private static final String get_card = "crd.";
    
    private static final String messagechat = "09.";
    private static final String briscola = "11.";
    
    private static final String roomHeader = "12.";
    private static final String sync_room = "syn.";
    private static final String get_room_name = "get.";
    private static final String create_room_2p = "cr2.";
    private static final String create_room_4p = "cr4.";
    private static final String remove_room = "rmv.";
    private String pacchetto = null;
    
    //stringhe giocatori
    private static String g1 = null;
    private static String g2 = null;
    private static String g3 = null;
    private static String g4 = null;
    
    //Stringa che tiene conto del turno attuale
    public static String turno = null;
    
    public ClientProtocoll () {
    }
    
    //metodi generali
     public String getHeader(String msg){
        return msg.substring(0, 3);
    }
     public String getIdentifier(String msg){
        return msg.substring(3,7);
    }
     //prende il contenuto nel caso in cui ci sia un identifier
     public String getContentId(String msg){
        return msg.substring(7);
    }
     //prende il contenuto nel caso in cui non ci sia un identifier
     public String getContent(String msg){
        return msg.substring(3);
    }
    //metodo di spacchettamento *?
    public String route(String msg){
        
        String  header = getHeader(msg);
        String identifier = null;
        switch(header) {
            case turno_giocatore: { turnoGiocatore(msg); break;}
            case gameHeader: {
                identifier = getIdentifier(msg);
                
                switch(identifier) {
                    /*case joinGame: {pacchetto = joinGame(msg); break;}*/
                    case exitGame: {pacchetto = exitGame(msg); break;}
                }
                break;}
            
            case winRound: { pacchetto = winRound(msg); break;}
            
            case cardHeader: {
                identifier = getIdentifier(msg);
                switch(identifier) {
                    case get_mano: { pacchetto = getMano(msg); break;}
                    case get_card: { pacchetto = getCard(msg); break;}
                }
                break;}
            
            case messagechat: { pacchetto = messageChat(msg); break;}
            
            case briscola: { pacchetto = briscola(msg); break;}
            
            case roomHeader: {
                identifier = getIdentifier(msg);
                switch(identifier) {
                    case sync_room: { pacchetto = syncRoom(msg);break;}
                    case get_room_name: { UpdateRoomName(msg);break;}
                    case create_room_2p: { pacchetto = createRoom2p(msg);break;}
                    case create_room_4p: { pacchetto = createRoom4p(msg);break;}
                    case remove_room: { pacchetto = removeRoom(msg);break;}
                }
                break;}
            default: { System.out.println("ERROR: BAD HEADER"); break; }
        }
        return pacchetto;
    }
    //impacchettamento per invio al server
    
    //il pacchetto conterrà header+nome es. 01.pippo
    //solo invio al server **
    public String sendBootstrap(String nome) {
        pacchetto = bootstrap;
        pacchetto = pacchetto + nome;
        return pacchetto;
    }
    //Questo metodo ritorna il giocatore che deve giocare la carta *?
    public void turnoGiocatore(String msg) {
        turno = msg.substring(3,6); 
        //capire come usare questa variabile dovrebbe esssere 
        //a tutti i client inviata in broadcast.
    }
    //ricezione nuovo utente entrato nella stanza SERV ER errore mio **
    public String joinGame(String nro, String nick) {
        pacchetto = gameHeader + joinGame + nro + "." + nick;
        return pacchetto;
    }
    //*-
    public String exitGame(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;    
    }
    //*-
    public String winRound(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;
    }
    //*-
    public String getMano(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;    
    }
    //*-
    public String getCard(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;
    }
    //*-
    public String messageChat(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;    
    }
    //*-
    public String briscola(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;   
    }
    //*-
    public String syncRoom(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;    
    }
    //*-
    public void UpdateRoomName(String roomName) {
        String room;
        room = getContentId(roomName);
        JPanelLogin.updateRooms(room);
    }
    //*-
    public String createRoom2p(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;
    }
    //*-
    public String createRoom4p(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;
    }
    //*-
    public String removeRoom(String msg) {
        pacchetto = getIdentifier(msg);
        return pacchetto;
    }
    
}
