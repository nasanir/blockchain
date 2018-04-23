package blockchain.util;

import indi.nasanir.blockchain.constant.Constant;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

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

		StringBuffer resultBuf = new StringBuffer();
		resultBuf.append("");
		for (byte key : keyArr) {
			resultBuf.append(Constant.HEXDIGITS[key >>> 4 & 0xf]).append(
					Constant.HEXDIGITS[key & 0xf]);
		}
		if (resultBuf.toString().startsWith(Constant.HEX16_ZERO)) {
			resultBuf.delete(0, 2);
		}
		return resultBuf.toString();
	}

	public byte[] hexToByte(String hex) {

		if (hex.length() % 2 != 0) {
			hex += "0";
		}
		char[] hexBit = hex.toCharArray();
		byte[] byteArr = new byte[hex.length() / 2];
		for (int i = 0; i < hexBit.length; i++) {
			if (i % 2 == 0) {
				byteArr[i / 2] = (byte) ((((Arrays.binarySearch(
						Constant.HEXDIGITS, hexBit[i])) & 0xf) << 4) + ((Arrays
						.binarySearch(Constant.HEXDIGITS, hexBit[i + 1])) & 0xf));
			}
		}
		return byteArr;
	}
}
