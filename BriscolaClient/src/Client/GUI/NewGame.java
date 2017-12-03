/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriele
 */
public class NewGame extends javax.swing.JPanel {

    /**
     * Creates new form NewGame
     */
    private boolean cardG11played = false;
    private boolean cardG12played = false;
    private boolean cardG13played = false;
    private boolean cardG21played = false;
    private boolean cardG22played = false;
    private boolean cardG23played = false;
    
    private boolean prendiG1 = false;
    private boolean prendiG2 = false;
    private boolean prendiCartaG1 = false;
    private boolean prendiCartaG2 = false;
    
    private boolean pescaG11 = false;
    private boolean pescaG12 = false;
    private boolean pescaG13 = false;
    private boolean pescaG21 = false;
    private boolean pescaG22 = false;
    private boolean pescaG23 = false;

    private Image imageG11;
    private Image imageG12;
    private Image imageG13;
    private Image imageG21;
    private Image imageG22;
    private Image imageG23;
    private Image cardG1;
    private Image cardG2;
    private Image cardBack;

    private int G11x;
    private int G11y;
    private int G12x;
    private int G12y;
    private int G13x;
    private int G13y;
    private int G21x;
    private int G21y;
    private int G22x;
    private int G22y;
    private int G23x;
    private int G23y;
    private int cartaPescataX;
    private int cartaPescataY;
    private int cartaGiocataG1x;
    private int cartaGiocataG1y;
    private int cartaGiocataG2x;
    private int cartaGiocataG2y;

    public NewGame() throws IOException {
        initComponents();
        this.setBackground(Color.black);
        cardBack = ImageIO.read(this.getClass().getResource("../Immagini/yugiohVerticale.png"));
        imageG21 = ImageIO.read(this.getClass().getResource("../Immagini/yugiohVerticale.png"));
        imageG22 = ImageIO.read(this.getClass().getResource("../Immagini/yugiohVerticale.png"));
        imageG23 = ImageIO.read(this.getClass().getResource("../Immagini/yugiohVerticale.png"));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cardG11played) {
            spostaCartaG11();
            g.drawImage(imageG11, G11x, G11y, this);
            repaint();
        }
        if (cardG12played) {
            spostaCartaG12();
            g.drawImage(imageG12, G12x, G12y, this);
            repaint();
        }
        if (cardG13played) {
            spostaCartaG13();
            g.drawImage(imageG13, G13x, G13y, this);
            repaint();
        }
        if (cardG21played) {
            spostaCartaG21();
            g.drawImage(imageG21, G21x, G21y, this);
            repaint();
        }
        if (cardG22played) {
            spostaCartaG22();
            g.drawImage(imageG22, G22x, G22y, this);
            repaint();
        }
        if (cardG23played) {
            spostaCartaG23();
            g.drawImage(imageG23, G23x, G23y, this);
            repaint();
        }
        if(prendiCartaG1){
            prendiCartaG1();
            g.drawImage(cardG1, cartaGiocataG1x, cartaGiocataG1y, this);
            repaint();
        }
        if(prendiCartaG2){
            prendiCartaG2();
            g.drawImage(cardG2, cartaGiocataG2x, cartaGiocataG2y, this);
            repaint();
        }
        if(prendiG1){
            prendiG1();
            g.drawImage(cardG1, cartaGiocataG1x, cartaGiocataG1y, this);
            repaint();
        }
        if(prendiG2){
            prendiG2();
            g.drawImage(cardG2, cartaGiocataG2x, cartaGiocataG2y, this);
            repaint();
        }
        if (pescaG11) {
            pescaCartaG11();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
        if (pescaG12) {
            pescaCartaG12();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
        if (pescaG13) {
            pescaCartaG13();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
        if (pescaG21) {
            pescaCartaG21();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
        if (pescaG22) {
            pescaCartaG22();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
        if (pescaG23) {
            pescaCartaG23();
            g.drawImage(cardBack, cartaPescataX, cartaPescataY, this);
            repaint();
        }
    }

    private Image getImage(Icon icon) {
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        icon.paintIcon(null, g2, 0, 0);
        return image;
    }

    private void spostaCartaG11() {
        if (G11x > labelCartaGiocataG1.getX()) {
            G11x -= 10;
        }
        if (G11y > labelCartaGiocataG1.getY()) {
            G11y -= 10;
        }
        if (G11x <= labelCartaGiocataG1.getX() && G11y <= labelCartaGiocataG1.getY()) {
            cardG11played = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            ImageIcon img = new ImageIcon(imageG11);
//            cartaPescataX = labelMazzo.getLocationOnScreen().x;
//            cartaPescataY = labelMazzo.getLocationOnScreen().y;
            labelCartaGiocataG1.setIcon(img);
//            pescaG11 = true;
            cardG21played = true;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void spostaCartaG12() {
        if (G12x > labelCartaGiocataG1.getX()) {
            G12x -= 6;
        }
        if (G12y > labelCartaGiocataG1.getY()) {
            G12y -= 10;
        }
        if (G12x <= labelCartaGiocataG1.getX() && G12y <= labelCartaGiocataG1.getY()) {
            cardG12played = false;
            ImageIcon img = new ImageIcon(imageG12);
            labelCartaGiocataG1.setIcon(img);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
//            pescaG12 = true;
//            cartaPescataX = labelMazzo.getLocationOnScreen().x;
//            cartaPescataY = labelMazzo.getLocationOnScreen().y;
            cardG22played = true;
        
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void spostaCartaG13() {
        if (G13x > labelCartaGiocataG1.getX()) {
            G13x -= 10;
        }
        if (G13y > labelCartaGiocataG1.getY()) {
            G13y -= 8;
        }
        if (G13x <= labelCartaGiocataG1.getX() && G13y <= labelCartaGiocataG1.getY()) {
            cardG13played = false;
            ImageIcon img = new ImageIcon(imageG13);
            labelCartaGiocataG1.setIcon(img);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
//            pescaG13 = true;
//            cartaPescataX = labelMazzo.getLocationOnScreen().x;
//            cartaPescataY = labelMazzo.getLocationOnScreen().y;
            cardG23played = true;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void spostaCartaG21() {
        labelCartaG21.setIcon(null);
        if (G21x < labelCartaGiocataG2.getX()) {
            G21x += 10;
        }
        if (G21y < labelCartaGiocataG2.getY()) {
            G21y += 9;
        }
        if (G21x >= labelCartaGiocataG2.getX() && G21y >= labelCartaGiocataG2.getY()) {
            cardG21played = false;

            ImageIcon img = new ImageIcon(imageG21);
            labelCartaGiocataG2.setIcon(img);
            repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            cartaPescataX = labelMazzo.getLocationOnScreen().x;
            cartaPescataY = labelMazzo.getLocationOnScreen().y;
//                pescaG21 = true;
//            pescaG11 = true;
            getPlayedCardsCoordinates();
            prendiCartaG2 = true;
            getPlayedCardsImages();
            prendiCartaG2();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void spostaCartaG22() {
        labelCartaG22.setIcon(null);
        if (G22x < labelCartaGiocataG2.getX()) {
            G22x += 10;
        }
        if (G22y < labelCartaGiocataG2.getY()) {
            G22y += 10;
        }
        if (G22x >= labelCartaGiocataG2.getX() && G22y >= labelCartaGiocataG2.getY()) {
            cardG22played = false;
            ImageIcon img = new ImageIcon(imageG22);
            labelCartaGiocataG2.setIcon(img);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
//            pescaG22 = true;
//            cartaPescataX = labelMazzo.getLocationOnScreen().x;
//            cartaPescataY = labelMazzo.getLocationOnScreen().y;
            getPlayedCardsCoordinates();
            prendiCartaG1 = true;
            getPlayedCardsImages();
            prendiCartaG1();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void spostaCartaG23() {
        labelCartaG23.setIcon(null);
        if (G23x < labelCartaGiocataG2.getX()) {
            G23x += 10;
        }
        if (G23y < labelCartaGiocataG2.getY()) {
            G23y += 8;
        }
        if (G23x <= labelCartaGiocataG2.getX() && G23y >= labelCartaGiocataG2.getY()) {
            cardG23played = false;
            ImageIcon img = new ImageIcon(imageG23);
            labelCartaGiocataG2.setIcon(img);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
//            pescaG23 = true;
//            cartaPescataX = labelMazzo.getLocationOnScreen().x;
//            cartaPescataY = labelMazzo.getLocationOnScreen().y;
            getPlayedCardsCoordinates();
            prendiCartaG2 = true;
            getPlayedCardsImages();
            prendiCartaG2();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
    }

    private void pescaCartaG11() {
        if (cartaPescataX > labelCartaG11.getX()) {
            cartaPescataX -= 10;
        }
        if (cartaPescataY < labelCartaG11.getY()) {
            cartaPescataY += 3;
        }
        if (cartaPescataX <= labelCartaG11.getX() && cartaPescataY >= labelCartaG11.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG11.setIcon(img);
            pescaG11 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void pescaCartaG12() {
        if (cartaPescataX > labelCartaG12.getX()) {
            cartaPescataX -= 7;
        }
        if (cartaPescataY < labelCartaG12.getY()) {
            cartaPescataY += 3;
        }
        if (cartaPescataX <= labelCartaG12.getX() && cartaPescataY >= labelCartaG12.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG12.setIcon(img);
            pescaG12 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void pescaCartaG13() {
        if (cartaPescataX > labelCartaG13.getX()) {
            cartaPescataX -= 3;
        }
        if (cartaPescataY < labelCartaG13.getY()) {
            cartaPescataY += 3;
        }
        if (cartaPescataX <= labelCartaG13.getX() && cartaPescataY >= labelCartaG13.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG13.setIcon(img);
            pescaG13 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void pescaCartaG21() {
        if (cartaPescataX > labelCartaG21.getX()) {
            cartaPescataX -= 10;
        }
        if (cartaPescataY > labelCartaG21.getY()) {
            cartaPescataY -= 8;
        }
        if (cartaPescataX <= labelCartaG21.getX() && cartaPescataY <= labelCartaG21.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG21.setIcon(img);
            
            pescaG21 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void pescaCartaG22() {
        if (cartaPescataX > labelCartaG22.getX()) {
            cartaPescataX -= 5;
        }
        if (cartaPescataY > labelCartaG22.getY()) {
            cartaPescataY -= 5;
        }
        if (cartaPescataX <= labelCartaG22.getX() && cartaPescataY <= labelCartaG22.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG22.setIcon(img);
            pescaG22 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void pescaCartaG23() {
        if (cartaPescataX > labelCartaG23.getX()) {
            cartaPescataX -= 5;
        }
        if (cartaPescataY > labelCartaG23.getY()) {
            cartaPescataY -= 10;
        }
        if (cartaPescataX <= labelCartaG23.getX() && cartaPescataY <= labelCartaG23.getY()) {
            ImageIcon img = new ImageIcon(cardBack);
            labelCartaG23.setIcon(img);
            pescaG23 = false;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    private void prendiCartaG1(){
        labelCartaGiocataG1.setIcon(null);
        if(cartaGiocataG1x < labelCartaGiocataG2.getLocationOnScreen().x){
            cartaGiocataG1x += 5;
        }
        if(cartaGiocataG1x >= labelCartaGiocataG2.getLocationOnScreen().x){
            prendiCartaG1 = false;
            prendiG2 = true;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {}
        }
    }
    
    private void prendiCartaG2(){
        labelCartaGiocataG2.setIcon(null);
        if(cartaGiocataG2x > labelCartaGiocataG1.getLocationOnScreen().x){
            cartaGiocataG2x -= 5;
        }
        if(cartaGiocataG2x <= labelCartaGiocataG1.getLocationOnScreen().x){
            prendiCartaG2 = false;
            prendiG1 = true;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {}
        }
    }
    
    private void prendiG1(){
        pulisciCarteGiocate();
        if(cartaGiocataG1x < labelCartePreseG1.getLocationOnScreen().x){
            cartaGiocataG1x += 6;
        }
        if(cartaGiocataG1y < labelCartePreseG1.getLocationOnScreen().y){
            cartaGiocataG1y += 4;
        }
        if(cartaGiocataG1x >= labelCartePreseG1.getLocationOnScreen().x && 
                cartaGiocataG1y >= labelCartePreseG1.getLocationOnScreen().y){
            prendiG1 = false;
            ImageIcon img = new ImageIcon(cardBack);
            labelCartePreseG1.setIcon(img);
            pescaG11 = true;
        }
    }
    
    private void prendiG2(){
        pulisciCarteGiocate();
        if(cartaGiocataG2x < labelCartePreseG2.getLocationOnScreen().x){
            cartaGiocataG2x += 6;
        }
        if(cartaGiocataG2y > labelCartePreseG2.getLocationOnScreen().y){
            cartaGiocataG2y -= 4;
        }
        if(cartaGiocataG2x >= labelCartePreseG1.getLocationOnScreen().x && 
                cartaGiocataG2y <= labelCartePreseG2.getLocationOnScreen().y){
            prendiG2 = false;
            ImageIcon img = new ImageIcon(cardBack);
            labelCartePreseG2.setIcon(img);
        }
    }

    private void pulisciCarteGiocate() {
        labelCartaGiocataG1.setIcon(null);
        labelCartaGiocataG2.setIcon(null);
    }
    
    private void getPlayedCardsImages() {
        cardG1 = getImage(labelCartaGiocataG1.getIcon());
        cardG2 = getImage(labelCartaGiocataG2.getIcon());
    }
    
    private void getPlayedCardsCoordinates(){
        cartaGiocataG2x = labelCartaGiocataG2.getLocationOnScreen().x;
        cartaGiocataG2y = labelCartaGiocataG2.getLocationOnScreen().y;
        cartaGiocataG1x = labelCartaGiocataG1.getLocationOnScreen().x;
        cartaGiocataG1y = labelCartaGiocataG1.getLocationOnScreen().y;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCartaG11 = new javax.swing.JLabel();
        labelCartaG12 = new javax.swing.JLabel();
        labelCartaG13 = new javax.swing.JLabel();
        labelCartaG21 = new javax.swing.JLabel();
        labelCartaG22 = new javax.swing.JLabel();
        labelCartaG23 = new javax.swing.JLabel();
        labelMazzo = new javax.swing.JLabel();
        labelBriscola = new javax.swing.JLabel();
        labelCartaGiocataG2 = new javax.swing.JLabel();
        labelCartaGiocataG1 = new javax.swing.JLabel();
        labelCartePreseG2 = new javax.swing.JLabel();
        labelCartePreseG1 = new javax.swing.JLabel();

        labelCartaG11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/01d.png"))); // NOI18N
        labelCartaG11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCartaG11MouseClicked(evt);
            }
        });

        labelCartaG12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/02d.png"))); // NOI18N
        labelCartaG12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCartaG12MouseClicked(evt);
            }
        });

        labelCartaG13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/03d.png"))); // NOI18N
        labelCartaG13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCartaG13MouseClicked(evt);
            }
        });

        labelCartaG21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/yugiohVerticale.png"))); // NOI18N

        labelCartaG22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/yugiohVerticale.png"))); // NOI18N

        labelCartaG23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/yugiohVerticale.png"))); // NOI18N

        labelMazzo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/yugiohOrrizzontale.png"))); // NOI18N

        labelBriscola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/Immagini/04dS.png"))); // NOI18N
        labelBriscola.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCartaG11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCartaG12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCartaG21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCartaG22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCartaGiocataG1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCartaG23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(labelCartePreseG2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCartaGiocataG2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCartaG13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(labelMazzo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(labelBriscola, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(labelCartePreseG1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCartaG21, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCartaG22, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCartaG23, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCartePreseG2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCartaGiocataG2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCartaGiocataG1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCartaG12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCartaG11, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCartaG13, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(labelBriscola, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMazzo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCartePreseG1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelCartaG11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCartaG11MouseClicked
        // TODO add your handling code here:
        imageG11 = getImage(labelCartaG11.getIcon());
        this.labelCartaG11.setIcon(null);
        G11x = labelCartaG11.getLocationOnScreen().x;
        G11y = labelCartaG11.getLocationOnScreen().y;
        cardG11played = true;
        repaint();
    }//GEN-LAST:event_labelCartaG11MouseClicked

    private void labelCartaG12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCartaG12MouseClicked
        // TODO add your handling code here:
        imageG12 = getImage(labelCartaG12.getIcon());
        this.labelCartaG12.setIcon(null);
        G12x = labelCartaG12.getLocationOnScreen().x;
        G12y = labelCartaG12.getLocationOnScreen().y;
        cardG12played = true;
        G22x = labelCartaG22.getLocationOnScreen().x;
        G22y = labelCartaG22.getLocationOnScreen().y;
        repaint();
    }//GEN-LAST:event_labelCartaG12MouseClicked

    private void labelCartaG13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCartaG13MouseClicked
        // TODO add your handling code here:
        imageG13 = getImage(labelCartaG13.getIcon());
        this.labelCartaG13.setIcon(null);
        G13x = labelCartaG13.getLocationOnScreen().x;
        G13y = labelCartaG13.getLocationOnScreen().y;
        cardG13played = true;
        
        G23x = labelCartaG23.getLocationOnScreen().x;
        G23y = labelCartaG23.getLocationOnScreen().y;
        repaint();
    }//GEN-LAST:event_labelCartaG13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel labelBriscola;
    private javax.swing.JLabel labelCartaG11;
    private javax.swing.JLabel labelCartaG12;
    private javax.swing.JLabel labelCartaG13;
    private javax.swing.JLabel labelCartaG21;
    private javax.swing.JLabel labelCartaG22;
    private javax.swing.JLabel labelCartaG23;
    private javax.swing.JLabel labelCartaGiocataG1;
    private javax.swing.JLabel labelCartaGiocataG2;
    private javax.swing.JLabel labelCartePreseG1;
    private javax.swing.JLabel labelCartePreseG2;
    private javax.swing.JLabel labelMazzo;
    // End of variables declaration//GEN-END:variables

    
}
