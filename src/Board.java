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
		// If fruit is eaten
		// If in a 2 block radius of the snake do not place fruit there
		// Place fruit in a random location on board
	}
	
	public void updateSnakePos(String direction) {
		
		// this.direction = direction;

		switch(direction) {
			case "Right":
				
				// moveSnakeLoop();
				
				// Have an If statement here (If the user clicks diff key)
				// break
				// Else recursively call so snake keeps moving
				
				if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY+1)) {
					this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY+1);
					this.jack.currentHeadY++;
					this.jack.removePoint();
				}
				
				
				if(this.jack.currentHeadY == 17) {
					
					//Game Ended(COLLISION OCCURED)
				}
				break;
			case "Left":
				if(!this.jack.isPoint(this.jack.currentHeadX, this.jack.currentHeadY-1)) {
					this.jack.addPoint(this.jack.currentHeadX, this.jack.currentHeadY-1);
					this.jack.currentHeadY--;
					this.jack.removePoint();
					if(this.jack.currentHeadY == 0) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			case "Up":
				if(!this.jack.isPoint(this.jack.currentHeadX - 1, this.jack.currentHeadY)) {
					this.jack.addPoint(this.jack.currentHeadX - 1, this.jack.currentHeadY);
					this.jack.currentHeadX--;
					this.jack.removePoint();
					if(this.jack.currentHeadX == 0) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			case "Down":
				if(!this.jack.isPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY)) {
					this.jack.addPoint(this.jack.currentHeadX + 1, this.jack.currentHeadY);
					this.jack.currentHeadX++;
					this.jack.removePoint();
					if(this.jack.currentHeadX == 17) {
						//Game Ended(COLLISION OCCURED)
					}
				}
				break;
			default:
				break;
		}
		
	
	
	}
	
	private void updateBoard(int[] oldHead, int[] oldTail) {
		
	}
	
	public boolean moveSnake() {
		return false;
	}
	
	
}
