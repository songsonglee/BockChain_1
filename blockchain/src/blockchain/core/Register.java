package blockchain.core;

import util.Util;
import org.json.simple.JSONObject;

/*
 * Register
 * 1. 등기ID
 * 2. 주소
 * 3. 소유주 (=매도자)
 * 4. 계약중인지 여부를 나타내는 flag
 * 5. 매수자
 * 6. 계약 시작일
 * 7. 계약 완료일
 * 8. 계약 금액
 */

public class Register {
	//계약중일 때 계약 내용
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


	//함수를 호출한 시간을 계약시간으로 해서 계약정보 수정하기
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
		jsonObj.put("등기 번호", getRegisterID());
		jsonObj.put("주소", getAddr());
		jsonObj.put("소유자", getOwner());
		if(getIsOnContract()) {
			jsonObj.put("계약", "계약이 진행중입니다.");
		}
		else {
			jsonObj.put("계약",  "계약 진행중이 아닙니다.");
		}
		jsonObj.put("매수자", getBuyer());
		jsonObj.put("계약 금액", getPrice());
		jsonObj.put("계약 시작일", getStartDate());
		jsonObj.put("계약 종료일", getFinishDate());

		return jsonObj.toString(); 
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
}
