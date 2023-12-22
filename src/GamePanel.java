
/**
 * Name: K M Ashfak Alam Siam

 * 
 * Section: c
 * 
 * Project 4
 * 
 * 
 */

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class inherits JPanel and contains all the GUI elements for the custom
 * JPanel to make the game function.
 * 
 */

public class GamePanel extends JPanel {

	private int totalScore;
	private boolean isNextEnemyBig;
	private Turret turret;
	private ArrayList<Enemy> enemies;
	private ArrayList<Missile> missiles;
	Sound sound = new Sound();

	/**
	 * The default (or empty) constructor to initialize the instance properties. It
	 * also adds a new BigEnemy and a new SmallEnemy to the Enemy ArrayList to start
	 * the game.
	 * 
	 */

	public GamePanel() {

		this.totalScore = 0;
		this.isNextEnemyBig = false;
		this.turret = new Turret();
		this.enemies = new ArrayList<>();
		this.missiles = new ArrayList<>();
		// add initial enemies
		enemies.add(new BigEnemy());
		enemies.add(new SmallEnemy());
		playMusic(0);
	}

	/**
	 * Paint the JPanel white, for every Enemy and every Missile, call their
	 * respective paintComponent() methods, and paint the Turret with the Turret’s
	 * respective paintComponent() method.
	 * 
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// paint turret
		turret.paintComponent(g);

		// paint enemies and missiles

		for (Enemy enemy : enemies) {
			enemy.paintComponent(g);
		}
		for (Missile missile : missiles) {
			missile.paintComponent(g);

		}

	}

	/**
	 * 
	 * For every Enemy and every Missile, calls the corresponding Enemy and Missile
	 * move() methods in their respective classes.
	 * 
	 */

	public void move() {

		// move enemies and missiles
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).move(super.getWidth(), super.getHeight());
		}

		for (int i = 0; i < missiles.size(); i++) {
			missiles.get(i).move(super.getWidth(), super.getHeight(), missiles, i);

		}
	}

	/**
	 * 
	 * Adds a new Missile to the Missile ArrayList.
	 * 
	 */

	public void addMissile() {

		missiles.add(new Missile());
	}

	/**
	 * 
	 * Adds a new BigEnemy or SmallEnemy to the Enemy ArrayList depending on the
	 * isNextEnemyBig boolean instance property.
	 * 
	 */

	public void addEnemy() {
		if (isNextEnemyBig) {
			enemies.add(new BigEnemy());
		} else {
			enemies.add(new SmallEnemy());
		}
		isNextEnemyBig = !isNextEnemyBig; // alternate between big and small enemies
	}

	/**
	 * Returns the totalScore instance property.
	 * 
	 * @return Integer totalscore.
	 * 
	 */

	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * 
	 * This method detects if a Missile hits an Enemy and updates the score. The
	 * Missile that hit the enemy is removed and the Enemy is affected by calling
	 * the processCollission() method in the corresponding Enemy class.
	 * 
	 */

	public void detectCollision() {
		// Create temporary rectangles for every enemy and missile on the screen
		// currently
		for (int i = 0; i < enemies.size(); i++) {
			Rectangle enemyRec = enemies.get(i).getBounds();
			for (int j = 0; j < missiles.size(); j++) {
				Rectangle missileRec = missiles.get(j).getBounds();

				if (missileRec.intersects(enemyRec)) {

					missiles.remove(j);

					if (enemies.get(i) instanceof BigEnemy) {

						playSE(2);
						totalScore += 100;
					} else {
						playSE(2);
						totalScore += 150;
					}
					(enemies.get(i)).processCollision(enemies, i);
				}
			}
		}
	}

	/**
	 * Plays background music
	 * 
	 * @param Integer index of array
	 */

	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}

	/**
	 * Stops music
	 * 
	 */

	public void stopMusic() {
		sound.stop();
	}

	/**
	 * Plays Sound Effect music
	 * 
	 * @param Integer index of array
	 */

	public void playSE(int i) {
		sound.setFile(i);
		sound.play();

	}

}
