package pers.nasanir.blockchain.core.service;

import java.io.ObjectInputStream.GetField;


public class Transaction {
	private String sender;
	private String recipient;
	private String amount;
	private int index;
	
	public int getIndex(){
		return this.index;
	}

	public String getSender() {
		return this.sender;
	}

	public String getRecipient() {
		return this.recipient;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setTransaction(int index,String sender, String recipient, String amount) {
		this.index=index;
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}

	public String getTransContent() {
		StringBuffer transaction = new StringBuffer();
		transaction.append(this.sender).append(this.recipient)
				.append(this.amount);
		return transaction.toString();
	}
}
