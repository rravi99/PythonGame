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
	private Point currentTail;
	private String direction;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Python() {
		alive = true;
		color = Color.BLUE;
		
		points = new ArrayList<>();
		points.add(new Point(1, 6));
		points.add(new Point(2, 6));
		points.add(new Point(3, 6));
		
		// might not work for checking pos-only calculated at beginning?
		currentHeadX = points.get(2).getX();
		currentHeadY = points.get(2).getY();
	}
	
	public void handleLength() {
		// in future: type of fruit
	}
	
	public void eatFruit() {
		this.ateFruit = true;
	}
	
	public void moveRight() {
		
	}
	
	public boolean ateFruit(Point fruitCoord) {
		return (currentHeadX == fruitCoord.getX()) && (currentHeadY == fruitCoord.getY());
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
	
	
	public int getCurrentHeadY() {
		return currentHeadY;
	}

	public void setCurrentHeadY(int currentHeadY) {
		this.currentHeadY = currentHeadY;
	}

	public int getCurrentHeadX() {
		return currentHeadX;
	}

	public void setCurrentHeadX(int currentHeadX) {
		this.currentHeadX = currentHeadX;
	}

	// swapped x and y, not sure where used: check on that
	public void addPoint(int x, int y) {
		points.add(new Point(x, y));
	}
	
	public void removePoint() {
		points.remove(0);
	}
	
	// checks if jack is running (slithering?) over himself
	public boolean isPoint(int x, int y) {
		for (int i = 0; i < points.size(); i++) {
		    if(points.get(i).getX() == x && points.get(i).getY() == y) {
		    	return true;
		    }
		    
		}
		return false;
	}
	
}
