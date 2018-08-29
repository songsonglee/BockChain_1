package blockchain.ui;

import java.awt.*;
import javax.swing.*;
import blockchain.ui.event.*;

public class ConPanel extends JPanel{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("매수자:");
	JTextField buyerTf = new  JTextField(8);
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("매도자:");
	JTextField sellerTf = new  JTextField(8);
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("계약일자:");
	JTextField dateTf = new  JTextField(8);
	JLabel dateLb2 = new JLabel("  (YYYYMMDD)"); //예시 표시
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("금액:");
	JTextField priceTf = new  JTextField(8);
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("해당 등기:");
	JTextField registerTf = new  JTextField(8);
	JButton registerBt = new JButton("검색..");
	JButton Complete = new JButton("계약");
	// 필요한 요소들 한줄당 Panel  한개씩 
	public ConPanel() {
		setLayout(new GridLayout(6,1,0,10));
		
		buyerPn.setLayout(new GridLayout(1,3));
		buyerPn.add(buyerLb);
		buyerPn.add(buyerTf);
		buyerPn.add(new JLabel(""));//간격 맞추기
		add(buyerPn); 
		
		sellerPn.setLayout(new GridLayout(1,3));
		sellerPn.add(sellerLb);
		sellerPn.add(sellerTf);
		sellerPn.add(new JLabel(""));//간격 맞추기
		add(sellerPn);
		
		datePn.setLayout(new GridLayout(1,3));
		datePn.add(dateLb1);
		datePn.add(dateTf);
		datePn.add(dateLb2);
		add(datePn);
		
		pricePn.setLayout(new GridLayout(1,3));
		pricePn.add(priceLb);
		pricePn.add(priceTf);
		pricePn.add(new JLabel(""));//간격 맞추기
		add(pricePn);
		
		registerPn.setLayout(new GridLayout(1,3));
		registerPn.add(registerLb);
		registerPn.add(registerTf);
		registerPn.add(registerBt);
		add(registerPn);
		
		add(Complete);

	}
	
	
}
