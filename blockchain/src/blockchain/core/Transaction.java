package blockchain.core;

import util.Util;
import org.json.simple.JSONObject;
/*
 * Transaction
 * 1. ��⸦ �ĺ��� �� �ִ� ����ȣ
 * 2. ��⿡ �Ͼ ���� Ÿ��(��� �α�, ���� ����(=������ ����))
 * 3. �������� �ش� ���
 * */

public class Transaction {
	//��� ��������: ���α�, ���� ����(=������ ����)
	
	private String registerID;
	private Util.chType type;
	private Register result;

	public String getRegisterID() {
		return registerID;
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
	
	//������ ���� ��� ������ json ���ڿ��� �ٲ��ִ� �Լ�
	@SuppressWarnings("unchecked")
	public String getInformation() {
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
}
