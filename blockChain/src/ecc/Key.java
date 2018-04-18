package ecc;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;

import db.DbUtil;
import blockchain.util.Base58Util;
import blockchain.util.HexUtil;
import constant.Constant;
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

	public String ecc() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException {
		KeyPairGenerator keyP;
		keyP = KeyPairGenerator.getInstance("EC");
		ECGenParameterSpec ecP = new ECGenParameterSpec("secp256k1");
		keyP.initialize(ecP, new SecureRandom());
		KeyPair keyPair = keyP.generateKeyPair();
		String address = publicKeyToAddress(pubKeyToString(keyPair));
		db.add(priKeyToString(keyPair) + "   " + pubKeyToString(keyPair) + "   " + address + "\n");

		return address;
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

	public String publicKeyToAddress(String publicKey) throws NoSuchAlgorithmException {
		StringBuffer result = new StringBuffer();

		String hex256 = tohash.sha256(publicKey);
		String hex160 = tohash.ripe160(hex256);

		result.append(Constant.VER).append(hex160);

		String hex256Check = tohash.sha256(result.toString());
		hex256Check = tohash.sha256(hex256Check).substring(0, 8);
		result.append(hex256Check);
		return base58.base58Encode(result.toString(), Constant.HEX);
	}
}
