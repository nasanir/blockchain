package db;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import db.itf.db;
import blockchain.itf.IBlockChain;
import blockchain.Block;

public class DbUtil implements db {
	private static String BLOCK = "db/block.tdl";
	private static String WALLET = "db/wallet.txt";

	public void add(Block block) throws IOException {
		File blockFile = new File(BLOCK);
		String blockData = block.getBlockData();
		byte[] blockDataByte = blockData.getBytes();
		FileOutputStream fos = new FileOutputStream(blockFile,true);
		fos.write(blockDataByte);
		fos.close();
	}

	public String readAll() throws IOException {
		File file = new File(BLOCK);
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		int len = dis.available();
		String blockDbData = "";
		if (len > 0) {
			byte[] data = new byte[len];
			dis.read(data);
			blockDbData = data.toString();
		}
		dis.close();
		fis.close();
		return blockDbData;
	}
	
	public void add(String data) throws IOException {
		File File = new File(WALLET);
		byte[] DataByte = data.getBytes();
		FileOutputStream fos = new FileOutputStream(File,true);
		fos.write(DataByte);
		fos.close();
	}

	/**
	 * public static void main(String[] args) throws IOException{
	 * wirteBlockToDb(); readDb(); }
	 **/
}
