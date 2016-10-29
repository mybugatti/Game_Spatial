package gameSource;

import javax.swing.JFrame;

public class GameY extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static GameY gameY;
    private int WIDTH = 800, HEIGHT = 700;
    
    public GameY() {
	
	this.add(new PanelGame());
	this.setSize(WIDTH, HEIGHT);
	this.setResizable(false);
	this.setVisible(true);
	
    }

    public static void main(String[] args) {
	
	gameY = new GameY();
	
    }

}
