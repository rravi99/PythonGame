import java.sql.Date;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import javax.management.timer.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Board {
	private String[][] squares;
	private Python jack;
	private Fruit currFruit;
	private int size;
	private String direction;
	public Point lastPoint;
	
	public Board(int size, int x, int y) {
		this.size = size;
		squares = new String[this.size][this.size];
		jack = new Python();
		addFruit();
		
		// starts jack at 4. 7
		for (int i = 0; i < 3; i++) {
			squares[x-1][y-1-i] = "s";
		}
		
		
		
	}
	
	public void initaiteMovement() {
		
	}
	private void moveSnakeLoop() {
		System.out.println("Moved snake");
		if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY+1)) {
			this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY+1);
			this.jack.currentHeadY++;
			this.jack.removePoint();
		}
	}
	public Python getPython() {
		return this.jack;
	}
	public Fruit getFruit() {
		return this.currFruit;
	}
	public String[][] getSquares() {
		return this.squares;
	}
	
	public void addFruit() {
		this.currFruit = new Fruit();
		Point fruitLoc = this.currFruit.getFruitLoc();
		
		int x = fruitLoc.getX() + 1;
		int y = fruitLoc.getY();
    	
    	if (y == 2 || y == 0) {
    		y += 1;
    	}else if (y >= 1) {
    		y -= 1;
    	}
		
		
		for (Point point : jack.getPoints()) {
			if ((point.getX() == x) && (point.getY() == y)) {
				addFruit();
			}
		}
	}
	
public void updateSnakePos(String direction) {
		
		// this.direction = direction;

		switch(direction) {
			//case "Right":
			case "→":
				this.direction = "right";
				
				// moveSnakeLoop();
				
				// Have an If statement here (If the user clicks diff key)
				// break
				// Else recursively call so snake keeps moving
				
				moveRight();
				break;
			//case "Left":
			case "←":
				this.direction = "left";
				moveLeft();
				
				
				/*SwingUtilities.invokeLater( () -> {
				try {
					GamePanel gamePanel = new GamePanel();
					gamePanel.makeRepaint();
				    Thread.sleep(1000);               
				    } 
				 catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				 }
				moveLeft();
				
				}); 
				SwingUtilities.invokeLater(() -> {
			        // ... (rest of your code)
			        Timer timer = new Timer(1000, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                moveLeft();  // Perform the second move left
			                GamePanel gamePanel = new GamePanel();
			                gamePanel.makeRepaint(); // Repaint immediately after the delay
			            }
			        });
			        timer.setRepeats(false);  // Ensure the timer only runs once
			        timer.start();  // Start the timer 
			    });
			*/

				break;
			//case "Up":
			case "↑":
				this.direction = "up";
				moveUp();
				
				break;
			//case "Down":
			case "↓":
				this.direction = "down";
				moveDown();
				break;
			default:
				//System.out.println("reached default");
				break;
		}
		
	
	
	}
	
	private void moveDown() {
		if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY + 1)) {
			//System.out.println("Old Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY + 1);
			this.jack.currentHeadY++;
			//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			this.lastPoint = this.jack.removePoint();
			if(this.jack.currentHeadY == 17) {
				//Game Ended(COLLISION OCCURED)
			}
		}
	}
	
	private void moveUp() {
		if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY - 1)) {
			this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY - 1);
			this.jack.currentHeadY--;
			this.lastPoint = this.jack.removePoint();
			//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			if(this.jack.currentHeadY == 0) {
				//Game Ended(COLLISION OCCURED)
			}
		}
	}
	private void moveLeft() {
		if(!this.jack.isPoint(this.jack.currentHeadX -1, this.jack.currentHeadY)) {
			this.jack.addPoint(this.jack.currentHeadX - 1, this.jack.currentHeadY);
			this.jack.currentHeadX--;
			this.lastPoint = this.jack.removePoint();
			//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			if(this.jack.currentHeadX == 0) {
				//Game Ended(COLLISION OCCURED)
			}
		}
	}
	private void moveRight() {
		if(!this.jack.isPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY)) {
			//System.out.println("Old Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			this.jack.addPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY);
			this.jack.currentHeadX++;
			//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
			this.lastPoint = this.jack.removePoint();
			//System.out.println(jack.getPoints().toString());
			
			if(currFruit.getFruitLoc().getY() == this.jack.currentHeadY && currFruit.getFruitLoc().getX() == this.jack.currentHeadX) {
				System.out.println("EATEN");
			}
			//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
		}
		
		
		if(this.jack.currentHeadY == 17) {
			
			//Game Ended(COLLISION OCCURED)
		}
	}
	public void schedule(TimerTask task, Date time) {
		
	}
	
	private void updateBoard(int[] oldHead, int[] oldTail) {
		
	}
	
	public boolean moveSnake() {
		return false;
	}

	public void addanotherPoint() {
		this.jack.addPoint(this.lastPoint.getX(), this.lastPoint.getY(), 0);
		
	}
	
	
}