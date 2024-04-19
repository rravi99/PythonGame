
public class Board {
	private String[][] squares;
	private Python jack;
	private Fruit currFruit;
	private int size;
	
	public Board(int size) {
		this.size = size;
		squares = new String[this.size][this.size];
		// Initializing python and fruit
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
	
	private void updateSnakePos() {
		
	}
	
	public boolean moveSnake() {
		return false;
	}
	
	
}
