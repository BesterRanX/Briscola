/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Client.GUI.JPanelLogin;
import static Client.Protocollo.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Gabriele
 */
public class CentralServerChatter extends Thread{
    
    private final Socket socket;
    
    private BufferedReader socket_reader;
    private InputStreamReader ir;
    
    public CentralServerChatter(Socket s) throws IOException{
        System.out.println("CSC ON");
        socket = s;
        socket_reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();
    }
    
    @Override
    public void run(){
         while(true){
            try {
                Thread.sleep(10);
                String message = readFromSocket();
                System.out.println(message);
                decodeMessage(message);
            } catch (InterruptedException ex) {
            } catch (IOException ex) {
            }
         
        }
    }
    
    public String readFromSocket() throws IOException{
        return socket_reader.readLine();
    }
    
    private void decodeMessage(String msg) throws IOException{
        System.out.println("Decodifico dal server " + getHeader(msg));
        switch(getHeader(msg)){
            case play_card:{
                String carta_giocata = getContent(msg);
                break;
            }
            case newServer:{
                JPanelLogin.updateRooms(getContent(msg));
                break;
            }
            case disconnectGame:{
                disconnect();
                break;
            }
        }
    }
    
    private void disconnect() throws IOException{
        socket.close();
    }
    
    
}
