package blockchain.ui;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private JPanel tempPanel;
	private JTabbedPane tabPanel;
	
	private void makeTabPanel() {
		tabPanel.addTab("등기 검색", new InfoPanel());
		tabPanel.addTab("계약", new ConPanel());
	}
	
	MainPanel(){
		setLayout(new BorderLayout());
		
		tabPanel = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.setFont(new Font("굴림체", Font.BOLD, 30));
		makeTabPanel();
		
		add(tabPanel, BorderLayout.NORTH);
	}
}

