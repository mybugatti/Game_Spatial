package gameSource;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity {

    public int startY;
    public static int speed = 1;
    
    public Enemy(int x, int y) {
	super(x, y);
	this.startY= y;
    }

    public void draw(Graphics2D gd) {
	
	gd.drawImage(this.getImage(), x, y, null);
	gd.draw(getBounce());
    }
    
    public Image getImage() {
	
	ImageIcon icon = new ImageIcon("img/e.png");
	return icon.getImage();
	
    }
    
    public Rectangle getBounce (){
	
	return new Rectangle(x, y, getImage().getWidth(null), getImage().getHeight(null));
    }
    

    public void checkOffScreen() {

	if(y >= 750 ) {

	    y = startY;
	}
    }
    public void checkCollision() {
	
	for (int i = 0; i < PanelGame.getMissileList().size(); i++) {
	   
	    Missile m = PanelGame.getMissileList().get(i);
	    
	    if(getBounce().intersects(m.getBounce())) {
		
		PanelGame.removeEnemy(this);
		PanelGame.removeMissile(m);;
	    }
	}
    }
    
    public void update() {
	
	this.checkOffScreen();
	this.checkCollision();
	this.y+=1 * speed;
    }

}
