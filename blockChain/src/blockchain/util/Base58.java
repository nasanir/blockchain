package blockchain.util;

import java.math.BigInteger;

public class Base58 {
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger BASE58_MOD = new BigInteger("58");
	private static final char[] b58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
			.toCharArray();

	public String hex16Tobase58Encode(String message) {

		boolean startZero = false;
		if (message.startsWith("0")) {
			while (message.startsWith("0")) {
				message = message.substring(1);
			}
			startZero = true;
		}
		BigInteger hex = new BigInteger(message, 16);

		String result = "";
		while (hex.compareTo(ZERO) == 1) {
			result = b58[Integer.valueOf(hex.mod(BASE58_MOD).toString())]
					+ result;
			hex = hex.divide(BASE58_MOD);
		}

		if (startZero) {
			result = b58[0] + result;
		}

		return result;
	}

	public String StringTobase58Encode(String message) {
		BigInteger num = new BigInteger(message);
		String result = "";
		while (num.compareTo(ZERO) == 1) {
			result = b58[Integer.valueOf(num.mod(BASE58_MOD).toString())]
					+ result;
			num = num.divide(BASE58_MOD);
		}
		return message;
	}
}
