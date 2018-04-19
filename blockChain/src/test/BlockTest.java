package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import ecc.Key;

public class BlockTest {
	public static void main(String[] arg) {
		Key k=new Key();
		try {
			KeyPair kp=k.ecc();
			String sign=k.sign(k.priKeyToString(kp), "123332123123");
			
			
		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
