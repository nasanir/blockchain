package indi.nasanir.blockchain.core.service;

import java.util.ArrayList;

public class Block {
	private int index;
	private String version;
	private Long timestamp;
	private ArrayList<Transaction> transactions;
	private String proof;
	private String previous_hash;
	private String hash;

	public int getIndex() {
		return this.index;
	}

	public Long getTimestamp() {
		return this.timestamp;
	}

	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	public String getProof() {
		return this.proof;
	}

	public String getPrevious_hash() {
		return this.previous_hash;
	}
	
	public String getHash() {
		return this.hash;
	}
	
	public String getVersion(){
		return this.version;
	}

	public void setBlock(int index,String version, Long timestamp,
			ArrayList<Transaction> transactions, String proof,
			String prvious_hash) {
		this.index = index;
		this.timestamp = timestamp;
		for (Transaction t : transactions) {
			transactions.add(t);
		}
		this.proof = proof;
		this.previous_hash = previous_hash;
	}
	
	public String getBlockData(){
		StringBuffer blockData = new StringBuffer();
		blockData.append(this.index).append(",")
				 .append(this.timestamp).append(",")
				 .append(this.hash).append(",")
				 .append(this.proof).append(",")
				 .append(this.previous_hash).append(";");
		return blockData.toString();
	}
}
