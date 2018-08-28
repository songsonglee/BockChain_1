package blockchain.core;

import util.Util;
import org.json.simple.JSONObject;

/*
 * Register
 * 1. ���ID
 * 2. �ּ�
 * 3. ������ (=�ŵ���)
 * 4. ��������� ���θ� ��Ÿ���� flag
 * 5. �ż���
 * 6. ��� ������
 * 7. ��� �Ϸ���
 * 8. ��� �ݾ�
 */

public class Register {
	//������� �� ��� ����
	private String registerID;
	private String addr;
	private String owner;
	private Boolean isOnContract;
	private String buyer;
	private String startDate;
	private String finishDate;
	private String price;
	
	
	public String getRegisterID() {
		return registerID;
	}
	public void setRegisterID(String registerID) {
		this.registerID = registerID;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Boolean getIsOnContract() {
		return isOnContract;
	}
	public void setIsOnContract(Boolean flag) {
		this.isOnContract = flag;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getFinishDate() {
		return this.finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(int price) {
		Integer tmp = new Integer(price);
		this.price = tmp.toString();
	}

	public Register() {
		this.registerID = " ";
		this.addr = " ";
		this.owner = " ";
		this.isOnContract = false;
		this.buyer = " ";
		this.startDate = " ";
		this.finishDate = " ";
		this.price = " " ;
	}
	public Register(String addr, String owner) {
		this.registerID = Util.getHash(addr);
		this.addr = addr;
		this.owner = owner;
		this.isOnContract = false;
		this.buyer = " ";
		this.startDate = " ";
		this.finishDate = " ";
		this.price = " " ;
	}

	//�Լ��� ȣ���� �ð��� ���ð����� �ؼ� ������� �����ϱ�
	public void makeContract(String buyer, int price) {
		this.buyer = buyer;
		this.setPrice(price);
		this.startDate = Util.getDate();
		this.setIsOnContract(true);
		this.setFinishDate(" ");
	}
	public String finishContract() {
		this.owner = this.buyer;
		this.price = " ";
		this.buyer = " ";
		this.isOnContract = false;
		this.finishDate = Util.getDate();
		return finishDate;
	}
	public void copyRegister(Register origin) {
		this.registerID = origin.getRegisterID();
		this.addr = origin.getAddr();
		this.owner = origin.getOwner();
		this.isOnContract = origin.getIsOnContract();
		this.buyer = origin.getBuyer();
		this.startDate = origin.getStartDate();
		this.finishDate = origin.getFinishDate();
		this.price = origin.getPrice();
	}
	
	@SuppressWarnings("unchecked")
	public String getInformation() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("��� ��ȣ", getRegisterID());
		jsonObj.put("�ּ�", getAddr());
		jsonObj.put("������", getOwner());
		if(getIsOnContract()) {
			jsonObj.put("���", "����� �������Դϴ�.");
		}
		else {
			jsonObj.put("���",  "��� �������� �ƴմϴ�.");
		}
		jsonObj.put("�ż���", getBuyer());
		jsonObj.put("��� �ݾ�", getPrice());
		jsonObj.put("��� ������", getStartDate());
		jsonObj.put("��� ������", getFinishDate());

		return jsonObj.toString(); 
	}
}
