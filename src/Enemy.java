
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
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * 
 * This class is abstract, inherits JComponent, and holds the information
 * necessary to an Enemy. The children to this class are BigEnemy and
 * SmallEnemy.
 * 
 *
 */

public abstract class Enemy extends JComponent {

	private int enemySpeed;
	private Color enemyColor;

	/**
	 * A partial constructor that sets the coordinates, size, and speed of the Enemy
	 * and sets the bounds of the JComponent's Rectangle.
	 *
	 * @param enemyXCoord
	 * @param enemyYCoord
	 * @param enemyHeight
	 * @param enemyWidth
	 * @param enemySpeed
	 */

	public Enemy(int enemyXCoord, int enemyYCoord, int enemyHeight, int enemyWidth, int enemySpeed) {
		super.setBounds(enemyXCoord, enemyYCoord, enemyWidth, enemyHeight);
		this.enemySpeed = enemySpeed;
		setColor();
	}

	/**
	 * An abstract method which determines what occurs when a Missile hits an Enemy.
	 * 
	 * @param enemies
	 * @param enemyIndex
	 */

	public abstract void processCollision(ArrayList<Enemy> enemies, int enemyIndex);

	/**
	 * An abstract method which generates and sets the color of the Enemy.
	 * 
	 */

	public abstract void setColor();

	/**
	 * 
	 * An abstract method which computes and updates the next position of the Enemy
	 * with respect to the JFrame width and height.
	 * 
	 */

	public abstract void move(int width, int height);

	/**
	 * 
	 * The paintComponent() method that paints the Enemy based on the current x and
	 * y coordinates.
	 * 
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(enemyColor);
		g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}

	/**
	 * Gets the Enemyspeed
	 * 
	 * 
	 * @return Integer EnemySpeed
	 */

	public int getEnemySpeed() {
		return enemySpeed;
	}

	/**
	 * Stets the EnemySpeed
	 * 
	 * @param enemySpeed
	 */

	public void setEnemySpeed(int enemySpeed) {
		this.enemySpeed = enemySpeed;
	}

	/**
	 * Gets the EnemyColor
	 * 
	 * 
	 * @return Color EnemyColor
	 */

	public Color getEnemyColor() {
		return enemyColor;
	}

	/**
	 * Stets the EnemyColor
	 * 
	 * @param EnemyColor
	 */

	public void setEnemyColor(Color enemyColor) {
		this.enemyColor = enemyColor;
	}
}
