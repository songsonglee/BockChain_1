package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import blockchain.ui.event.*;

public class ConPanel extends JPanel{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("매수자:");
	JTextField buyerTf = new  JTextField(10);
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("매도자:");
	JTextField sellerTf = new  JTextField(10);
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("계약일자:");
	JTextField dateTf = new  JTextField(8);
	JLabel dateLb2 = new JLabel("(YYYYMMDD)");
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("금액:");
	JTextField priceTf = new  JTextField(10);
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("해당 등기:");
	JTextField registerTf = new  JTextField(10);
	JButton registerBt = new JButton("검색..");
	JButton Complete = new JButton("계약");
	// 필요한 요소들 한줄당 Panel  한개씩 
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
