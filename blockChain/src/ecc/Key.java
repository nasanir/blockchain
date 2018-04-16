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

import blockchain.util.TransformUtil;
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
	TransformUtil tohash = new TransformUtil();


	public String ecc() {
		KeyPairGenerator keyP;
		try {
			keyP = KeyPairGenerator.getInstance("EC");
			ECGenParameterSpec ecP = new ECGenParameterSpec("secp256k1");
			keyP.initialize(ecP, new SecureRandom());
			KeyPair keyPair = keyP.generateKeyPair();
			System.out.println(keyPair.getPublic());
			System.out.println(publicKeyToAddress(pubKeyToString(keyPair)));
			System.out.println(publicKeyToAddress(pubKeyToString(keyPair)).length());
			return "";

		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	public byte[] pubKeyToByteArr(KeyPair keyPair) {
		byte[] keyArr = new byte[32];
		PublicKey genPublicKey = keyPair.getPublic();
		ECPublicKeyImpl ecPulicKey = (ECPublicKeyImpl) genPublicKey;

		byte[] xArrSrc = ecPulicKey.getW().getAffineX().toByteArray();
		if (xArrSrc.length != 32) {
			System.arraycopy(xArrSrc, 1, keyArr, 0, 32);
		}
		return keyArr;
	}

	public String pubKeyToString(KeyPair keyPair){
		PublicKey genPublicKey = keyPair.getPublic();
		ECPublicKeyImpl ecPulicKey = (ECPublicKeyImpl) genPublicKey;
		String xArrSrc = ecPulicKey.getW().getAffineX().toString();
		return xArrSrc;
	}
	
	
	public String priKeyToString(KeyPair keyPair) {
		PrivateKey genprivateKey = keyPair.getPrivate();
		ECPrivateKey ecPrivateKey = (ECPrivateKey) genprivateKey;
		return ecPrivateKey.getS().toString();
	}

	public String publicKeyToAddress(String publicKey) throws NoSuchAlgorithmException {
		StringBuffer result = new StringBuffer();

		String hex256 = tohash.sha256(publicKey);
		String hex160 = tohash.ripe160(hex256);
		
		result.append("34").append(hex160);
		
		String hex256Check=tohash.sha256(result.toString());
		hex256Check=tohash.sha256(hex256Check).substring(0,8);
		result.append(hex256Check);
		
		return tohash.hex16Tobase58Encode(result.toString());
	}


}
