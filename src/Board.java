import java.util.Arrays;

public class Board {
	private String[][] squares;
	private Python jack;
	private Fruit currFruit;
	private int size;
	
	public Board(int size, int x, int y) {
		this.size = size;
		squares = new String[this.size][this.size];
		jack = new Python();
		
		x -= 1;
		y -= 1;
		// starts jack at 4. 7
		for (int i = 0; i < 3; i++) {
			squares[y][x-i] = "s";
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
		int[] head = this.jack.getHead();
		int[] tail = this.jack.getTail();
		System.out.println(Arrays.deepToString(this.squares));
		switch(direction) {
			case "Right":
				head[1] = head[1] + 1;
				this.squares[head[1]][head[0]] = "s";
				this.squares[tail[1]][tail[0]] = null;
				tail[1] = tail[1] + 1;
				break;
			case "Left":
				head[0] = head[0] - 1;
				tail[0] = tail[0] - 1;
				break;
			case "Up":
				head[1] = head[1] + 1;
				tail[1] = tail[1] + 1;
				break;
			case "Down":
				head[1] = head[1] - 1;
				tail[1] = tail[1] - 1;
				break;
			default:
				break;
		}
		
		System.out.println(Arrays.deepToString(this.squares));
		this.jack.setTail(tail);
		this.jack.setHead(head);
	}
	
	private void updateBoard(int[] oldHead, int[] oldTail) {
		
	}
	
	public boolean moveSnake() {
		return false;
	}
	
	
}
