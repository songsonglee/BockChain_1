package blockchain.core;

import util.Util;
import java.util.ArrayList;
import blockchain.core.Transaction;

/* 
 * Block
 * 1. block 해쉬: ( block에 있는 transaction의 내용 + 이전 블록의 해쉬 )의 해쉬
 * 2. 이전 block의 해쉬
 * 3. block내에 있는 transaction의 리스트
 * 4. block내 transaction들의 registerID만 따로 모아둔 리스트
 */

public class Block {
	//Block의 내용
	private int blockID;
	private String previousBlockHash;
	private ArrayList<Transaction> transactionList;
	private ArrayList<String> registerIDList;
	
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}

	public String getPreviousBlockHash() {
		return this.previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	public ArrayList<Transaction> getTransactionList(){
		return this.transactionList;
	}
	public ArrayList<String> getRegisterIDList(){
		return this.registerIDList;
	}

	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
		registerIDList.add(transaction.getRegisterID());
	}

	public void printInfo() {
		System.out.println("------------------------------");
		System.out.println("Block ID: " + getBlockID());
		System.out.println("Previous block Hash: " + getPreviousBlockHash());
		System.out.println("Number of Transaction: " + transactionList.size());
		System.out.println("Bblock Hash: " + getBlockHash());
		System.out.println("transaction Info: ");
		for (int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getData());
		}
		System.out.println("------------------------------");
	}
	
	//주소를 입력하면 해당 블록에 그 주소의 transaction이 있는지 Boolean값을 리턴
	public Boolean isRegister(String addr) {
		Boolean result = false;
		String regID = Util.getHash(addr);
		for (int i = 0; i < registerIDList.size(); i++) {
			if(regID.equals(registerIDList.get(i))) {
				result = true;
				break;
			}
		}
		return result;
	}

	//해당 블록에 있는 transaction을 Json형식의 문자열로 바꿔서 다 이어붙인뒤, 그 뒤에 이전 블록의 해쉬값을 붙인 전체를 해쉬로 바꾸는 함수
	public String getBlockHash() {
		String transactionInformation = "";
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformation += transactionList.get(i).getInformation();
		}
		return Util.getHash(transactionInformation + previousBlockHash);
	}	
	
	public Block(int blockID, String previousBlockHash,  ArrayList<Transaction> transactionList) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.transactionList = transactionList;
		this.registerIDList = new ArrayList<String>();
		for (int i = 0; i < transactionList.size(); i++) {
			registerIDList.add(transactionList.get(i).getRegisterID());
		}
	}
}
