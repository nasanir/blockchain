package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.function.Consumer;

import blockchain.util.HexUtil;
import pers.nasanir.blockchain.crypto.entity.Key;
import pers.nasanir.blockchain.crypto.util.TranslateUtil;

public class BlockTest {
	public static void main(String[] arg) {
		double s= Math.log(4)/Math.log(2);
		System.out.println(s);
	}

	private static byte divmod58(byte[] number, int startAt) {
		int remainder = 0;
		for (int i = startAt; i < number.length; i++) {
			int digit256 = (int) number[i] & 0xFF;
			System.out.println(digit256);
			int temp = remainder * 256 + digit256;

			number[i] = (byte) (temp / 58);
			System.out.println(number[i]);
			remainder = temp % 58;
		}
		return (byte) remainder;
	}
}
