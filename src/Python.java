import java.awt.Color;
import java.util.LinkedList;

public class Python {

	private LinkedList length;
	private boolean alive;
	private boolean ateFruit;
	private Color color;
	
	public Python() {
		length = new LinkedList();
		length.add(1);
		length.add(1);
		length.add(1);
		
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
