/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralbriscolaserver;

import Server.LogicApplicativa.MainBrain;
import java.io.IOException;
import server.BriskServer;
        
/**
 *
 * @author besterranx
 */
public final class User extends Thread{
    /************* PROPERTIES ************/
    protected BriskServer connectedServer;
    private String nickname;
    public UserSocket connectedSocket;
    private MainBrain ingame = null;
    
    
    /************* CONSTRUCTORS *************/
    public User(BriskServer server, UserSocket userSocket, String _nickname) throws IOException{
        connectedSocket = userSocket;
        connectedServer = server;
        setName(_nickname);
        
        start();
        connectedServer.updateRooms();
        
    }
    
    public User(BriskServer server, UserSocket usercnt) throws IOException{
        connectedSocket = usercnt;
        connectedServer = server;
        
        start();
        connectedServer.updateRooms();
    }
    
    /************** OPERATORS ***************/
    private void decodeMessage(String msg) throws IOException{
        Protocollo proto = new Protocollo(msg,this);
        System.out.println("Decodifico " + proto.getHeader(msg));
        System.out.println(proto.route(msg));
    }
    
    /************** METHODS ****************/
    @Override
    public void run(){
        while(true){
            try {
                String message = connectedSocket.readFromSocket();
                System.out.println(message);
                decodeMessage(message);
            } catch (IOException ex) {
                //resolve
                if(isInGame()) leaveGame(ingame);
                connectedServer.disconnectUser(this);
                
                System.out.println(nickname + " si e disconnesso");
            }
        }
    }
    
    public String getNickname(){
        return nickname;
    }
    public boolean isInGame(){
        if (ingame == null) return false;
        else return true;
    }
    
    
    public void joinGame(MainBrain game){
        try{
            game.addUser(this);
        }catch(Exception ex){}
        ingame = game;
    }
    
    public void leaveGame(MainBrain game){
        game.removeUser(this);
        ingame = null;
    }
    
    public void writeSocket(String msg){
        connectedSocket.writeSocket(msg);
    }
    
    public void setNickname(String _name){
        nickname = _name;
    }

    public void suicide(){
        System.out.println(nickname + " si e morto");
        connectedSocket.delete();
        try{
            join();
        }catch(Exception ex){}
    }
    
    public UserSocket getSocket(){
        return connectedSocket;
    }
}
