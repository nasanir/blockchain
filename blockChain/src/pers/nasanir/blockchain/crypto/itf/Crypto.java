package pers.nasanir.blockchain.crypto.itf;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import pers.nasanir.blockchain.crypto.bean.KeyBean;

/**
 * 
 * @ClassName: Crypto
 * @Description: crypto interface
 * @author nasanir
 * @date 2018年4月24日
 *
 */
public interface Crypto {
	/**
	 * 
	 * @Title: getKeyPair
	 * @Description: get key pair
	 * @return KeyBean
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 */
	KeyBean getKeyPair() throws NoSuchAlgorithmException,
			InvalidAlgorithmParameterException;

	/**
	 * 
	 * 
	 * @Title: sign
	 * @Description: sign info with private key
	 * @return byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	byte[] sign(byte[] privateKey, String info)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException;

	/**
	 * @throws SignatureException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * 
	 * @Title: vaildate
	 * @Description: vaildate sign with publickey
	 * @return boolean
	 * @throws
	 */
	boolean vaildate(byte[] publicKey, String info, byte[] sign)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException;

}
