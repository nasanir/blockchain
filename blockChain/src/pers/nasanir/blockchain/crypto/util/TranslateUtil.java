package pers.nasanir.blockchain.crypto.util;

import java.util.Arrays;

import pers.nasanir.blockchain.constant.Constant;



public class TranslateUtil {
	public static String byte2Hex(byte[] message) {
		StringBuffer result = new StringBuffer(message.length * 2);
		for (byte b : message) {
			result.append(Constant.HEXDIGITS[(b >>> 4) & 0xF]).append(
					Constant.HEXDIGITS[(b & 0xf)]);
		}
		return result.toString();
	}

	public static byte[] string2Byte(String message) {
		if (message.length() % 2 != 0) {
			message = "0" + message;
		}
		byte[] result = new byte[message.length() / 2];
		for (int i = 0; i < message.length(); i++) {
			if (i % 2 == 0) {
				result[i / 2] = (byte) (((int) Arrays.binarySearch(
						Constant.HEXDIGITS, message.charAt(i)) << 4) + ((int) Arrays
						.binarySearch(Constant.HEXDIGITS, message.charAt(i + 1))));
			}
		}
		return result;
	}
}
