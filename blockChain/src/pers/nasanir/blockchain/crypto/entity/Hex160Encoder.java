package pers.nasanir.blockchain.crypto.entity;

import java.security.MessageDigest;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;

import pers.nasanir.blockchain.crypto.abst.AbstractEncoder;
import pers.nasanir.blockchain.crypto.itf.Encoder;
import pers.nasanir.blockchain.crypto.util.TranslateUtil;

/**
 * 
 * @ClassName: Hex160Encoder
 * @Description: TODO
 * @author nasanir
 * @date 2018Äê4ÔÂ25ÈÕ
 */
public class Hex160Encoder extends AbstractEncoder implements Encoder {

	@Override
	public byte[] encode(byte[] info) {
		// TODO Auto-generated method stub
		RIPEMD160Digest rd = new RIPEMD160Digest();
		rd.update(info, 0, info.length);
		byte[] ciphertext = new byte[rd.getDigestSize()];
		rd.doFinal(ciphertext, 0);
		return ciphertext;
	}

	@Override
	public byte[] decode(byte[] info) {
		// TODO Auto-generated method stub
		return null;
	}

}
