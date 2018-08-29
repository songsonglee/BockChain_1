package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import blockchain.ui.event.*;

public class ConPanel extends JPanel{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("�ż���:");
	JTextField buyerTf = new  JTextField(8);
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("�ŵ���:");
	JTextField sellerTf = new  JTextField(8);
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("�������:");
	JTextField dateTf = new  JTextField(8);
	JLabel dateLb2 = new JLabel("  (YYYYMMDD)"); //���� ǥ��
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("�ݾ�:");
	JTextField priceTf = new  JTextField(8);
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("�ش� ���:");
	JTextField registerTf = new  JTextField(8);
	JButton registerBt = new JButton("�˻�..");
	JButton Complete = new JButton("���");
	// �ʿ��� ��ҵ� ���ٴ� Panel  �Ѱ��� 
	public ConPanel() {
		setLayout(new GridLayout(6,1,0,10));
		
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
		datePn.add(dateLb2);
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
		add(registerPn);
		
		add(Complete);

	}
	
	
}
