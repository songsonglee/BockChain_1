package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import blockchain.ui.event.*;

public class ConPanel extends JPanel{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("�ż���:");
	JTextField buyerTf = new  JTextField(10);
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("�ŵ���:");
	JTextField sellerTf = new  JTextField(10);
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("�������:");
	JTextField dateTf = new  JTextField(8);
	JLabel dateLb2 = new JLabel("(YYYYMMDD)");
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("�ݾ�:");
	JTextField priceTf = new  JTextField(10);
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("�ش� ���:");
	JTextField registerTf = new  JTextField(10);
	JButton registerBt = new JButton("�˻�..");
	JButton Complete = new JButton("���");
	// �ʿ��� ��ҵ� ���ٴ� Panel  �Ѱ��� 
	public ConPanel() {
		setLayout(new GridLayout(5,1));
		buyerPn.add(buyerLb);
		buyerPn.add(buyerTf);
		add(buyerPn); 
		sellerPn.add(sellerLb);
		sellerPn.add(sellerTf);
		add(sellerPn);
		datePn.add(dateLb1);
		datePn.add(dateTf);
		datePn.add(dateLb2);
		add(datePn);
		pricePn.add(priceLb);
		pricePn.add(priceTf);
		add(pricePn);
		registerPn.add(registerLb);
		registerPn.add(registerTf);
		registerPn.add(registerBt);
		add(registerPn);
		add(Complete);

	}
	
	
}
