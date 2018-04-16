package ecc;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.util.Base64;

import blockchain.util.EncryptionUtil;
import sun.security.ec.ECPublicKeyImpl;

/**
 * 
 * <p>
 * Title: key
 * </p>
 *  
 * <p>
 * Description:
 * </p>
 *  
 * 
 * @author nasanir  
 * @date 2018年4月14日  
 */
public class Key {
	EncryptionUtil tohash = new EncryptionUtil();

	/**
	 * 
	 *  *
	 * <p>
	 * Title: ecc
	 * </p>
	 *    *
	 * <p>
	 * Description:
	 * </p>
	 *  * @return    
	 */
	public String ecc() {
		KeyPairGenerator keyP;
		try {
			keyP = KeyPairGenerator.getInstance("EC");
			ECGenParameterSpec ecP = new ECGenParameterSpec("secp256k1");
			keyP.initialize(ecP, new SecureRandom());
			KeyPair keyPair = keyP.generateKeyPair();
			System.out.println(keyPair.getPublic());
			byte[] a = pubKeyToByteArr(keyPair);
			printByte(a);
			return "";

		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 
	 *  *
	 * <p>
	 * Title: pubKeyToString
	 * </p>
	 *    *
	 * <p>
	 * Description:
	 * </p>
	 *  * @param keyPair  * @return    
	 */
	public byte[] pubKeyToByteArr(KeyPair keyPair) {
		byte[] keyArr = new byte[64];
		PublicKey genPublicKey = keyPair.getPublic();
		ECPublicKeyImpl ecPulicKey = (ECPublicKeyImpl) genPublicKey;

		byte[] xArrSrc = ecPulicKey.getW().getAffineX().toByteArray();
		byte[] yArrSrc = ecPulicKey.getW().getAffineY().toByteArray();
		printByte(xArrSrc);
		printByte(yArrSrc);
		if (xArrSrc.length != 32) {
			System.arraycopy(xArrSrc, 1, keyArr, 0, 32);
		}
		if (yArrSrc.length != 32) {
			System.arraycopy(yArrSrc, 1, keyArr, 32, 32);
		} else {
			System.arraycopy(yArrSrc, 0, keyArr, 32, 32);
		}
		return keyArr;
	}

	/**
	 * 
	 *  *
	 * <p>
	 * Title: priKeyToString
	 * </p>
	 *    *
	 * <p>
	 * Description:
	 * </p>
	 *  * @param keyPair  * @return    
	 */
	public String priKeyToString(KeyPair keyPair) {
		PrivateKey genprivateKey = keyPair.getPrivate();
		ECPrivateKey ecPrivateKey = (ECPrivateKey) genprivateKey;
		return ecPrivateKey.getS().toString();
	}

	public String publicKeyToAddress(byte[] publicKeyArr) throws NoSuchAlgorithmException {
		byte[] addrArrF=new byte[65];
		addrArrF[0]=64;
		System.arraycopy(publicKeyArr, 0, addrArrF, 64, 64);
		String publicKey=
		StringBuffer checkData = new StringBuffer();
		StringBuffer result = new StringBuffer();

		String hex256 = tohash.sha256(publick);
		checkData.append(hex256.substring(0, 4));

		String hex160 = tohash.ripe160(hex256);
		checkData.append(hex160.substring(0, 4));

		result.append("00").append(hex256).append(hex160).append(checkData.toString());
		return result.toString();
	}

	public void printByte(byte[] a) {
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println("----");
	}

}
