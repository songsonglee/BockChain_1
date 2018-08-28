package blockchain.ui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame{
		
	public MainFrame() {
		setTitle("Block Chain");
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(new MainPanel(), BorderLayout.CENTER);
		
	
		setVisible(true);
	}
}
