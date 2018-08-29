package blockchain.ui;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private JPanel tempPanel;
	private JTabbedPane tabPanel;
	
	private void makeTabPanel() {
		tabPanel.addTab("��� �˻�", new InfoPanel());
		tabPanel.addTab("���", new ConPanel());
	}
	
	MainPanel(){
		setLayout(new BorderLayout());
		
		tabPanel = new JTabbedPane(JTabbedPane.TOP);
		//tabPanel.setFont(new Font("����ü", Font.BOLD, 30));
		makeTabPanel();
		
		add(tabPanel, BorderLayout.NORTH);
	}
}

