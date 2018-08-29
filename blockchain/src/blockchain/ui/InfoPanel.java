package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class InfoPanel extends JPanel implements ActionListener{
	private JPanel top;
	private JPanel center;
	private JPanel west;
	JTextField text = new JTextField(20);
	JButton button = new JButton("확인");
	
	JLabel addr = new JLabel();

	private void makeWest() {
		String tabs[] = {"주소: ", "소유주: ", "계약 정보", "매수자: ", "매도자: ", "계약 시작일: ", "계약 금액: "};
		west.setLayout(new GridLayout(7,1));
		for(String tb: tabs) {
			west.add(new Label(tb));
			
		}
	}
	
	public InfoPanel(){
		setLayout(new BorderLayout());
		
		//주소 검색 panel
		top = new JPanel();
		
		button.addActionListener(this);
		top.add(text);
		top.add(button);
	
	
		
		
		//메뉴 panel
		west = new JPanel();
		makeWest();
		//정보 표시  panel
		center = new JPanel();
		center.add(addr);
		
		
		add(top, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	
	}
	public void actionPerformed(ActionEvent ae) {
		addr.setText(text.getText());
		// 추가 할 것 : text에서 입력된 값을 검색하는 기능 
	}
/*
	private void makePanel(JPanel pan, JLabel addr) {
		pan.setLayout(new GridLayout(7, 1));
		JPanel tmp = new JPanel();
		Font font = new Font("Gulim", Font.PLAIN, 20);
		tmp.setFont(font);
		tmp.setLayout(new FlowLayout());
		JLabel lab_0 = new JLabel(str_0, SwingConstants.LEFT);
	}
	*/
}
