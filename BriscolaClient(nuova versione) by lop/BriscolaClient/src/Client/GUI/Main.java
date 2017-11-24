/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.GUI;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author t.erra
 */
public class Main {
   
    public static JFrame menu = new JFrame();
    public static JPanelLogin login;
    public static JPanelGame game = new JPanelGame();
    public static JPanelGame4 game4 = new JPanelGame4();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        login = new JPanelLogin();
        menu.pack();
        menu.add(login);
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(3);       
    }
}


