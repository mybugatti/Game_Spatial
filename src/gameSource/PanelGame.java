package gameSource;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelGame extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<Missile> missile;

    public int enemyCount = 5;
    public static int level = 2;
    public Random rand;
    Timer maintimers;
    Player player;
    Enemy enemy;

    public PanelGame() {

	this.setFocusable(true);

	enemies = new ArrayList<Enemy>();
	missile = new ArrayList<Missile>();

	rand = new Random();

	player = new Player(100,618);
	this.addKeyListener(new KeyAdapt(player));

	maintimers = new Timer(20,this);
	maintimers.start();

	startGame();
    }

    public void addEnemy(Enemy e) {

	PanelGame.enemies.add(e);

    }

    public static ArrayList<Enemy> getEnemyList() {
	return enemies;
    }

    public static void removeEnemy(Enemy e) {

	enemies.remove(e);
    }

    public void addEnemy(Missile m) {

	PanelGame.missile.add(m);

    }

    public static ArrayList<Missile> getMissileList() {
	return missile;
    }

    public static void removeMissile(Missile m) {

	missile.remove(m);
    }
    
    public static void gameOver() {
	
	PanelGame.enemies.clear();
	PanelGame.missile.clear();
	
    }
    
    public void startGame() {

	enemyCount = level * 3;

	for(int i = 0; i < enemyCount; i++) {

	    this.addEnemy(new Enemy(rand.nextInt(700), -10 + -rand.nextInt(600)));

	}
    }


    public void checkEnd() {

	if(enemies.size() == 0 ) {

	    PanelGame.level++;
	    Enemy.speed++; 
	    enemies.clear();
	    missile.clear();
	    startGame();
	}
    }

    public void paint(Graphics g) {

	super.paint(g);
	Graphics2D gd = (Graphics2D) g;

	ImageIcon im = new ImageIcon("img/g.png");
	gd.drawImage(im.getImage(), 0, 0, null);

	player.draw(gd);

	gd.setColor(Color.white);
	gd.setFont(new Font("Arial", 12, 30));
	gd.drawString("Niveau " + (level - 1), 360, 100);

	for (int i = 0; i < enemies.size(); i++) {

	    Enemy myenemies = enemies.get(i);
	    myenemies.draw(gd);
	}

	for (int i = 0; i < missile.size(); i++) {

	    Missile mymissile = missile.get(i);
	    mymissile.draw(gd);
	}

    }

    public void actionPerformed(ActionEvent a) {

	this.repaint();
	this.player.update();
	this.checkEnd();
	
	for (int i =0; i < enemies.size(); i++) {

	    Enemy e = enemies.get(i);
	    e.update();
	}

	for (int i =0; i < missile.size(); i++) {

	    Missile m = missile.get(i);
	    m.update();
	}

    }

}
