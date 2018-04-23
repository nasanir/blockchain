package indi.nasanir.blockchain.core.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import blockchain.itf.IBlockChain;

public class BlockChain implements IBlockChain {
	private ArrayList<Block> chain;
	private ArrayList<Transaction> currentTransaction;
	
	public BlockChain() {
		// TODO Auto-generated constructor stub
		chain=new ArrayList<Block>();
		currentTransaction=new ArrayList<Transaction>();
	}
	
	@Override
	public Block newBlock(String proof,String prvious_hash){
		Block newBlock=new Block();
		newBlock.setBlock(chain.size()+1,"1", System.currentTimeMillis(), currentTransaction, proof, prvious_hash);
		chain.add(newBlock);
		currentTransaction.clear();
		return newBlock;
	}
	
	@Override
	public void setTransaction(String sender,String recipient,String amount){
		Transaction newTransaction=new Transaction(); 
		newTransaction.setTransaction(sender, recipient, amount);
		currentTransaction.add(newTransaction);
	}

	@Override
	public boolean proofValid(String prvious_hash,String index,String version) throws NoSuchAlgorithmException {

		return false;
	}
	
	private String blockHeader(String ){
		
	}
}
