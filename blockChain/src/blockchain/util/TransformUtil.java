package blockchain.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 
 * @author liyanzheng
 *
 */
public class TransformUtil {
	private static final String HEX16_ZERO = "00";
	private static final String ZERO = "0";
	private static final String BASE58_MOD = "58";
	private static final String BASE256_MOD = "256";

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
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD160");
		byte[] ciphertext = md.digest();
		return byteToHex(ciphertext);
	}

	public String byteToHex(byte[] keyArr) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer resultBuf = new StringBuffer();
		resultBuf.append("");
		for (byte key : keyArr) {
			resultBuf.append(hexDigits[key >>> 4 & 0xf]).append(
					hexDigits[key & 0xf]);
		}
		if (resultBuf.toString().startsWith(HEX16_ZERO)) {
			resultBuf.delete(0, 2);
		}
		return resultBuf.toString();
	}

	public String base58Encode(String message) {
		BigInteger hex = base256Encode(message);
		char[] b58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
				.toCharArray();

		String result = "";
		while (hex.compareTo(new BigInteger(ZERO)) == 1) {
			result = b58[Integer.valueOf(hex.mod(new BigInteger(BASE58_MOD))
					.toString())] + result;
			hex=hex.divide(new BigInteger(BASE58_MOD));
		}
		return result;
	}

	public BigInteger base256Encode(String message) {
		BigInteger result = new BigInteger(ZERO);
		for (char s : message.toCharArray()) {
			result = result.multiply(new BigInteger(BASE256_MOD)).add(
					new BigInteger(String.valueOf((int) s)));
		}
		System.out.println(result);
		return result;
	}
	
	public String hex16Tobase58Encode(String message){
		BigInteger hex =new BigInteger(message,16);
		char[] b58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
				.toCharArray();

		String result = "";
		while (hex.compareTo(new BigInteger(ZERO)) == 1) {
			result = b58[Integer.valueOf(hex.mod(new BigInteger(BASE58_MOD))
					.toString())] + result;
			hex=hex.divide(new BigInteger(BASE58_MOD));
		}
		return result;
	}

	public String byteTo10String() {
		return null;
	}

}
