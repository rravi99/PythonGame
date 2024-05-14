import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Fruit {
	private String fruitPath;
	private Point fruitLoc;
	
	
	public Fruit() {
		//this.fruit = //Image of apple
		this.fruitPath = "Fruit/Apple.png";
		
		this.fruitLoc = new Point(((int) (Math.random() * 15) + 1), ((int) (Math.random() * 16)));
		
          
	}


	public String getFruitPath() {
		return fruitPath;
	}


	public void setFruitPath(String fruitPath) {
		this.fruitPath = fruitPath;
	}


	public Point getFruitLoc() {
		return fruitLoc;
	}


	public void setFruitLoc(Point fruitLoc) {
		this.fruitLoc = fruitLoc;
	}
	
	/*
	public Fruit(Image fruit) {
		this.fruit = fruit;
	}
	*/
	
	
	
	
	
}
