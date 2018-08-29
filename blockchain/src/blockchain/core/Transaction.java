package blockchain.core;

import util.Util;
import java.security.PublicKey;
import java.sql.Timestamp;
import org.json.simple.JSONObject;

/*
 * Transaction
 * 1. ��⸦ �ĺ��� �� �ִ� ����ȣ
 * 2. ��⿡ �Ͼ ���� Ÿ��(��� �α�, ���� ����(=������ ����))
 * 3. �������� �ش� ���
 * 
 * 	������ ����� ���� �ּ�, �޴� ����� ���� �ּ�, Ʈ����� �߻� �ð��� �־����.
 * */

public class Transaction {
	//��� ��������: ���α�, ���� ����(=������ ����)
	
	private String signature;
	private PublicKey sellerKey;
	private PublicKey buyerKey;
	private Timestamp timestamp;
	private String registerID;	//��⸦ �ĺ��� �� �մ� ��� ��ȣ
	private Util.chType type;	//��⿡ �Ͼ ���� Ÿ��(1. ���α�, 2. ���� ����(=������ ����))
	private Register result;	//������ ���� �ش� ���
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public PublicKey getSeller() {
		return sellerKey;
	}
	public void setSeller(PublicKey seller) {
		this.sellerKey= seller;
	}
	public PublicKey getBuyer() {
		return buyerKey;
	}
	public void setBuyer(PublicKey buyer) {
		this.buyerKey = buyer;
	}
	public String getRegisterID() {
		return registerID;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public void setRegisterID(String registerID) {
		this.registerID = registerID;
	}
	public Register getResult() {
		return result;
	}
	public void setResult(Register register) {
		this.result = register;
	}
	
	
	//������ ���� ��� ����� �ż���, �ŵ����� public key�� json ���ڿ��� �ٲ��ִ� �Լ�
	@SuppressWarnings("unchecked")
	public String getInformation() {
		Register register = this.getResult();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("�ŵ��� Ű", sellerKey.toString());
		jsonObj.put("�ż��� Ű", buyerKey.toString());
		jsonObj.put("��� ��ȣ", register.getRegisterID());
		jsonObj.put("�ּ�", register.getAddr());
		jsonObj.put("������", register.getOwner());
		if(register.getIsOnContract()) {
			jsonObj.put("���", "����� �������Դϴ�.");
		}
		else {
			jsonObj.put("���",  "��� �������� �ƴմϴ�.");
			System.out.println("������� �ƴմϴ�.");
		}
		jsonObj.put("�ż���", register.getBuyer());
		jsonObj.put("��� �ݾ�", register.getPrice());
		jsonObj.put("��� ������", register.getStartDate());
		jsonObj.put("��� ������", register.getFinishDate());

		return jsonObj.toString(); 
	}
	//������ ���� ��� ������ json ���ڿ��� �ٲ��ִ� �Լ�
	@SuppressWarnings("unchecked")
	public String getData() {
		Register register = this.getResult();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("��� ��ȣ", register.getRegisterID());
		jsonObj.put("�ּ�", register.getAddr());
		jsonObj.put("������", register.getOwner());
		if(register.getIsOnContract()) {
			jsonObj.put("���", "����� �������Դϴ�.");
		}
		else {
			jsonObj.put("���",  "��� �������� �ƴմϴ�.");
			System.out.println("������� �ƴմϴ�.");
		}
		jsonObj.put("�ż���", register.getBuyer());
		jsonObj.put("��� �ݾ�", register.getPrice());
		jsonObj.put("��� ������", register.getStartDate());
		jsonObj.put("��� ������", register.getFinishDate());

		return jsonObj.toString(); 
	}

	//@TODO: ���� �����ںκ� �ǵ帱������..
	//MAKE_CONTRACT�� ��
	public Transaction(Wallet wallet, PublicKey receiver, String timestamp,Register prevRegister, String buyer, int price) {
		if(prevRegister.getIsOnContract()) {
			System.out.println("�̹� ������Դϴ�.");
		}
		else {
			this.sellerKey = wallet.getPubKey();
			this.buyerKey= receiver;
			this.type = Util.chType.MAKE_CONTRACT;
			result = new Register();
			result.copyRegister(prevRegister);
			result.makeContract(buyer, price);
		}
	}
	//CHANGE_OWNER�� ��
	public Transaction(Register prevRegister) {
		if(prevRegister.getIsOnContract()) {
			result = new Register();
			this.type = Util.chType.CHANGE_OWNER;
			result.copyRegister(prevRegister);
			result.setIsOnContract(false);
			result.setFinishDate(prevRegister.finishContract());
		}
		else {
			System.out.println("������� �ƴմϴ�.");
		}
	}
	/*
	//MAKE_CONTRACT�� ��
	public Transaction(Register prevRegister, String buyer, int price) {
		if(prevRegister.getIsOnContract()) {
			System.out.println("�̹� ������Դϴ�.");
		}
		else {
			this.type = Util.chType.MAKE_CONTRACT;
			result = new Register();
			result.copyRegister(prevRegister);
			result.makeContract(buyer, price);
		}
	}
	//CHANGE_OWNER�� ��
	public Transaction(Register prevRegister) {
		if(prevRegister.getIsOnContract()) {
			result = new Register();
			this.type = Util.chType.CHANGE_OWNER;
			result.copyRegister(prevRegister);
			result.setIsOnContract(false);
			result.setFinishDate(prevRegister.finishContract());
		}
		else {
			System.out.println("������� �ƴմϴ�.");
		}
	}
	
	*/

}
