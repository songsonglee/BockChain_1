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
		String tabs[] = {"�ּ�: ", "������: ", "��� ����", "�ż���: ", "�ŵ���: ", "��� ������: ", "��� �ݾ�: "};
		west.setLayout(new GridLayout(7,1));
		for(String tb: tabs) {
			west.add(new Label(tb));
		}
	}
	
	public InfoPanel(){
		setLayout(new BorderLayout());
		
		//�ּ� �˻� panel
		top = new JPanel();
		JTextField text = new JTextField(20);
		JButton button = new JButton("Ȯ��");
		top.add(text);
		top.add(button);
	
		// �ּ� �˻� ��ư event handler ����
		JLabel addr = new JLabel();
		ActionListener listener = new SearchListener(text, addr);
		button.addActionListener(listener);
		
		//�޴� panel
		west = new JPanel();
		makeWest();
		//���� ǥ��  panel
		center = new JPanel();
		center.add(addr);
		
		
		add(top, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);

/*
		add(left, SwingConstants.CENTER);
		add(right, SwingConstants.CENTER);
		
		
		add(new JLabel("�ּ�: ", SwingConstants.CENTER));
		add(new JLabel("����� ���ϱ� �Ｑ���� 21�� 14 ", SwingConstants.CENTER));
		
		add(new JLabel("������: ", SwingConstants.CENTER));
		add(new JLabel("�̰���", SwingConstants.CENTER));
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
