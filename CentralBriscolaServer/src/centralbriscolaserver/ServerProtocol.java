/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralbriscolaserver;



/**
 *
 * @author n.lo piccolo
 */
public class ServerProtocol {
    private static final String bootstrap = "01.";
    
    private static final String turno_giocatore = "02.";
    
    private static final String gameHeader = "04.";
    private static final String joinGame = "jon.";
    private static final String exitGame = "exg.";
    
    private static final String winRound = "05.";
    private static final String playCard = "";
    
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
    private User user;
    
    public ServerProtocol ( User _user) {
        user = _user;
    }
    
    //metodo del setHost
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
    //metodo di spacchettamento
    public String route(String msg){
        
        String  header = getHeader(msg);
        System.out.println("Header: " + header);
        String identifier = null;
        String pacchetto = null;
        
        switch(header) {
            /************** decode *************/
            case bootstrap: { receiveBootstrap(msg); break;}
            case gameHeader: {
                identifier = getIdentifier(msg);
                System.out.println("Identidier: " + identifier);
                switch(identifier) {
                    case exitGame: {sendExitGame(msg); break;}
                }
                break;
            }
            
            case winRound: { sendWinRound(msg); break;}
            
            case cardHeader: {
                identifier = getIdentifier(msg);
                switch(identifier) {
                    case get_card: {sendCard(msg); break;}
                }
                break;
            }
            
            case messagechat: { pacchetto = messageChat(msg); break;}

            case roomHeader: {
                identifier = getIdentifier(msg);
                System.out.println("Identidier: " + identifier);
                switch(identifier) {
                    case create_room_2p: {receiveRoom2p(msg);break;}
                    case create_room_4p: {receiveRoom4p(msg);break;}
                }
                break;
            }
            default: { System.out.println("ERROR: BAD HEADER"); break; }
        }
        return pacchetto;
    }
    
    //Questo metodo ritorna il giocatore che deve giocare la carta **
    public String sendTurnoGiocatore(String turno) {
        System.out.println("Sto Inviando" + turno_giocatore + turno); 
        return turno_giocatore + turno;
    }
    
    //segnala ai client un nuovo utente entrato nella stanza **
    public void sendJoinGame(String nro, String nick) {
        String pacchetto = gameHeader + joinGame + nro + "." + nick;
        user.getGame().broadcastMessage(pacchetto);
    }

    //segnala che un utente si è disconesso **
    public void sendExitGame(String utente) {
        String pacchetto = gameHeader + exitGame + utente;
        System.out.println("Sto Inviando" + pacchetto);
        user.getGame().broadcastMessage(pacchetto);
    }
    
    //Bho *-
    public String sendWinRound(String msg) {
        return getIdentifier(msg);
    }
    
    //segnala la mano iniziale del giocatore **
    public void sendMano(String c1,String c2,String c3) {
        String pacchetto = cardHeader + get_mano + (c1 + "-" + c2 + "-" + c3);
        user.writeSocket(pacchetto);
    }
    
    //segnala al utente la carta pescata **
    public void sendCard(String carta) {
        String pacchetto = cardHeader + get_card + carta;
        user.writeSocket(pacchetto);
    }
    
    //DA IMPLEMENTARE
    public String messageChat(String msg) {
        return getIdentifier(msg);   
    }
    //*-
    public String sendBriscola(String msg) {
        return getIdentifier(msg);
    }
    
    //*-
    public void sendSyncRoom(String msg) {
        String pacchetto = roomHeader + sync_room + user.connectedServer.getRooms();
        user.connectedServer.broadcastMessage(pacchetto);
    }
    
    //*-
    public void sendRoomName(String roomname) {
       String pacchetto = roomHeader + get_room_name + roomname;
       user.connectedServer.broadcastMessage(pacchetto);
    }
    
    //Rivece la richiesta di una nuova stanza da due e la crea **
    public void receiveRoom2p(String msg) {
        String roomName = getContentId(msg);
        System.out.println("Nuovo room da due creata " + roomName);
        user.connectedServer.createRoom(2, roomName);
    }
    //Rivece la richiesta di una nuova stanza da quattro e la crea **
    public void receiveRoom4p(String msg) {
        String roomName = getContentId(msg);
        System.out.println("Nuovo room da quattro creata " + roomName);
        user.connectedServer.createRoom(4, roomName,user);
    }
    
    //Rimuove la stanza a tutti i client connessi **
    public void sendRemoveRoom(String room) {
        String pacchetto = roomHeader + remove_room + room;
        user.connectedServer.broadcastMessage(pacchetto);
    }
    
    //Riceve il saluto del nuovo client connesso **
    private void receiveBootstrap(String msg) {
        user.setNickname(getContent(msg)); 
        System.out.println("bootstrap " + user.getNickname());
    }
}
