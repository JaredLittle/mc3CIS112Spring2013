
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Jared Little
 */

public class SatelliteDriver implements ActionListener {

	JTextField valueX;
	JTextField valueY;
	JTextField valueVX;
	JTextField valueVY;
	//JTextField totalOrbitTime;



	DataPanel dataPanel = new DataPanel();

	SatelliteDriver() {
		// Creates a new JFrame to hold the text fields and buttons.

		JFrame frame = new JFrame("Satellite Simulation");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creates text fields

		valueX = new JTextField();
		valueY = new JTextField();
		valueVX = new JTextField();
		valueVY = new JTextField();
		//totalOrbitTime = new JTextField();

		// Sets up a JPanel to hold the boxes for input variables

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2));
		panel1.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		// Adds labels and text fields.

		panel1.add(new JLabel("x Value in Meters"));
		panel1.add(valueX);
		valueX.addActionListener(this);
		frame.add(panel1, BorderLayout.NORTH);

		panel1.add(new JLabel("y Value in Meters"));
		panel1.add(valueY);
		valueY.addActionListener(this);
		frame.add(panel1, BorderLayout.NORTH);

		panel1.add(new JLabel("vx Value in Meters/Second"));
		panel1.add(valueVX);
		valueVX.addActionListener(this);
		frame.add(panel1, BorderLayout.NORTH);

		panel1.add(new JLabel("vy Value in Meters/Second"));
		panel1.add(valueVY);
		valueVY.addActionListener(this);
		frame.add(panel1, BorderLayout.NORTH);

		// Sets up a tabbed panel for the image and data

		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab ("Image", new DrawPanel());
		tabs.addTab ("Data", dataPanel);

		// Sets up a JPanel and adds the buttons to perform the calculations.

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2));
		panel3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JButton startButton = new JButton("Calculate Orbit");
		startButton.addActionListener(this);
		panel3.add(startButton);
		frame.add(panel3, BorderLayout.SOUTH);

		JButton stopButton = new JButton("Stop Orbit");
		stopButton.addActionListener(this);
		panel3.add(stopButton);
		frame.add(panel3, BorderLayout.SOUTH);

		JButton resetButton = new JButton("Reset Values");
		resetButton.addActionListener(this);
		panel3.add(resetButton);
		frame.add(panel3, BorderLayout.SOUTH);


		// Makes everything we just created visible.

		frame.getContentPane().add(tabs);
		frame.setVisible(true);
	}

	/**
	 * A method to create actions for the buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Calculate Orbit")) {

			String x1 = valueX.getText();
			String y1 = valueY.getText();
			String vx1 = valueVX.getText();
			String vy1 = valueVY.getText();
			String outputText = "";
			String errorText = "";

			double x2 = 0;
			double y2 = 0;
			double vx2 = 0;
			double vy2 = 0;

			try {
				x2 = Double.parseDouble(x1);
			} catch (NumberFormatException e1) {
				errorText = "Please provide a value for x.";
				System.err.println(errorText);
				dataPanel.setData(errorText);
				throw new IllegalArgumentException("errorText");
			}

			try {
				y2 = Double.parseDouble(y1);
			} catch (NumberFormatException e1) {
				errorText = "Please provide a value for y.";
				System.err.println(errorText);
				dataPanel.setData(errorText);
				throw new IllegalArgumentException("errorText");
			}

			try {
				vx2 = Double.parseDouble(vx1);
			} catch (NumberFormatException e1) {
				errorText = "Please provide a value for vx.";
				System.err.println(errorText);
				dataPanel.setData(errorText);
				throw new IllegalArgumentException("errorText");
			}

			try {
				vy2 = Double.parseDouble(vy1);
			} catch (NumberFormatException e1) {
				errorText = "Please provide a value for vy.";
				System.err.println(errorText);
				dataPanel.setData(errorText);
				throw new IllegalArgumentException("errorText");
			}	

			SatelliteHelper satelliteHelper = new SatelliteHelper();
			
			outputText = satelliteHelper.orbitEquator(120, x2, y2, vx2, vy2);
			dataPanel.setData(outputText);

		}

		if (e.getActionCommand().equals("Stop Orbit")) {
		}

		if (e.getActionCommand().equals("Reset Values")) {

			dataPanel.resetData();
			valueX.setText("");
			valueY.setText("");
			valueVX.setText("");
			valueVY.setText("");

		}

	}

	/**
	 * A main method to create a new GUI to run our program.
	 * 
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SatelliteDriver();
			}
		});
	}
}
