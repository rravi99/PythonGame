// You must KEEP a few methods as commented below.
// Otherwise, add methods to implement a GUI version of TicTacToe


/*
 This class is responsible for:
    - drawing the TicTacToe board.
    - receiving user clicks and interaction (user events)
    - forwarding all user events appropriately

 All user interactions should be abstracted and forwarded to TicTacToe classes.
*/


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private Board board;
   
    // TODO: have instance fields for the current turn and what the AI is (X or O)

    // Keep this instance field
  

    public GamePanel() {
        board = new Board(17, 7, 4);
        createKeyHandlers();
        this.setFocusable(true);
    }

    // Keep this method!

    @Override
    public void paintComponent(Graphics g){  
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(new Color(106,211,87));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // draw the Game board hash marks and X's and O's
        // for now, just draw some text
        // g.setColor(Color.BLACK);
        // g.drawString("Game Board", 100,100);
        g.setColor(new Color(179,185,178));
       // g.drawRect(0, 0, this.getWidth(), this.getHeight()/9);
        g.fillRect(0, 0, this.getWidth(), this.getHeight()/9);
        int cellWidth = this.getWidth() / 17;
        int cellHeight = (this.getHeight() - this.getHeight()/9)/ 17;

        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;

        g.setColor(Color.BLACK);
        for (int i = 1; i < 17; i++) {
            g.drawLine(cellWidth * i, this.getHeight() / 9, cellWidth * i, this.getHeight());
            g.drawLine(0, this.getHeight() / 9 + cellHeight * i, this.getWidth(), this.getHeight() / 9 + cellHeight * i);
        }
        drawSnake(g);
        

    }
    
    private void drawSnake(Graphics g) {
    	Python jack = this.board.getPython();
    	
    	for (Point point : jack.getPoints()) {
    		g.setColor(jack.getColor());
			g.fillRect(point.getCol() * this.cellWidth, point.getRow() * this.cellHeight + (this.getHeight() / 9),this.cellWidth, this.cellHeight);
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
    private void createKeyHandlers() {
    	this.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent k) {
    			//System.out.println("HEY");
    			System.out.println(k.getKeyText(k.getKeyCode()));
    			board.updateSnakePos(k.getKeyText(k.getKeyCode()));
    			GamePanel.this.repaint();
    		}
    	});
    }




}
