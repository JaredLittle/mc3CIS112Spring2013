import javax.swing.*;
import java.awt.*;


/**
 * This class creates an extension of JPanel that can be drawn on via the paintComponent method.
 * @author James Oakley
 */
public class DrawPanel  extends JPanel {
	
	/**
	 * Paints the DrawPanel as specified. Note that this method doesn't need to be called manually; 
	 * it's automatically called when the DrawPanel object is instantiated
	 */
	public void paintComponent(Graphics g) {
		//color and location of the circle representing earth
		g.setColor(Color.blue);
		g.fillOval(163, 162, 76, 76);
		
		//color and location of the satellite 
		g.setColor(Color.red);
		g.fillOval(110, 110, 10, 10);
		
		//color and location of the lines representing the x-axis and y-axis
		g.setColor(Color.BLACK);
		g.drawLine(200, 0, 200, 400);
		g.drawLine(0, 200, 400, 200);
	}
}
