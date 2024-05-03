import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

public class Python {

	private ArrayList<Point> points;
	private boolean alive;
	private boolean ateFruit;
	private Color color;
	
	public Python() {
		alive = true;
		color = Color.BLUE;
		
		points = new ArrayList<>();
		points.add(new Point(6, 3));
		points.add(new Point(6, 2));
		points.add(new Point(6, 1));
	}
	
	public void handleLength() {
		// add one to head
		// in future: type of fruit
	}
	
	public void eatFruit() {
		this.ateFruit = true;
	}
	
	public void moveRight() {
		
	}
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
}
