package test;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;

import ecc.Key;

public class BlockTest {
	public static void main(String[] arg){
		Key k=new Key();
			k.ecc();
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
