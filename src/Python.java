import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

public class Python {

	private ArrayList<Integer> length;
	private boolean alive;
	private boolean ateFruit;
	private Color color;
	
	public Python() {
		length = new ArrayList<>();
		length.add(0);
		length.add(1);
		length.add(2);
		alive = true;
		color = Color.GREEN;
	}
	
	public void handleLength() {
		// add one to head
		// in future: type of fruit
	}
	
	public void eatFruit() {
		this.ateFruit = true;
	}
	
}
