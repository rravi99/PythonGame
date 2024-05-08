import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Fruit {
	private Image fruit;
	
	
	public Fruit() {
		//this.fruit = //Image of apple
		URL resource;
        BufferedImage image = null;
        	try {
                image = ImageIO.read(resource);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
          
	}
	
	public Fruit(Image fruit) {
		this.fruit = fruit;
	}
	
	
	
	
	
}
