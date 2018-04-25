package pers.nasanir.blockchain.crypto.entity;

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
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import pers.nasanir.blockchain.crypto.bean.KeyBean;
import pers.nasanir.blockchain.crypto.itf.Crypto;
import sun.security.ec.ECPublicKeyImpl;

/**
 * 
 * @ClassName: EccCrypto
 * @Description: TODO
 * @author nasanir
 * @date 2018Äê4ÔÂ24ÈÕ
 */
public class EccCrypto implements Crypto {

	@Override
	public KeyBean getKeyPair() throws NoSuchAlgorithmException,
			InvalidAlgorithmParameterException {
		// TODO Auto-generated method stub
		KeyPairGenerator keypairGen = KeyPairGenerator.getInstance("EC");
		ECGenParameterSpec parameterSpec = new ECGenParameterSpec("secp256k1");
		keypairGen.initialize(parameterSpec, new SecureRandom());

		KeyPair keyPair = keypairGen.generateKeyPair();
		ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
		ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();

		KeyBean keyBean = new KeyBean();
		keyBean.setPublicKey(ecPublicKey.getW().getAffineX().toByteArray());
		keyBean.setPirvateKey(ecPrivateKey.getS().toByteArray());

		return keyBean;
	}

	@Override
	public byte[] sign(byte[] privateKey, String info)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		// TODO Auto-generated method stub

		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		PrivateKey genPrivateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature sign = Signature.getInstance("SHA1withECDSA");
		sign.initSign(genPrivateKey);
		sign.update(info.getBytes());
		return sign.sign();
	}

	@Override
	public boolean vaildate(byte[] publicKey, String info, byte[] sign)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		// TODO Auto-generated method stub

		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		PublicKey genPublicKey = keyFactory.generatePublic(x509KeySpec);
		Signature vaildate = Signature.getInstance("SHA1withECDSA");
		vaildate.initVerify(genPublicKey);
		vaildate.update(info.getBytes());
		boolean isVaildate = vaildate.verify(sign);
		return false;
	}

}
