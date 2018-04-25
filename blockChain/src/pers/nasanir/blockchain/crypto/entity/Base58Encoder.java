package pers.nasanir.blockchain.crypto.entity;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import pers.nasanir.blockchain.constant.Constant;
import pers.nasanir.blockchain.crypto.abst.AbstractEncoder;
import pers.nasanir.blockchain.crypto.itf.Encoder;

public class Base58Encoder extends AbstractEncoder implements Encoder {

	@Override
	public byte[] decode(String info) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int flag = 0;
		char[] c = info.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] != '1') {
				flag = i;
				break;
			}
		}
		int len = c.length - flag - 1;
		BigInteger num = Constant.ZERO;
		for (int i = flag; i<len; i++) {
			num = (BigInteger.valueOf(Arrays.binarySearch(Constant.B58, c[i]))).multiply(Constant.BASE58_MOD.pow(len-i+1))
					.add(num);
		}
		byte[] numArr = num.toByteArray();
		byte[] result = new byte[numArr.length + flag];
		System.arraycopy(numArr, 0, result, flag, numArr.length);
		return result;
	}

	@Override
	public String encode2String(byte[] info) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		int flag = 0;
		for (int i = 0; i < info.length; i++) {
			if (info[i] != 0) {
				flag = i;
				break;
			}
		}
		BigInteger infoNum = new BigInteger(info);
		StringBuffer result = new StringBuffer(
				(int) (Math.ceil(Math.log(infoNum.doubleValue()) / Math.log(Constant.BASE58_MOD.doubleValue()))
						+ flag));
		for (int i = 0; i < flag; i++) {
			result.append("1");
		}

		for (; infoNum.compareTo(Constant.ZERO) == 1;) {
			result.append(Constant.B58[infoNum.mod(Constant.BASE58_MOD).intValue()]);
			infoNum = infoNum.divide(Constant.BASE58_MOD);
		}

		return result.toString();
	}

	@Override
	public byte[] decode(byte[] info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] encode(byte[] info) {
		// TODO Auto-generated method stub
		return null;
	}
}
