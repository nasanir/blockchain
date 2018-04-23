package indi.nasanir.blockchain.crypto.ecc;

import indi.nasanir.blockchain.constant.Constant;
import indi.nasanir.blockchain.db.DbUtil;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import blockchain.util.Base58Util;
import blockchain.util.HexUtil;
import sun.security.ec.ECPublicKeyImpl;

/**
 * 
 * @author liyanzheng
 *
 */
public class Key {
	private HexUtil tohash = new HexUtil();
	private Base58Util base58 = new Base58Util();
	private DbUtil db = new DbUtil();

	public KeyPair getKey() throws IOException,
			InvalidAlgorithmParameterException, NoSuchAlgorithmException {
		KeyPairGenerator keyP;
		keyP = KeyPairGenerator.getInstance("EC");
		ECGenParameterSpec ecP = new ECGenParameterSpec("secp256k1");
		keyP.initialize(ecP, new SecureRandom());
		KeyPair keyPair = keyP.generateKeyPair();
		return keyPair;
	}

	public String pubKeyToString(KeyPair keyPair) {
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

	public String publicKeyToAddress(String publicKey)
			throws NoSuchAlgorithmException {
		StringBuffer result = new StringBuffer();

		String hex256 = tohash.sha256(publicKey);
		String hex160 = tohash.ripe160(hex256);

		result.append(Constant.VER).append(hex160);

		String hex256Check = tohash.sha256(result.toString());
		hex256Check = tohash.sha256(hex256Check).substring(0, 8);
		result.append(hex256Check);
		return base58.base58Encode(result.toString(), Constant.HEX);
	}

	public String sign(String privateKey, String message)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			SignatureException, InvalidKeyException {

		PKCS8EncodedKeySpec pkc = new PKCS8EncodedKeySpec(new BigInteger(
				privateKey).toByteArray());
		KeyFactory keyfactory = KeyFactory.getInstance("EC");
		PrivateKey genprivateKey = keyfactory.generatePrivate(pkc);
		Signature sign = Signature.getInstance("SHA1withECDSA");
		sign.initSign(genprivateKey);
		sign.update(message.getBytes());
		byte[] signArr = sign.sign();
		String hex = tohash.byteToHex(signArr);
		return hex;
	}

	public boolean vaild(String publickKey, String message, String signHex)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		X509EncodedKeySpec pkx = new X509EncodedKeySpec(
				new BigInteger(message).toByteArray());
		KeyFactory keyfact = KeyFactory.getInstance("EC");
		PublicKey publick = keyfact.generatePublic(pkx);
		Signature sign = Signature.getInstance("SHA1withECDSA");
		sign.initVerify(publick);
		sign.update(message.getBytes());
		boolean issign = sign.verify(tohash.hexToByte(signHex));
		return issign;
	}
}
