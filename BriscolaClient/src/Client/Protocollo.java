/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author g.evangelista
 */
public class Protocollo {
    public static final String bootstrap = "00...";
    public static final String ingame = "01...";
    public static final String play_card = "10...";//10...10d
    public static final String winRound = "11...";
    public static final String winGame = "12...";
    public static final String disconnect = "02...";
    public static final String disconnectGame = "03...";
    public static final String newServer = "04...";
    
    public static String getHeader(String msg){
        return msg.substring(0, 5);
    }
    
    public static String getContent(String msg){
        return msg.substring(5);
    }
}
