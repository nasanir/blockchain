package indi.nasanir.blockchain.crypto.itf;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

import indi.nasanir.blockchain.crypto.bean.KeyBean;

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
	public KeyBean getKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException;

	/**
	 * 
	 * @Title: sign 
	 * @Description: sign info with private key 
	 * @return byte[] 
	 * @throws
	 */
	public byte[] sign(byte[] privateKey, String info);

	/**
	 * 
	 * @Title: vaildate 
	 * @Description: vaildate sign with publickey 
	 * @return boolean 
	 * @throws
	 */
	public boolean vaildate(byte[] publicKey, String info, String sign);

}
