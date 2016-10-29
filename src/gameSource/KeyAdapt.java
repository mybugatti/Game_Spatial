package gameSource;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
    
    Player player;
    
    public KeyAdapt(Player player) {

	this.player = player;
    }
    
    public void keyPressed(KeyEvent k) {
 
	this.player.keyPressed(k);
    }
    
    public void keyReleased(KeyEvent k) {
	
	this.player.keyReleased(k);
    }
}
