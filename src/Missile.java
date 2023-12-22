
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
import javax.swing.JComponent;
import java.util.ArrayList;

/**
 * 
 * This class inherits JComponent and holds the information necessary to a
 * Missile.
 * 
 *
 */

public class Missile extends JComponent {

	private int missileSpeed;
	private Color missileColor;

	/**
	 * 
	 * The default (or empty) constructor to initialize the instance properties and
	 * sets the bounds of the JComponent's Rectangle. The values for the Missile, as
	 * well as the color, are for you to decide.
	 * 
	 */

	public Missile() {

		super.setBounds(328, 380, 10, 20);
		missileSpeed = 20;
		missileColor = Color.white;
	}

	/**
	 * 
	 * The paintComponent() method that paints the Missile based on the current x
	 * and y coordinates.
	 * 
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(missileColor);
		g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());

	}

	/**
	 * 
	 * Determine if the missile is off the screen and remove it from the ArrayList
	 * if it is. Also, determine the next position on the screen the Missile should
	 * appear on after being repainted. Note that the width and height parameters
	 * are the dimensions of the JFrame. Update the bounds of the JComponent's
	 * Rectangle object to reflect the movement.
	 * 
	 * @param width        of the missile
	 * @param height       of the missile
	 * @param missiles     Arraylist
	 * @param missileIndex
	 */

	public void move(int width, int height, ArrayList<Missile> missiles, int missileIndex) {
		int newY = super.getY() - missileSpeed;
		if (newY < 0) {
			missiles.remove(missileIndex);
		} else {
			super.setBounds(super.getX(), newY, super.getWidth(), super.getHeight());
		}
	}

}
