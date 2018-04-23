package indi.nasanir.blockchain.crypto.bean;

import java.io.Serializable;

public class KeyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6852692778026601044L;
	private String pirvateKey;
	private String publicKey;

	public String getPirvateKey() {
		return pirvateKey;
	}

	public void setPirvateKey(String pirvateKey) {
		this.pirvateKey = pirvateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

}
