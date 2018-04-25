package pers.nasanir.blockchain.crypto.abst;

import java.security.NoSuchAlgorithmException;

import pers.nasanir.blockchain.crypto.itf.Encoder;
import pers.nasanir.blockchain.crypto.util.TranslateUtil;

/**
 * 
 * @ClassName: AbstractEncoder
 * @Description: TODO
 * @author liyanzheng
 * @date 2018Äê4ÔÂ25ÈÕ
 */
public abstract class AbstractEncoder implements Encoder {
	/**
	 * decode input
	 * 
	 * @Title: decode
	 * @Description: decode input
	 * @param @param info
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	@Override
	public abstract byte[] decode(byte[] info);

	/**
	 * encode input
	 * 
	 * @Title: encode
	 * @Description: encode input
	 * @param @param info
	 * @param @return
	 * @return byte[]
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	public abstract byte[] encode(byte[] info) throws NoSuchAlgorithmException;

	@Override
	public String decode2String(byte[] info) {
		// TODO Auto-generated method stub
		return TranslateUtil.byte2Hex(decode(info));
	}

	@Override
	public byte[] encode(String info) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		return encode(TranslateUtil.string2Byte(info));
	}
}
