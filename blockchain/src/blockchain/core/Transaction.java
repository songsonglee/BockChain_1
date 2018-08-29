package blockchain.core;

import util.Util;
import java.security.PublicKey;
import java.sql.Timestamp;
import org.json.simple.JSONObject;

/*
 * Transaction
 * 1. 등기를 식별할 수 있는 등기번호
 * 2. 등기에 일어난 변동 타입(계약 맺기, 계약금 지불(=소유주 변경))
 * 3. 변동뒤의 해당 등기
 * 
 * 	보내는 사람의 지갑 주소, 받는 사람의 지갑 주소, 트랜잭션 발생 시간도 있어야함.
 * */

public class Transaction {
	//등기 변동사항: 계약맺기, 계약금 지불(=소유주 변경)
	
	private String signature;
	private PublicKey sellerKey;
	private PublicKey buyerKey;
	private Timestamp timestamp;
	private String registerID;	//등기를 식별할 수 잇는 등기 번호
	private Util.chType type;	//등기에 일어난 변동 타입(1. 계약맺기, 2. 계약금 지불(=소유주 변경))
	private Register result;	//변동된 뒤의 해당 등기
	
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
	
	
	//변동된 뒤의 등기 내용과 매수자, 매도자의 public key를 json 문자열로 바꿔주는 함수
	@SuppressWarnings("unchecked")
	public String getInformation() {
		Register register = this.getResult();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("매도자 키", sellerKey.toString());
		jsonObj.put("매수자 키", buyerKey.toString());
		jsonObj.put("등기 번호", register.getRegisterID());
		jsonObj.put("주소", register.getAddr());
		jsonObj.put("소유자", register.getOwner());
		if(register.getIsOnContract()) {
			jsonObj.put("계약", "계약이 진행중입니다.");
		}
		else {
			jsonObj.put("계약",  "계약 진행중이 아닙니다.");
			System.out.println("계약중이 아닙니다.");
		}
		jsonObj.put("매수자", register.getBuyer());
		jsonObj.put("계약 금액", register.getPrice());
		jsonObj.put("계약 시작일", register.getStartDate());
		jsonObj.put("계약 종료일", register.getFinishDate());

		return jsonObj.toString(); 
	}
	//변동된 뒤의 등기 내용을 json 문자열로 바꿔주는 함수
	@SuppressWarnings("unchecked")
	public String getData() {
		Register register = this.getResult();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("등기 번호", register.getRegisterID());
		jsonObj.put("주소", register.getAddr());
		jsonObj.put("소유자", register.getOwner());
		if(register.getIsOnContract()) {
			jsonObj.put("계약", "계약이 진행중입니다.");
		}
		else {
			jsonObj.put("계약",  "계약 진행중이 아닙니다.");
			System.out.println("계약중이 아닙니다.");
		}
		jsonObj.put("매수자", register.getBuyer());
		jsonObj.put("계약 금액", register.getPrice());
		jsonObj.put("계약 시작일", register.getStartDate());
		jsonObj.put("계약 종료일", register.getFinishDate());

		return jsonObj.toString(); 
	}

	//@TODO: 여기 생성자부분 건드릴차례임..
	//MAKE_CONTRACT일 때
	public Transaction(Wallet wallet, PublicKey receiver, String timestamp,Register prevRegister, String buyer, int price) {
		if(prevRegister.getIsOnContract()) {
			System.out.println("이미 계약중입니다.");
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
	//CHANGE_OWNER일 때
	public Transaction(Register prevRegister) {
		if(prevRegister.getIsOnContract()) {
			result = new Register();
			this.type = Util.chType.CHANGE_OWNER;
			result.copyRegister(prevRegister);
			result.setIsOnContract(false);
			result.setFinishDate(prevRegister.finishContract());
		}
		else {
			System.out.println("계약중이 아닙니다.");
		}
	}
	/*
	//MAKE_CONTRACT일 때
	public Transaction(Register prevRegister, String buyer, int price) {
		if(prevRegister.getIsOnContract()) {
			System.out.println("이미 계약중입니다.");
		}
		else {
			this.type = Util.chType.MAKE_CONTRACT;
			result = new Register();
			result.copyRegister(prevRegister);
			result.makeContract(buyer, price);
		}
	}
	//CHANGE_OWNER일 때
	public Transaction(Register prevRegister) {
		if(prevRegister.getIsOnContract()) {
			result = new Register();
			this.type = Util.chType.CHANGE_OWNER;
			result.copyRegister(prevRegister);
			result.setIsOnContract(false);
			result.setFinishDate(prevRegister.finishContract());
		}
		else {
			System.out.println("계약중이 아닙니다.");
		}
	}
	
	*/

}
