package blockchain.core;

import util.Util;
import java.util.ArrayList;
import blockchain.core.Transaction;

/* 
 * Block
 * 1. block �ؽ�: ( block�� �ִ� transaction�� ���� + ���� ����� �ؽ� )�� �ؽ�
 * 2. ���� block�� �ؽ�
 * 3. block���� �ִ� transaction�� ����Ʈ
 * 4. block�� transaction���� registerID�� ���� ��Ƶ� ����Ʈ
 */

public class Block {
	//Block�� ����
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

	
	
	public Block(int blockID, String previousBlockHash,  ArrayList<Transaction> transactionList) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.transactionList = transactionList;
		this.registerIDList = new ArrayList<String>();
		for (int i = 0; i < transactionList.size(); i++) {
			registerIDList.add(transactionList.get(i).getRegisterID());
		}
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
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("------------------------------");
	}
	
	//�ּҸ� �Է��ϸ� �ش� ��Ͽ� �� �ּ��� transaction�� �ִ��� Boolean���� ����
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

	//�ش� ��Ͽ� �ִ� transaction�� Json������ ���ڿ��� �ٲ㼭 �� �̾���ε�, �� �ڿ� ���� ����� �ؽ����� ���� ��ü�� �ؽ��� �ٲٴ� �Լ�
	public String getBlockHash() {
		String transactionInformation = "";
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformation += transactionList.get(i).getInformation();
		}
		return Util.getHash(transactionInformation + previousBlockHash);
	}
}
