package blockchain.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import util.Util;

public class ConPanel extends JPanel implements ActionListener{
	JPanel buyerPn = new JPanel();
	JLabel buyerLb = new JLabel("매수자:");
	JTextField buyerTf = new  JTextField(8);
	
	JPanel sellerPn = new JPanel();
	JLabel sellerLb = new JLabel("매도자:");
	JTextField sellerTf = new  JTextField(8);
	
	JPanel datePn = new JPanel();
	JLabel dateLb1 = new JLabel("계약 시작일:");
	JLabel dateTf = new  JLabel(Util.getDate());
	//JLabel dateLb2 = new JLabel("  (YYYY.MM.DD)"); //예시 표시
	
	JPanel pricePn = new JPanel();
	JLabel priceLb = new JLabel("금액:");
	JTextField priceTf = new  JTextField(8);
	
	JPanel registerPn = new JPanel();
	JLabel registerLb = new JLabel("해당 등기:");
	JTextField registerTf = new  JTextField(8);
	JButton registerBt = new JButton("검색..");
	
	JPanel temp = new JPanel();
	JButton Contract = new JButton("계약");
	JButton Complete = new JButton("계약금 납부 완료");
	// 필요한 요소들 한줄당 Panel  한개씩 
	Util date = new Util();
	public ConPanel() {
		setLayout(new GridLayout(7,1,0,10));
		
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
		datePn.add(new Label(""));
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
		 registerTf.setText("등록");
			// 등기 검색해서 등기 이름? ID를 띄워 준다 조건문 해서 빈칸인거 판별할 것
		}
		
		
		if(ae.getSource() == Contract) {
			buyerLb.getText();
			sellerLb.getText();
			
			// 트랜잭션에 계약 시작일까지 등록 
		}
		else if (ae.getSource() == Complete) {
			// 트랜잭션에 계약 종료일 기록
		}
	}
	
	
}
