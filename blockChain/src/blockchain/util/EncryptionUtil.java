package blockchain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 
* <p>Title: encryptionUtil</p>  
* <p>Description: </p>  
* @author nasanir  
* @date 2018年4月14日  
 */
public class EncryptionUtil {
	/**
	 * 
	 * <p>Title: sha256</p>  
	 * <p>Description: </p>
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException  
	 
	 */
	public String sha256(String message) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(message.getBytes());
		byte[] ciphertext = md.digest();
		return byteToHex(ciphertext);
	}
	
	/**
	 * 
	 * <p>Title: sha256T</p>  
	 * <p>Description: </p>
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException  
	 
	 */
	public String sha256T(String message) throws NoSuchAlgorithmException {
		return sha256(sha256(message));
	}
	
	/**
	 * 
	 * <p>Title: ripe160</p>  
	 * <p>Description: </p>
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException  
	 
	 */
	public String ripe160(String message) throws NoSuchAlgorithmException {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD160");
		byte[] ciphertext = md.digest();
		return byteToHex(ciphertext);
	}
	
	/**
	 * 
	 * <p>Title: byteToHex</p>  
	 * <p>Description: </p>
	 * @param keyArr
	 * @return  
	 
	 */
	public String byteToHex(byte[] keyArr) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer resultBuf = new StringBuffer();
		resultBuf.append("");
		for (byte key : keyArr) {
			resultBuf.append(hexDigits[key >>> 4 & 0xf]).append(hexDigits[key & 0xf]);
		}
		if(resultBuf.toString().startsWith("00")){
			resultBuf.delete(0, 2);
		}
		return resultBuf.toString();
	}
	
	/**
	 * 
	 * <p>Title: hexToBase58</p>  
	 * <p>Description: </p>
	 * @param hex
	 * @return  
	 
	 */
	public String hexToBase58(String hex) {
		String base58Digits="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
		char[] base58Arr=base58Digits.toCharArray();
		
		
		
		return hex;
	}

}
