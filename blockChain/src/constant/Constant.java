package constant;

import java.math.BigInteger;

public class Constant {

	public static final BigInteger ZERO = new BigInteger("0");
	public static final BigInteger BASE58_MOD = new BigInteger("58");

	public static final char[] B58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
	public static final String B58_STRING="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
	
	public static final String ZERO_STRING = "0";
	public static final String HEX16_ZERO = "00";

	public static String VER = "0";
	public static int BITLENGHT = 32;
	
	public static int HEX=16;
	public static int BIN=2;
	public static int DEC=10;
	
	public static char[] HEXDIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

}
