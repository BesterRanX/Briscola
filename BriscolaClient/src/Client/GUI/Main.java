/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.GUI;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    public static NewGame newGame;
    public static JPanelAttesa attesa = new JPanelAttesa();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        
        login = new JPanelLogin();
        newGame  = new NewGame();
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setUndecorated(true);
        menu.pack();
        menu.add(login);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(3);
        try {
            playMusic();
        } 
        catch (UnsupportedAudioFileException ex) {} 
        catch (LineUnavailableException ex) {} 
        catch (IOException ex) {}
    }
    
    private static void playMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Random r = new Random();
        int song = r.nextInt(1);
        song++;
        File file = new File("src/Client/Sounds/bgm" + song + ".wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }
}


