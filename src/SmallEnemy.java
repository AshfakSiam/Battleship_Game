
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

public class SmallEnemy extends Enemy {

	/**
	 * 
	 * The default (or empty) constructor to initialize the instance properties. The
	 * values for the SmallEnemy, as well as the color, are for you to decide.
	 * 
	 */

	public SmallEnemy() {
		super(0, 10, 25, 25, 2);
		setColor();
	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract setColor() method.
	 * You will choose the color of the SmallEnemy and set the parent's color
	 * accordingly.
	 * 
	 */

	@Override
	public void setColor() {
		Color color = new Color(255, 69, 0);
		super.setEnemyColor(color);
	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract move() method. You
	 * will check if the SmallEnemy has hit a wall or not, then reverse the
	 * direction if it has. Also, you will update the coordinates of the SmallEnemy
	 * for the next frame. Finally, you will update the speed to go faster each
	 * move() call depending on the positive or negative direction the SmallEnemy is
	 * currently going in. Note that the width and height parameters are the
	 * dimensions of the JFrame. Update the bounds of the JComponent's Rectangle
	 * object to reflect the movement.
	 * 
	 */

	@Override
	public void move(int width, int height) {
		int x = getX();
		int y = getY();

		if (x < 0 || x + getWidth() > width) {

			super.setEnemySpeed(-super.getEnemySpeed());
		}

		x += super.getEnemySpeed();
		super.setBounds(x, y, super.getWidth(), super.getHeight());

		if (super.getEnemySpeed() > 0) {
			super.setEnemySpeed(getEnemySpeed() * 1);
		} else {
			super.setEnemySpeed(getEnemySpeed() - 1);
		}

		// after a certain speed enemy disappears

		if (super.getEnemySpeed() > 100) {
			super.setBounds(0, 0, 0, 0);
		}

	}

	/**
	 * 
	 * This method is the implementation of the Enemy's abstract processCollision()
	 * method. If this method is called, then a Missile hit a SmallEnemy. You will
	 * check to see if either the SmallEnemy's height or width is less than zero. If
	 * so, remove the SmallEnemy from the ArrayList. If not, shrink the size of the
	 * SmallEnemy by some amount you decide that is less than what you did for
	 * BigEnemy's processCollision(). Update the bounds of the JComponent's
	 * Rectangle object to reflect the collision.
	 * 
	 */

	@Override
	public void processCollision(ArrayList<Enemy> enemies, int SmallEnemyIndex) {
		int width = super.getWidth();
		int height = super.getHeight();
		if (width <= 0 || height <= 0) {
			enemies.remove(SmallEnemyIndex);
		} else {
			int newSize = (int) (width * 0);
			super.setBounds(super.getX(), super.getY(), newSize, newSize);
		}
	}
}