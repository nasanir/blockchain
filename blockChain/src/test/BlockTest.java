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
import pers.nasanir.blockchain.crypto.bean.KeyBean;
import pers.nasanir.blockchain.crypto.entity.Base58Encoder;
import pers.nasanir.blockchain.crypto.entity.EccCrypto;
import pers.nasanir.blockchain.crypto.entity.Hex160Encoder;
import pers.nasanir.blockchain.crypto.entity.Hex256Encoder;
import pers.nasanir.blockchain.crypto.entity.Key;
import pers.nasanir.blockchain.crypto.util.TranslateUtil;

public class BlockTest {
	public static void main(String[] arg) {
		EccCrypto ec = new EccCrypto();
		try {
			KeyBean kb = ec.getKeyPair();
			Hex160Encoder e160 = new Hex160Encoder();
			Hex256Encoder e256 = new Hex256Encoder();
			byte[] hex = e160.encode(e256.encode(kb.getPublicKey()));
			byte[] result =new byte[hex.length+1+4];
			result[0]=0;
			
			System.arraycopy(hex, 0, result, 1, hex.length);
			byte[] hex8=e256.encode(e256.encode(result));
			System.arraycopy(hex8, 0, result, result.length-4, 4);
			Base58Encoder b58=new Base58Encoder();
			String s=b58.encode2String(result);
			System.out.println(s);
			String x=b58.encode2String(b58.decode(s));
			System.out.println(x);

		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
