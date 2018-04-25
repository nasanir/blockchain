package pers.nasanir.blockchain.crypto.itf;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * @ClassName: Encode
 * @Description: encode interface
 * @author nasanir
 * @date 2018Äê4ÔÂ24ÈÕ
 */
public interface Encoder {
	/**
	 * decode info
	 * 
	 * @Title: decode
	 * @Description: decode info
	 * @param @param info
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	byte[] decode(byte[] info);

	/**
	 * @throws NoSuchAlgorithmException
	 *             encode info
	 * 
	 * @Title: encode
	 * @Description: encode info
	 * @param @param info
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	byte[] encode(byte[] info) throws NoSuchAlgorithmException;

	/**
	 * 
	 * @Title: decode2String
	 * @Description: decode info to String
	 * @param @param info
	 * @param @return
	 * @return String
	 * @throws
	 */
	String decode2String(byte[] info);

	/**
	 * @throws NoSuchAlgorithmException
	 * 
	 * @Title: encode
	 * @Description: encode string info
	 * @param @param info
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	byte[] encode(String info) throws NoSuchAlgorithmException;
	
	/**
	 * @throws NoSuchAlgorithmException 
	 * 
	 * @Title: encode2String
	 * @Description:encode info to String
	 * @param @param info
	 * @param @return
	 * @return String
	 * @throws
	 */
	String encode2String(byte[] info) throws NoSuchAlgorithmException;
	
	/**
	 * encode info
	 * 
	 * @Title: encode
	 * @Description: encode info
	 * @param @param info
	 * @param @return
	 * @return String
	 * @throws
	 */
	byte[] decode(String info);

}
