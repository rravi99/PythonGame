import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

public class Python {

	private ArrayList<Point> points;
	private boolean alive;
	private boolean ateFruit;
	private Color color;
	public int currentHeadY;
	public int currentHeadX;
	public Python() {
		alive = true;
		color = Color.BLUE;
		
		points = new ArrayList<>();
		points.add(new Point(6, 1));
		points.add(new Point(6, 2));
		points.add(new Point(6, 3));
		currentHeadY = points.get(2).getCol();
		currentHeadX = points.get(2).getRow();
	}
	
	public void handleLength() {
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
	public void addPoint(int x, int y) {
		points.add(new Point(x, y));
	}
	public void removePoint() {
		points.remove(0);
	}
	public boolean isPoint(int x, int y) {
		for (int i = 0; i < points.size(); i++) {
		    if(points.get(i).getRow() == x && points.get(i).getCol() == y) {
		    	return true;
		    }
		    
		}
		return false;
	}
	
}
