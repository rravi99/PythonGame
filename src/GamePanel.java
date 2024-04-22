// You must KEEP a few methods as commented below.
// Otherwise, add methods to implement a GUI version of TicTacToe


/*
 This class is responsible for:
    - drawing the TicTacToe board.
    - receiving user clicks and interaction (user events)
    - forwarding all user events appropriately

 All user interactions should be abstracted and forwarded to TicTacToe classes.
*/



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class GamePanel extends JPanel {
    private int cellWidth;
    private int cellHeight;
   
    // TODO: have instance fields for the current turn and what the AI is (X or O)

    // Keep this instance field
  

    public GamePanel() {
        
    }

    // Keep this method!

    @Override
    public void paintComponent(Graphics g){  
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        // draw the Game board hash marks and X's and O's
        // for now, just draw some text
        // g.setColor(Color.BLACK);
        // g.drawString("Game Board", 100,100);

        int cellWidth = this.getWidth() / 17;
        int cellHeight = this.getHeight() / 17;

        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;


        for (int i = 1; i < 17; i++) {
            g.drawLine(cellWidth * i, 0, cellWidth * i, this.getHeight());
            g.drawLine(0, cellHeight * i, this.getWidth(), cellHeight * i);
        }

    }

    /**
     * This allows this dialog to be drawn at a good size.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MainFrame.WIDTH, MainFrame.HEIGHT);
    }


    private void handleClick(MouseEvent e) {
        int col = e.getX() / cellWidth;
        int row = e.getY() / cellHeight;

            System.out.println(row);
            System.out.println(col);
         

      
        repaint();
        }




}
