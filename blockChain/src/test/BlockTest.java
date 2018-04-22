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
import java.util.List;
import java.util.function.Consumer;

import blockchain.Block;
import blockchain.Transaction;
import blockchain.util.HexUtil;
import ecc.Key;

public class BlockTest {
	public static void main(String[] arg) {
		Transaction t=new Transaction();
		t.setTransaction(1, "a", "v", "1");
		Consumer<Transaction> numCon=x->x.setTransaction(2, "c", "c", "c");
		numCon.accept(t);
		System.out.println(t.getIndex());
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
