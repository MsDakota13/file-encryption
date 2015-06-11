package com.hro.encryper.crypters;

import java.io.File;

import com.hro.encrypter.CryptoException;

public class Sha1Crypter extends BaseCrypter {

	@Override
	public String encryptFile(String key, File inputFile, File encryptedFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decryptFile(String key, File inputFile, File decryptedFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int validateKey(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void doCrypto(int cipherMode, String key, File inputFile,
			File outputFile) throws CryptoException {
		// TODO Auto-generated method stub
		
	}

}
