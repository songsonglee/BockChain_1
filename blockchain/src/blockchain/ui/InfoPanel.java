package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import blockchain.ui.event.SearchListener;

public class InfoPanel extends JPanel{
	private JPanel top;
	private JPanel center;
	private JPanel west;

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
		JTextField text = new JTextField(20);
		JButton button = new JButton("확인");
		top.add(text);
		top.add(button);
	
		// 주소 검색 버튼 event handler 세팅
		JLabel addr = new JLabel();
		ActionListener listener = new SearchListener(text, addr);
		button.addActionListener(listener);
		
		//메뉴 panel
		west = new JPanel();
		makeWest();
		//정보 표시  panel
		center = new JPanel();
		center.add(addr);
		
		
		add(top, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);

/*
		add(left, SwingConstants.CENTER);
		add(right, SwingConstants.CENTER);
		
		
		add(new JLabel("주소: ", SwingConstants.CENTER));
		add(new JLabel("서울시 성북구 삼선교로 21길 14 ", SwingConstants.CENTER));
		
		add(new JLabel("소유주: ", SwingConstants.CENTER));
		add(new JLabel("이경훈", SwingConstants.CENTER));
*/
		
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
