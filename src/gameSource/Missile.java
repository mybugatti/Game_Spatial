package gameSource;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends Entity {

    public Missile(int x, int y) {
	super(x, y);
    }

    public void draw(Graphics2D gd) {
	
	gd.drawImage(this.getImage(), x, y, null);
    }
    
    public Image getImage() {
	
	ImageIcon icon = new ImageIcon("img/m.png");
	return icon.getImage();
	
    }
    
    
    public Rectangle getBounce (){
	
	return new Rectangle(x, y, getImage().getWidth(null), getImage().getHeight(null));
    }
    
    public void update() {
	
	this.y-=6;
    }
}
