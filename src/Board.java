import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.management.timer.Timer;

public class Board {
	private String[][] squares;
	private Python jack;
	private Fruit currFruit;
	private int size;
	
	
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
		for (Point point : this.getPython().getPoints()) {
			if ((point.getX() + 1 == fruitLoc.getX()) && (point.getY() - 1 == fruitLoc.getY())) {
				addFruit();
			}
		}
	}
	
	public void updateSnakePos(String direction) {
		
		// this.direction = direction;

		switch(direction) {
			//case "Right":
			case "→":
				
				
				// moveSnakeLoop();
				
				// Have an If statement here (If the user clicks diff key)
				// break
				// Else recursively call so snake keeps moving
				
				if(!this.jack.isPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY)) {
					//System.out.println("Old Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					this.jack.addPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY);
					this.jack.currentHeadX++;
					//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					this.jack.removePoint();
					//System.out.println(jack.getPoints().toString());
					
					if(currFruit.getFruitLoc().getY() == this.jack.currentHeadY && currFruit.getFruitLoc().getX() == this.jack.currentHeadX) {
						System.out.println("EATEN");
					}
					//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
				}
				
				
				if(this.jack.currentHeadY == 17) {
					
					//Game Ended(COLLISION OCCURED)
				}
				break;
			//case "Left":
			case "←":
				if(!this.jack.isPoint(this.jack.currentHeadX -1, this.jack.currentHeadY)) {
					this.jack.addPoint(this.jack.currentHeadX - 1, this.jack.currentHeadY);
					this.jack.currentHeadX--;
					this.jack.removePoint();
					//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					if(this.jack.currentHeadX == 0) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			//case "Up":
			case "↑":
				if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY - 1)) {
					this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY - 1);
					this.jack.currentHeadY--;
					this.jack.removePoint();
					//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					if(this.jack.currentHeadY == 0) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			//case "Down":
			case "↓":
				if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY + 1)) {
					//System.out.println("Old Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY + 1);
					this.jack.currentHeadY++;
					//System.out.println("New Head: " + this.jack.currentHeadX + ", " +  this.jack.currentHeadY);
					this.jack.removePoint();
					if(this.jack.currentHeadY == 17) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			default:
				//System.out.println("reached default");
				break;
		}
		
	
	
	}
	
	private void updateBoard(int[] oldHead, int[] oldTail) {
		
	}
	
	public boolean moveSnake() {
		return false;
	}
	
	
}
