package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class InfoPanel extends JPanel implements ActionListener{
	private JPanel top;
	private JPanel center;
	private JPanel west;
	JTextField text = new JTextField(20);
	JButton button = new JButton("Ȯ��");
	
	JLabel addr = new JLabel();

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
		
		button.addActionListener(this);
		top.add(text);
		top.add(button);
	
	
		
		
		//�޴� panel
		west = new JPanel();
		makeWest();
		//���� ǥ��  panel
		center = new JPanel();
		center.add(addr);
		
		
		add(top, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	
	}
	public void actionPerformed(ActionEvent ae) {
		addr.setText(text.getText());
		// �߰� �� �� : text���� �Էµ� ���� �˻��ϴ� ��� 
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
