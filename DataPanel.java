
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DataPanel extends JPanel {
  
	JTextArea data;
		
	public DataPanel() {
		
		data = new JTextArea();
		
		JPanel textBox = new JPanel();
		
		add(data);
		setBackground (Color.white);
		data.setEditable(false);
	}
	
	public void setData(String outputText) {
	
		//Sets the text in the Text Area.
		data.setText(outputText);
	}
	
	public void resetData() {
		data.setText("");
	}
}
	
