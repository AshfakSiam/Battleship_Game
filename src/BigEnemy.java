
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
import java.util.ArrayList;

/**
 * 
 * This class inherits the class Enemy and must implement the abstract methods
 * it contains.
 * 
 */

public class BigEnemy extends Enemy {

	/**
	 * 
	 * The default (or empty) constructor to initialize the instance properties. The
	 * values for the BigEnemy, as well as the color,are for you to decide.
	 * 
	 * 
	 */

	public BigEnemy() {

		super(0, 40, 50, 50, 5);
		setColor();
	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract setColor() method.
	 * You will choose the color of the BigEnemy and set the parent's color
	 * accordingly.
	 * 
	 */

	@Override
	public void setColor() {
		Color color = new Color(128, 0, 128);
		super.setEnemyColor(color);
	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract move() method. You
	 * will check if the BigEnemy has hit a wall or not, then reverse the direction
	 * if it has. Also, you will update the coordinates of the BigEnemy for the next
	 * frame. Note that the width and height parameters are the dimensions of the
	 * JFrame. Update the bounds of the JComponent's Rectangle object to reflect the
	 * movement.
	 * 
	 */

	@Override
	public void move(int width, int height) {
		int x = super.getX();
		int y = super.getY();
		int dx = super.getEnemySpeed();

		if (x + super.getWidth() > width || x < 0) {
			dx *= -1;
		}
		x += dx;
		super.setBounds(x, y, super.getWidth(), super.getHeight());
		super.setEnemySpeed(dx);
	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract processCollision()
	 * method. If this method is called, then a Missile hit a BigEnemy. You will
	 * check to see if either the BigEnemy's height or width is less than zero. If
	 * so, remove the BigEnemy from the ArrayList. If not, shrink the size of the
	 * BigEnemy by some amount you decide. Update the bounds of the JComponent's
	 * Rectangle object to reflect the collision.
	 * 
	 */

	@Override
	public void processCollision(ArrayList<Enemy> enemies, int bigEnemyIndex) {
		int width = super.getWidth();
		int height = super.getHeight();
		if (width <= 25 || height <= 0) {
			enemies.remove(bigEnemyIndex);
		} else {
			int newSize = (int) (width * 0.50);
			super.setBounds(super.getX(), super.getY(), newSize, newSize);
		}
	}
}
