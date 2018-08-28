package blockchain.ui;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private JPanel tempPanel;
	private JTabbedPane tabPanel;
	
	MainPanel(){
		setLayout(new BorderLayout());
		
		tempPanel = new JPanel();
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tempPanel.add(new JButton("temp"));
		tempPanel.add(new JButton("test"));
		tempPanel.add(new JButton("LKH"));
		
		
		tabPanel = new JTabbedPane(JTabbedPane.BOTTOM);
		tabPanel.setFont(new Font("Gulim", Font.BOLD, 30));
		makeTabPanel();
		
		add(new InfoPanel(), BorderLayout.CENTER);
		add(tabPanel, BorderLayout.NORTH);
		
	}

	private void makeTabPanel() {
		tabPanel.addTab("등기 검색", new JLabel("등기 검색", SwingConstants.CENTER));
		tabPanel.addTab("계약", new JLabel("계약", SwingConstants.CENTER));
	}
}

