import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;

  /**
	 * 
 	 * @author Jared Little
 	 */


public class SatelliteDriver implements ActionListener
{
	JTextField valueX;
	JTextField valueY;
	JTextField valueVX;
	JTextField valueVY;
	JTextField totalOrbitTime;
	JTextField data;
	JTextArea  textArea;
		
	SatelliteDriver()		
	{	
		// Creates a new JFrame to hold the text fields and buttons.
		
		JFrame j = new JFrame("Satellite Simulation");
		j.setLayout(new BorderLayout());
		j.setSize(400, 700);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creates text fields
		
		valueX = new JTextField();
		valueY = new JTextField();
		valueVX = new JTextField();
		valueVY = new JTextField();
		totalOrbitTime = new JTextField();
		
		// Maybe this should be a text area??
		
		data = new JTextField(10);
		
		//Sets up a JPanel to hold the boxes for input variables
		
		JPanel panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(4,2));
		panel1.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		
		// Adds labels and text fields.
		
		panel1.add(new JLabel("x Value in Meters"));
		panel1.add(valueX);
		valueX.addActionListener(this);
		j.add(panel1,BorderLayout.NORTH );
		
		panel1.add(new JLabel("y Value in Meters"));
		panel1.add(valueY);
		valueY.addActionListener(this);
		j.add(panel1, BorderLayout.NORTH);
		
		panel1.add(new JLabel("vx Value in Meters/Second"));
		panel1.add(valueVX);
		valueVX.addActionListener(this);
		j.add(panel1, BorderLayout.NORTH);

		panel1.add(new JLabel("vy Value in Meters/Second"));
		panel1.add(valueVY);
		valueVY.addActionListener(this);
		j.add(panel1, BorderLayout.NORTH);
		
		// Sets up a JPanel to output the data from the calculations.
		// Probably should be a TextArea instead of a textField.
	
		textArea = new JTextArea(20, 32);
		textArea.setEditable(false);
		
		JPanel textBox = new JPanel(); 	
		textBox.add(new JLabel("Data"));
		textBox.add(textArea);
		j.add(textBox, BorderLayout.CENTER);
		
		// Sets up a JPanel and adds the buttons to perform the calculations.
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		panel3.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JButton startButton = new JButton("Calculate Orbit");
		startButton.addActionListener(this);
		panel3.add(startButton);
		j.add(panel3, BorderLayout.SOUTH);
		
		JButton stopButton = new JButton("Stop Orbit");
		stopButton.addActionListener(this);
		panel3.add(stopButton);
		j.add(panel3, BorderLayout.SOUTH);
		
		// Makes everything we just created visible.
		
		j.setVisible(true); 
	}

	/**
	 * A method to create actions for the buttons.
 	 * 
 	 */
		
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getActionCommand().equals("Calculate Orbit"))
		{
			//Sets the text in the Text Area.
			textArea.setText("Something was Output here!");
			
			//Adds to the text without deleting it.
			textArea.append("\nThis was added.");
		}
		
		if(e.getActionCommand().equals("Stop Orbit"))
		{	
			
		}
	}
	
	/**
	 * A main method to create a new GUI to run our program.
 	 * 
 	 */

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new SatelliteDriver();
			}
		});
	}
}
