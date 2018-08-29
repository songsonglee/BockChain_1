package blockchain.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import util.Util;

public class ConPanel extends JPanel implements ActionListener{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("�ż���:");
	JTextField buyerTf = new  JTextField(8);
	
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("�ŵ���:");
	JTextField sellerTf = new  JTextField(8);
	
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("��� ������:");
	JLabel dateTf = new  JLabel(Util.getDate());
	//JLabel dateLb2 = new JLabel("  (YYYY.MM.DD)"); //���� ǥ��
	
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("�ݾ�:");
	JTextField priceTf = new  JTextField(8);
	
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("�ش� ���:");
	JTextField registerTf = new  JTextField(8);
	JButton registerBt = new JButton("�˻�..");
	
	JPanel temp = new JPanel();
	JButton Contract = new JButton("���");
	JButton Complete = new JButton("���� ���� �Ϸ�");
	// �ʿ��� ��ҵ� ���ٴ� Panel  �Ѱ��� 
	Util date = new Util();
	public ConPanel() {
		setLayout(new GridLayout(7,1,0,10));
		
		buyerPn.setLayout(new GridLayout(1,3));
		buyerPn.add(buyerLb);
		buyerPn.add(buyerTf);
		buyerPn.add(new JLabel(""));//���� ���߱�
		add(buyerPn); 
		
		sellerPn.setLayout(new GridLayout(1,3));
		sellerPn.add(sellerLb);
		sellerPn.add(sellerTf);
		sellerPn.add(new JLabel(""));//���� ���߱�
		add(sellerPn);
		
		datePn.setLayout(new GridLayout(1,3));
		datePn.add(dateLb1);
		datePn.add(dateTf);
		datePn.add(new Label(""));
		add(datePn);
		
		pricePn.setLayout(new GridLayout(1,3));
		pricePn.add(priceLb);
		pricePn.add(priceTf);
		pricePn.add(new JLabel(""));//���� ���߱�
		add(pricePn);
		
		registerPn.setLayout(new GridLayout(1,3));
		registerPn.add(registerLb);
		registerPn.add(registerTf);
		registerPn.add(registerBt);
		registerBt.addActionListener(this);
		add(registerPn);
		
		temp.setLayout(new GridLayout(1, 2));
		temp.add(Contract);
		Contract.addActionListener(this);
		temp.add(Complete);
		Complete.addActionListener(this);
		add(temp);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == registerBt) {
		 registerTf.setText("���");
			// ��� �˻��ؼ� ��� �̸�? ID�� ��� �ش� ���ǹ� �ؼ� ��ĭ�ΰ� �Ǻ��� ��
		}
		
		
		if(ae.getSource() == Contract) {
			buyerLb.getText();
			sellerLb.getText();
			
			// Ʈ����ǿ� ��� �����ϱ��� ��� 
		}
		else if (ae.getSource() == Complete) {
			// Ʈ����ǿ� ��� ������ ���
		}
	}
	
	
}
