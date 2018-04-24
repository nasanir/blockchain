package indi.nasanir.blockchain.core.itf;

import java.security.NoSuchAlgorithmException;

import indi.nasanir.blockchain.core.service.Block;

public interface IBlockChain {
	public Block newBlock(String proof, String prvious_hash);

	public void setTransaction(String sender, String recipient, String amount);

	public boolean proofValid(String prvious_hash, String index, String version) throws NoSuchAlgorithmException;
}
