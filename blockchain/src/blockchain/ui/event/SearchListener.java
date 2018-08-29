package blockchain.ui.event;
import javax.swing.*;
import java.awt.event.*;

public class SearchListener implements ActionListener{
	JTextField text;
	JLabel label;

	public void actionPerformed(ActionEvent e) {
		String addr = text.getText();
		label.setText(addr);
	}
	
	public SearchListener(JTextField text, JLabel label){
		this.text = text;
		this.label = label;
	}
}