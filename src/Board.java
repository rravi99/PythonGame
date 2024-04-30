
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
			squares[x][y-i] = "s";
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
		
	}
	
	public boolean moveSnake() {
		return false;
	}
	
	
}
