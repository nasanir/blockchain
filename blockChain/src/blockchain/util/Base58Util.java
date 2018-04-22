package blockchain.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import constant.Constant;

/**
 * 
 *  @ClassName: Base58Util    @Description: TODO  @author l  
 *  @date 2018年4月18日   
 */
public class Base58Util {

	public String base58Encode(String message, int radix) {
		boolean startZero = false;
		BigInteger num;
		if (message.startsWith(Constant.ZERO_STRING)) {
			while (message.startsWith(Constant.ZERO_STRING)) {
				message = message.substring(1);
			}
			startZero = true;
		}
		num = new BigInteger(message, radix);

		String result = base58Encode(num);
		if (startZero) {
			result = Constant.B58[0] + result;
		}
		return result;
	}

	public String base58Encode(BigInteger num) {
		String result = "";
		while (num.compareTo(Constant.ZERO) == 1) {
			result = Constant.B58[num.mod(Constant.BASE58_MOD).intValue()]
					+ result;
			num = num.divide(Constant.BASE58_MOD);
		}
		return result;
	}

	public String base58Decode(String message, int radix) {
		StringBuffer result;

		BigInteger num = Constant.ZERO;
		boolean startZero = false;

		if (message.startsWith("1")) {
			startZero = true;
		}

		int len = message.length();
		char[] messageArr = message.toCharArray();
		for (int i = len - 1; i >= 0; i--) {
			String index = String.valueOf(Arrays.binarySearch(Constant.B58,
					messageArr[len - i - 1]));
			num = ((new BigInteger(index)).multiply(Constant.BASE58_MOD.pow(i)))
					.add(num);
		}

		if (startZero) {

		}
		return num.toString(radix);
	}

}
