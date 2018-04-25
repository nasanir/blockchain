package pers.nasanir.blockchain.crypto.bean;

import java.io.Serializable;

public class KeyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6852692778026601044L;
	private byte[] pirvateKey;
	private byte[] publicKey;

	public byte[] getPirvateKey() {
		return pirvateKey;
	}

	public void setPirvateKey(byte[] pirvateKey) {
		this.pirvateKey = pirvateKey;
	}

	public byte[] getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(byte[] publicKey) {
		this.publicKey = publicKey;
	}

}
