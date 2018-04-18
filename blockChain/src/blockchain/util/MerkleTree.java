package blockchain.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import blockchain.Block;
import blockchain.Transaction;

public class MerkleTree {
	HexUtil tohash = new HexUtil();

	ArrayList<String> hashList = new ArrayList<String>();
	
	/**
	 * get merkel tree root form this block
	 * @param block
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public String getMPTroot(Block block) throws NoSuchAlgorithmException {
		ArrayList<Transaction> TransList = block.getTransactions();
		for (Transaction transaction : TransList) {
			String transContent = transaction.getTransContent();
			String transHash = tohash.sha256(transContent);
			hashList.add(transHash);
		}
		return IterationRoot(hashList);
	}
	
	/**
	 * Iteration transactions's hash value to get root
	 * 
	 * @param hashlist
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public String IterationRoot(ArrayList<String> hashlist)
			throws NoSuchAlgorithmException {
		String previousHash = "";
		String hash = "";
		ArrayList<String> newHashList = new ArrayList<String>();
		if (hashList.size() != 1) {
			for (int i = 0; i < hashList.size(); i++) {
				if (i % 2 == 0) {
					if (i != hashlist.size() - 1)
						previousHash = hashlist.get(i);
					else {
						hash = tohash.sha256(hashList.get(i) + hashlist.get(i));
						newHashList.add(hash);
					}
				} else {
					hash = tohash.sha256(previousHash + hashlist.get(i));
					newHashList.add(hash);
				}
			}
			hash = IterationRoot(newHashList);
		} else {
			hash = hashlist.get(0);
		}
		return hash;
	}
}
