package pers.nasanir.blockchain.crypto.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import pers.nasanir.blockchain.crypto.abst.AbstractEncoder;
import pers.nasanir.blockchain.crypto.itf.Encoder;
import pers.nasanir.blockchain.crypto.util.TranslateUtil;

public class Hex256Encoder extends AbstractEncoder implements Encoder {

	@Override
	public byte[] encode(byte[] info) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(info);
		return md.digest();
	}

	@Override
	public byte[] decode(byte[] info) {
		// TODO Auto-generated method stub
		return null;
	}

}
