
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
import javax.swing.JComponent;

/**
 * 
 * This class inherits JComponent and holds the information necessary for a
 * Turret.
 *
 */

public class Turret extends JComponent {

	private Rectangle base;
	private Rectangle turret;
	private Color turretColor;

	/**
	 * 
	 * The default (or empty) constructor to initialize the instance properties. The
	 * values for the Turret’s Rectangle objects, as well as the color, are for you
	 * to decide. Recall that a Rectangle has a constructor that takes in the x
	 * coordinate, y coordinate, width, and height.
	 * 
	 */

	public Turret() {

		base = new Rectangle(307, 400, 50, 10);
		turret = new Rectangle(325, 380, 15, 20);
		turretColor = Color.GRAY;
	}

	/**
	 * 
	 * The paintComponent() method that paints the Turret base and Turret barrel.
	 * 
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paint base
		g.setColor(Color.DARK_GRAY);
		g.fillRoundRect(base.x, base.y, base.width, base.height, 10, 10);
		// paint turret
		g.setColor(turretColor);
		g.fillRect(turret.x, turret.y, turret.width, turret.height);
	}

	/**
	 * 
	 * return X coordinate
	 * 
	 */

	public int getX() {
		return turret.x + turret.width / 2;
	}

	/**
	 * 
	 * return Y coordinate
	 * 
	 */

	public int getY() {
		return turret.y;
	}

}
