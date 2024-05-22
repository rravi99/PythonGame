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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
    private BufferedImage image;
    private int score;
    private Point snakeHead;
    private Point fruitCoord;
   
    // TODO: have instance fields for the current turn and what the AI is (X or O)

    // Keep this instance field
  

    public GamePanel() {
        board = new Board(17, 7, 4);
        createKeyHandlers();
        this.setFocusable(true);
        
    	URL resource;
    	resource = getClass().getResource("Fruit/grass.png");
    	
    	try {
    		image = ImageIO.read(resource);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	snakeHead = new Point(0,0);
    	fruitCoord = new Point(0,0);
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
        //g.setColor(new Color(179,185,178));
       // g.drawRect(0, 0, this.getWidth(), this.getHeight()/9);
        //g.fillRect(0, 0, this.getWidth(), this.getHeight()/9);
        int cellWidth = this.getWidth() / 17;
        int cellHeight = (this.getHeight() - this.getHeight()/9)/ 17;

        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;

        
        g.setColor(Color.BLACK);
        for (int i = 1; i < 17; i++) {
            g.drawLine(cellWidth * i, this.getHeight() / 9, cellWidth * i, this.getHeight());
            g.drawLine(0, this.getHeight() / 9 + cellHeight * i, this.getWidth(), this.getHeight() / 9 + cellHeight * i);
        }
        
       
        //g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(), this);
        g.setColor(new Color(179,185,178));
        g.fillRect(0, 0, this.getWidth(), this.getHeight()/9);
        drawSnake(g);
        drawFruit(g);
        //System.out.printf("Panel width: %d, Panel height: %d\n", this.getWidth(), this.getHeight());
        
      /*  Thread one = new Thread() {
			public void run() {
			try {
				while (true) {
					Thread.sleep(1000);
					board.updateSnakePos("Right");
				}
				
>>>>>>> refs/remotes/origin/main

			} catch(InterruptedException v) {
			System.out.println(v);
			}
			}
			};
			one.run();
*/
    }
    
    private void drawSnake(Graphics g) {
    	Python jack = this.board.getPython();
    	ArrayList<Point> points = jack.getPoints();
    	
    	for (Point point : points) {
    		g.setColor(jack.getColor());
			g.fillRect(point.getCol() * this.cellWidth, point.getRow() * this.cellHeight + (this.getHeight() / 9),this.cellWidth, this.cellHeight);
			
    	}
    	
    	int col = points.get(points.size()-1).getCol();
    	int row = points.get(points.size()-1).getRow();
    	snakeHead = new Point(row + 1, col + 2);
    	//int row = snakeHead.getRow();
    	//snakeHead.setRow(snakeHead.getCol() * this.cellWidth );
    	//snakeHead.setCol(row * this.cellHeight + (this.getHeight() / 9));
    	//snakePoints = point.get(points.size-1);
    	//g.setColor(Color.BLACK);
    	//g.fillOval(points.get(points.size() - 1).getCol() * this.cellWidth, points.get(points.size() - 1).getRow() * this.cellHeight, cellHeight/5, cellHeight/5);
    }

    private void drawFruit(Graphics g) {
    	
    	
    	Fruit fruit = board.getFruit();
    	Point fruitLoc = fruit.getFruitLoc();
    	
    	BufferedImage image = null;
    	URL resource;
    	resource = getClass().getResource(fruit.getFruitPath());
    	
    	try {
    		image = ImageIO.read(resource);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	int xCoord = (fruitLoc.getCol() * this.cellWidth) + cellWidth/6; 
    	
    	
    	for (Point point: this.board.getPython().getPoints()) {
    		if (xCoord == (point.getCol() * this.cellWidth)) {
    			xCoord += cellWidth * 2;
    		}
    	}
    	
    	
    	int yCoord = (fruitLoc.getRow() * this.cellHeight); //- (cellHeight/2);
    	// prevents fruit from being on the grey rectangle
    	if (yCoord <= (this.getHeight()/9)) {
    		yCoord += (this.getHeight() / 9) * 2;
    	}
    	
    	fruitCoord = new Point(fruitLoc.getRow(), fruitLoc.getCol() + 2);
    	
    	//System.out.printf("(%d, %d)\n", fruitLoc.getCol() * this.cellWidth, yCoord);
    	g.drawImage(image, xCoord, yCoord, image.getWidth()/4, image.getHeight()/4, this);
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
    			//System.out.println(k.getKeyText(k.getKeyCode()));
    			board.updateSnakePos(k.getKeyText(k.getKeyCode()));
 
    			/*for(int i = 0; i < 5; i++) {
    				//System.out.print("IN LOOP" + k.getKeyText(k.getKeyCode()));
    				try {
    					TimeUnit.MILLISECONDS.sleep(20);
    					GamePanel.this.repaint();
        				board.updateSnakePos(k.getKeyText(k.getKeyCode()));
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    				
    			} */
    			
    			
    			if ( (Math.abs(snakeHead.getRow() - fruitCoord.getRow()) <= 2) && Math.abs((snakeHead.getCol() - fruitCoord.getCol())) <= 2) {
    				System.out.println("eat");
    			}
    				System.out.printf("snake head coord: (%d, %d)\n", snakeHead.getRow(), snakeHead.getCol());
    				System.out.printf("fruit coord: (%d, %d)\n\n", fruitCoord.getRow(), fruitCoord.getCol());
    			
    			
    			GamePanel.this.repaint();
    		}
    	});
    }




}
