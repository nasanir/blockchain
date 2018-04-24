package indi.nasanir.blockchain.crypto.entity;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;

import indi.nasanir.blockchain.crypto.bean.KeyBean;
import indi.nasanir.blockchain.crypto.itf.Crypto;
import sun.security.ec.ECPublicKeyImpl;

public class EccCrypto implements Crypto {

	@Override
	public KeyBean getKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
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
	public byte[] sign(byte[] privateKey, String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean vaildate(byte[] publicKey, String info, String sign) {
		// TODO Auto-generated method stub
		return false;
	}

}
