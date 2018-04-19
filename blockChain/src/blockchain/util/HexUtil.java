package blockchain.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import constant.Constant;

/**
 * 
 * @author liyanzheng
 *
 */
public class HexUtil {

	public String sha256(String message) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(message.getBytes());
		byte[] ciphertext = md.digest();
		return byteToHex(ciphertext);
	}

	public String sha256T(String message) throws NoSuchAlgorithmException {
		return sha256(sha256(message));
	}

	public String ripe160(String message) throws NoSuchAlgorithmException {
		RIPEMD160Digest digest = new RIPEMD160Digest();
		digest.update(message.getBytes(), 0, message.getBytes().length);
		byte[] ciphertext = new byte[digest.getDigestSize()];
		digest.doFinal(ciphertext, 0);

		return byteToHex(ciphertext);
	}

	public String byteToHex(byte[] keyArr) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer resultBuf = new StringBuffer();
		resultBuf.append("");
		for (byte key : keyArr) {
			resultBuf.append(hexDigits[key >>> 4 & 0xf]).append(hexDigits[key & 0xf]);
		}
		if (resultBuf.toString().startsWith(Constant.HEX16_ZERO)) {
			resultBuf.delete(0, 2);
		}
		return resultBuf.toString();
	}
	
	public byte[] hexToByte(String hex){
		char[] hexBit=hex.toCharArray();
		
		
		return null;
	}

}
