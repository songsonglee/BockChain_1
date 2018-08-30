package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import util.Util;


public class InfoPanel extends JPanel implements ActionListener{
	private JPanel top;
	private JPanel center;
	private JPanel west;
	JPanel south = new JPanel();
	JLabel n1,n2,n3,n4,n5;
	JLabel setting = new JLabel("�ֱٰŷ����� ");
	JTextField text = new JTextField(20);
	JButton button = new JButton("Ȯ��");
	
	JLabel addr = new JLabel();


	private void makeWest() {
		String tabs[] = {"�ּ�: ", "������: ", "��� ����: ", "�ż���: ", "�ŵ���: ", "��� ������: ", "��� �ݾ�: "};
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
		
		south.setLayout(new GridLayout(6,1));
		south.add(setting);
		n1= new JLabel("1:");
		south.add(n1);
		n2= new JLabel("2");
		south.add(n2);
		n3= new JLabel("3");
		south.add(n3);
		n4= new JLabel("4");
		south.add(n4);
		n5= new JLabel("5");
		south.add(n5);
		
		
		add(top, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
	 
	}
	public void actionPerformed(ActionEvent ae)  {
		if(ae.getSource() == button) {
			Util add = new Util();
			add.fileWrite("./data/addr.dat", text.getText());
		} 
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
