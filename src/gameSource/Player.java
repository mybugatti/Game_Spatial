package gameSource;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Entity {
    
    public int xMotion = 0, yMotion = 0;
    public int speed = 3;
    public PanelGame panelgame;
    
    public Player(int x, int y) {
	super(x, y);
    }
    
    public void update() {
	
	this.x += xMotion;
	this.y += yMotion;
	
	this.checkCollisions();
	
    }
    
    public void checkCollisions() {
	
	ArrayList<Enemy> enemylist = PanelGame.getEnemyList();
	
	for( int i = 0; i < enemylist.size(); i++) {
	    
	    Enemy e = enemylist.get(i);

	    if(getBounce().intersects(e.getBounce())) {

		//JOptionPane.showMessageDialog(null, "Fin Mission " + PanelGame.level);
		//System.exit(0);
		//PanelGame.removeEnemy(e);
	    }
	}
    }
    
    public Rectangle getBounce (){
	return new Rectangle(x, y, getImage().getWidth(null), getImage().getHeight(null));
    }
    
    public void draw(Graphics2D gd) {
	
	gd.drawImage(this.getImage(), x, y, null);
	gd.draw(getBounce());
	
	
	ArrayList<Enemy> enemylist = PanelGame.getEnemyList();
	
	for( int i = 0; i < enemylist.size(); i++) {
	    
	    Enemy e = enemylist.get(i);

	    if(getBounce().intersects(e.getBounce())) {
		gd.setColor(Color.RED);
		gd.setFont(new Font("Arial", 12, 30));
		gd.drawString("ECHEC ", 360, 200);
		PanelGame.gameOver();
	    }
	}
    }
    
    public Image getImage() {
	
	ImageIcon icon = new ImageIcon("img/d.png");
	return icon.getImage();
	
    }
    
    public void keyPressed(KeyEvent k) {
	
	int code = k.getKeyCode();

	if (code == KeyEvent.VK_RIGHT ) {

	    xMotion = 2 * speed;
	    
	} else if (code == KeyEvent.VK_LEFT) {
	    
	    xMotion = -2 * speed;
	    
	} else if (code == KeyEvent.VK_UP) {
	    
	   // yMotion = -2;
	    
	} else if (code == KeyEvent.VK_DOWN) {
	    
	   // yMotion = 2;
	    
	} else if (code == KeyEvent.VK_SPACE) {
	    
	    Thread t = new Thread();
	    t.start();
	    Missile e = new Missile(x,y);
	    
	    try {
		Thread.sleep(10);
		 PanelGame.missile.add(e);
	    } catch (InterruptedException e1) {

		e1.printStackTrace();
	    }
	   
	}
    }
    
    public void keyReleased(KeyEvent k) {
	
	int code = k.getKeyCode();

	if (code == KeyEvent.VK_RIGHT ) {

	    xMotion = 0;
	    
	} else if (code == KeyEvent.VK_LEFT) {
	    
	    xMotion = 0;
	    
	} else if (code == KeyEvent.VK_UP) {
	    
	    yMotion = 0;
	    
	} else if (code == KeyEvent.VK_DOWN) {
	    
	    yMotion = 0;
	}
    }

    public void keyTyped(KeyEvent e) {

    }

}
