/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.GUI;

import GUI.IstruzioneCarta;
import Client.ClientThread;
import static Client.GUI.Main.menu;
import Client.ClientProtocoll;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 *
 * @author t.erra
 */
public class JPanelLogin extends javax.swing.JPanel {

    /**
     * Creates new form JPanelLogin
     */
    private String indirizzo;
    private BufferedImage backgroundImage;
    private BufferedImage [] cartaIstruzione;
    private InetAddress addr;
    private ClientThread clientThread;
    private static ClientProtocoll proto = new ClientProtocoll();
    
    
    public JPanelLogin()  {
        
        initComponents();
        
        clientThread = new ClientThread(addr);
        
        BufferedImage [] cartaIstruzione = new BufferedImage[5];
        
        JPanelCartaIstruzione.setVisible(false);
        
        
        
        JButtonChiudiRegolamento.setVisible(false);
        
        JTextFieldNomeStanza.setVisible(false);
        JLabelNomeStanza.setVisible(false);
        
        JButtonInvio.setOpaque(false);
        JButtonInvio.setContentAreaFilled(false); //to make the content area transparent
        JButtonInvio.setBorderPainted(false);
        
        RBHost.setOpaque(false);
        RBHost.setContentAreaFilled(false);
        RBHost.setBorderPainted(false);
        
        RBClient.setOpaque(false);
        RBClient.setContentAreaFilled(false);
        RBClient.setBorderPainted(false);
        
        RBTwoP.setOpaque(false);
        RBTwoP.setContentAreaFilled(false);
        RBTwoP.setBorderPainted(false);
        
        RBFourP.setOpaque(false);
        RBFourP.setContentAreaFilled(false);
        RBFourP.setBorderPainted(false);
        
        JButtonRegolamento.setOpaque(false);
        JButtonRegolamento.setContentAreaFilled(false);
        JButtonRegolamento.setBorderPainted(false);
        
        JButtonChiudiRegolamento.setOpaque(false);
        JButtonChiudiRegolamento.setContentAreaFilled(false);
        JButtonChiudiRegolamento.setBorderPainted(false);
        
        JPanelCartaIstruzione.setOpaque(false);
        
        try {
            backgroundImage = ImageIO.read(this.getClass().getResource("../immagini/bg.png"));
        } catch (IOException ex) {
            Logger.getLogger(JPanelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateRooms(String name){
        String content = roomsTextArea.getText();
        if(!content.toLowerCase().contains(name.toLowerCase()))
            roomsTextArea.append(name + "\n");
    }
    
    @Override
    public void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0,getWidth(), getHeight(), this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroupGiocatori = new javax.swing.ButtonGroup();
        ButtonGroupServizio = new javax.swing.ButtonGroup();
        RBClient = new javax.swing.JRadioButton();
        JLabelScelta = new javax.swing.JLabel();
        RBHost = new javax.swing.JRadioButton();
        JButtonInvio = new javax.swing.JButton();
        TextIP = new javax.swing.JTextField();
        TextNickname = new javax.swing.JTextField();
        JLabelIndirizzo = new javax.swing.JLabel();
        JLabelNome = new javax.swing.JLabel();
        JLabelGiocatori = new javax.swing.JLabel();
        RBTwoP = new javax.swing.JRadioButton();
        RBFourP = new javax.swing.JRadioButton();
        JButtonRegolamento = new javax.swing.JButton();
        JButtonChiudiRegolamento = new javax.swing.JButton();
        JPanelCartaIstruzione = new javax.swing.JPanel();
        JLabelCarta = new IstruzioneCarta();
        JButtonAvanti = new javax.swing.JButton();
        JButtonIndietro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        JTextFieldNomeStanza = new javax.swing.JTextField();
        JLabelNomeStanza = new javax.swing.JLabel();

        ButtonGroupServizio.add(RBClient);
        RBClient.setForeground(new java.awt.Color(255, 255, 255));
        RBClient.setText("Client");
        RBClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBClientActionPerformed(evt);
            }
        });

        JLabelScelta.setForeground(new java.awt.Color(255, 255, 255));
        JLabelScelta.setText("Selezionare la scelta");

        ButtonGroupServizio.add(RBHost);
        RBHost.setForeground(new java.awt.Color(255, 255, 255));
        RBHost.setText("Host");
        RBHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBHostActionPerformed(evt);
            }
        });

        JButtonInvio.setForeground(new java.awt.Color(255, 255, 255));
        JButtonInvio.setText("Invio");
        JButtonInvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonInvioActionPerformed(evt);
            }
        });

        TextIP.setText("127.0.0.1");

        TextNickname.setText("pippo");
        TextNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNicknameActionPerformed(evt);
            }
        });

        JLabelIndirizzo.setForeground(new java.awt.Color(255, 255, 255));
        JLabelIndirizzo.setText("Inserisci l'indirizzo del host");

        JLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNome.setText("Inserisci il tuo nome");

        JLabelGiocatori.setForeground(new java.awt.Color(255, 255, 255));
        JLabelGiocatori.setText("Selezioanare il numero di giocatori");

        ButtonGroupGiocatori.add(RBTwoP);
        RBTwoP.setForeground(new java.awt.Color(255, 255, 255));
        RBTwoP.setText("2 Giocatori");

        ButtonGroupGiocatori.add(RBFourP);
        RBFourP.setForeground(new java.awt.Color(255, 255, 255));
        RBFourP.setText("4 Giocatori");

        JButtonRegolamento.setForeground(new java.awt.Color(255, 255, 255));
        JButtonRegolamento.setText("Regolamento");
        JButtonRegolamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRegolamentoActionPerformed(evt);
            }
        });

        JButtonChiudiRegolamento.setForeground(new java.awt.Color(255, 255, 255));
        JButtonChiudiRegolamento.setText("Chiudi Regolamento");
        JButtonChiudiRegolamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonChiudiRegolamentoActionPerformed(evt);
            }
        });

        JPanelCartaIstruzione.setPreferredSize(new java.awt.Dimension(233, 403));

        JLabelCarta.setPreferredSize(new java.awt.Dimension(233, 403));

        JButtonAvanti.setText("Avanti");
        JButtonAvanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAvantiActionPerformed(evt);
            }
        });

        JButtonIndietro.setText("Indietro");
        JButtonIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonIndietroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelCartaIstruzioneLayout = new javax.swing.GroupLayout(JPanelCartaIstruzione);
        JPanelCartaIstruzione.setLayout(JPanelCartaIstruzioneLayout);
        JPanelCartaIstruzioneLayout.setHorizontalGroup(
            JPanelCartaIstruzioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCartaIstruzioneLayout.createSequentialGroup()
                .addComponent(JLabelCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelCartaIstruzioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JButtonIndietro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButtonAvanti, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPanelCartaIstruzioneLayout.setVerticalGroup(
            JPanelCartaIstruzioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelCartaIstruzioneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelCartaIstruzioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonAvanti, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonIndietro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roomsTextArea.setEditable(false);
        roomsTextArea.setColumns(20);
        roomsTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        roomsTextArea.setRows(5);
        jScrollPane1.setViewportView(roomsTextArea);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rooms:");

        JLabelNomeStanza.setBackground(new java.awt.Color(255, 255, 255));
        JLabelNomeStanza.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNomeStanza.setText("Inserisci il nome per la tua stanza");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(JButtonChiudiRegolamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonRegolamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButtonInvio)
                .addGap(337, 337, 337))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TextNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLabelNome))
                            .addComponent(JLabelScelta)
                            .addComponent(RBHost)
                            .addComponent(RBClient))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBFourP)
                            .addComponent(RBTwoP)
                            .addComponent(JLabelGiocatori)
                            .addComponent(JLabelIndirizzo)
                            .addComponent(TextIP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTextFieldNomeStanza, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLabelNomeStanza)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(JPanelCartaIstruzione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPanelCartaIstruzione, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelNome)
                            .addComponent(JLabelIndirizzo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelScelta)
                            .addComponent(JLabelGiocatori))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RBHost)
                            .addComponent(RBTwoP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RBClient)
                            .addComponent(RBFourP))
                        .addGap(44, 44, 44)
                        .addComponent(JLabelNomeStanza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldNomeStanza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonRegolamento)
                    .addComponent(JButtonInvio)
                    .addComponent(JButtonChiudiRegolamento))
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RBHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBHostActionPerformed
        // TODO add your handling code here:
        if(RBHost.isSelected()){
            
            TextIP.setEnabled(false);
            JLabelNomeStanza.setVisible(true);
            JTextFieldNomeStanza.setVisible(true);
//        } else {
//            
//            TextIP.setEnabled(true);
//            JLabelNomeStanza.setVisible(false);
//            JTextFieldNomeStanza.setVisible(false);
//            JTextFieldNomeStanza.setText("");
            
        }
    }//GEN-LAST:event_RBHostActionPerformed

    private void JButtonInvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonInvioActionPerformed
        //codice relative all'avvio del client
        if(TextNickname.getText().isEmpty() && TextIP.getText().isEmpty()){
            TextNickname.setText("ERROR");
            TextIP.setText("ERROR");
        }
        else{
            //server
            if(RBHost.isSelected()==true) {
                TextIP.setText("127.0.0.1");
               if(RBTwoP.isSelected()) {
                    clientThread.writeToServer("12.cr2." + JTextFieldNomeStanza.getText());
                    System.out.println("12.cr2." + JTextFieldNomeStanza.getText());
               }
                else if(RBFourP.isSelected()) {
                    clientThread.writeToServer("12.cr4." + JTextFieldNomeStanza.getText());
                    System.out.println("12.cr4." + JTextFieldNomeStanza.getText());
                }
                //invio del nickname al server
               
                clientThread.writeToServer(proto.sendBootstrap(TextNickname.getText()));
                
            }
            //client
            //ClientThread c = new ClientThread(TextNickname.getText(),TextIP.getText());
             
            //istruzioni successive
            indirizzo = TextIP.getText();
            System.out.println("Indirizzo: " + indirizzo);
            System.out.println("Nome: " + TextNickname.getText());
        
            TextIP.setText("");
            TextNickname.setText("");
            
            
            //Gestione dei bottoni se non selezionati
            /*if(RBClient.isSelected()==false || RBHost.isSelected()==false && RBTwoP.isSelected()==false || RBFourP.isSelected()==false){
                JPanelPopup.setVisible(true);
                JLabelPopup.setText("Selezionare servizio e numero di giocatori");
            } else if(RBClient.isSelected()==false || RBHost.isSelected()==false && RBTwoP.isSelected()==true || RBFourP.isSelected()==true
                    ){
                JLabelPopup.setText("Selezionare un servizio");
                JPanelPopup.setVisible(true);
            } else if(RBTwoP.isSelected()==false || RBFourP.isSelected()==false && RBClient.isSelected()==true || RBHost.isSelected()==true){
                JLabelPopup.setText("Selezionare numero di giocatori");
                JPanelPopup.setVisible(true);
            }*/
            
            if(RBTwoP.isSelected()){
                Main.menu.getContentPane().removeAll();
                Main.menu.add(Main.game);
                Main.menu.pack();
                Main.game.validate();
                Main.game.repaint();
                Main.menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            }
            if(RBFourP.isSelected()){
                Main.menu.getContentPane().removeAll();
                Main.menu.add(Main.game4);
                Main.menu.pack();
                Main.game4.validate();
                Main.game4.repaint();
                Main.menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            }
        }   
    }//GEN-LAST:event_JButtonInvioActionPerformed

    private void RBClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBClientActionPerformed
        // TODO add your handling code here
        TextIP.setEnabled(true);
        JLabelNomeStanza.setVisible(false);
        JTextFieldNomeStanza.setVisible(false);
        JTextFieldNomeStanza.setText("");
        
    }//GEN-LAST:event_RBClientActionPerformed

    private void JButtonRegolamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRegolamentoActionPerformed
        // TODO add your handling code here:
        JPanelCartaIstruzione.setVisible(true);
        this.JButtonIndietro.setEnabled(false);
        this.JButtonRegolamento.setEnabled(false);
        this.JButtonRegolamento.setVisible(false);
        this.JButtonChiudiRegolamento.setEnabled(true);
        this.JButtonChiudiRegolamento.setVisible(true);
    }//GEN-LAST:event_JButtonRegolamentoActionPerformed

    private void TextNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNicknameActionPerformed

    private void JButtonAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAvantiActionPerformed
        // TODO add your handling code here:
        IstruzioneCarta label = (IstruzioneCarta)JLabelCarta;
        
        if (label.immagineSuccessiva() == 2){
            this.JButtonAvanti.setEnabled(false);
            this.JButtonIndietro.setEnabled(true);
        } else {
            this.JButtonAvanti.setEnabled(true);
            this.JButtonIndietro.setEnabled(true);
        } 
    }//GEN-LAST:event_JButtonAvantiActionPerformed

    private void JButtonIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonIndietroActionPerformed
        // TODO add your handling code here:
        IstruzioneCarta label = (IstruzioneCarta)JLabelCarta;
        if (label.immaginePrecedente() == 0){
            this.JButtonIndietro.setEnabled(false);
            this.JButtonAvanti.setEnabled(true);
        } else {
            this.JButtonIndietro.setEnabled(true);
            this.JButtonAvanti.setEnabled(true);
        }
    }//GEN-LAST:event_JButtonIndietroActionPerformed

    private void JButtonChiudiRegolamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonChiudiRegolamentoActionPerformed
        // TODO add your handling code here:
        JPanelCartaIstruzione.setVisible(false);
        
        this.JButtonRegolamento.setEnabled(true);
        this.JButtonRegolamento.setVisible(true);
        this.JButtonChiudiRegolamento.setVisible(false);
    }//GEN-LAST:event_JButtonChiudiRegolamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGroupGiocatori;
    private javax.swing.ButtonGroup ButtonGroupServizio;
    private javax.swing.JButton JButtonAvanti;
    private javax.swing.JButton JButtonChiudiRegolamento;
    private javax.swing.JButton JButtonIndietro;
    private javax.swing.JButton JButtonInvio;
    private javax.swing.JButton JButtonRegolamento;
    public javax.swing.JLabel JLabelCarta;
    private javax.swing.JLabel JLabelGiocatori;
    private javax.swing.JLabel JLabelIndirizzo;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JLabel JLabelNomeStanza;
    private javax.swing.JLabel JLabelScelta;
    private javax.swing.JPanel JPanelCartaIstruzione;
    private javax.swing.JTextField JTextFieldNomeStanza;
    private javax.swing.JRadioButton RBClient;
    private javax.swing.JRadioButton RBFourP;
    private javax.swing.JRadioButton RBHost;
    private javax.swing.JRadioButton RBTwoP;
    private javax.swing.JTextField TextIP;
    private javax.swing.JTextField TextNickname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea roomsTextArea;
    // End of variables declaration//GEN-END:variables
}
