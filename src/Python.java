import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

public class Python {

	private ArrayList<Integer> length;
	private boolean alive;
	private boolean ateFruit;
	private Color color;
	private int[] head;
	private int[] tail;
	
	public Python() {
		length = new ArrayList<>();
		length.add(0);
		length.add(1);
		length.add(2);
		alive = true;
		color = Color.GREEN;
		this.head = new int[] {4, 7};
		this.tail = new int[] {1, 6};
	}
	
	public void handleLength() {
		// add one to head
		// in future: type of fruit
	}
	
	public void eatFruit() {
		this.ateFruit = true;
	}
	
	public int[] getHead() {
		return this.head;
	}
	
	public int[] getTail() {
		return this.tail;
	}
	
	public void setTail(int[] tail) {
		this.tail = tail;
	}
	
	public void setHead(int[] head) {
		this.head = head;
	}
}
