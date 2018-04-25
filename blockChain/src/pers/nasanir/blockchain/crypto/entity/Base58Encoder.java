package pers.nasanir.blockchain.crypto.entity;

import java.math.BigInteger;

import pers.nasanir.blockchain.constant.Constant;
import pers.nasanir.blockchain.crypto.abst.AbstractEncoder;
import pers.nasanir.blockchain.crypto.itf.Encoder;

public class Base58Encoder extends AbstractEncoder implements Encoder {

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

	@Override
	public String decode2String(byte[] info) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (int i = 0; i < info.length; i++) {
			if (info[i] != 0) {
				flag = i;
				break;
			}
		}
		BigInteger infoNum = new BigInteger(info);
		StringBuffer result = new StringBuffer(infoNum.divide(Constant.BASE58_MOD).intValue() + flag);
		for (int i = 0; i < flag; i++) {
			result.append("1");
		}

		for (; infoNum.compareTo(Constant.ZERO) == 1;) {
			result.append(Constant.B58[infoNum.mod(Constant.BASE58_MOD)
					.intValue()]);
			infoNum = infoNum.divide(Constant.BASE58_MOD);
		}

		return result.toString();
	}

	@Override
	public byte[] encode(String info) {
		// TODO Auto-generated method stub
		int flag=0;
		char[] num=info.toCharArray();
		for(int i=0;i<num.length;i++){
			if(num[i]!='1'){
				flag=i;
				break;
			}
		}
		byte[] result=new byte[(num.length-flag)*58+flag];
		
		return null;
	}

}
