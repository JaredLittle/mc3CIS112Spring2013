import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
  
	JTextArea data;
		
	public DataPanel() {
		
		data = new JTextArea();
		
		JPanel textBox = new JPanel();

		add (data);
		setBackground (Color.white);
		data.setEditable(false);
		

				
	}
	
	public void setData() {
	
		//Sets the text in the Text Area.
		data.setText("Something was Output here!");
			
		//Adds to the text without deleting it.
		data.append("\nThis was added.");
	}
	
	public void resetData() {
		data.setText("");
	}
	

	
}
