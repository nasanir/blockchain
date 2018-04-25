package pers.nasanir.blockchain.db.itf;

import java.io.IOException;

import pers.nasanir.blockchain.core.service.Block;


public interface db {
	/**
	 * read all block chain data from db file
	 * @return
	 * @throws IOException
	 */
	public String readAll() throws IOException;
	
	
	/**
	 * add a new block to db file
	 * @param block
	 * @throws IOException
	 */
	public void add(Block block) throws IOException;
}
