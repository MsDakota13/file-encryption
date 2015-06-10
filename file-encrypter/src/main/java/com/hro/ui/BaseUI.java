package com.hro.ui;

import java.io.File;

import com.hro.encrypter.CryptoException;
import com.hro.encrypter.CryptoUtils;

public class BaseUI {
	
	//input a key, input the file you want to encrypt, input file where to write the encrypted file to
	private void encryptFile(String key, File inputFile, File encryptedFile){
		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	//input a key, input the encrypetd file you wish to decrypt, input the decrypted file location/name
	private void decryptFile(String key, File inputFile, File decryptedFile){
		try {
			CryptoUtils.decrypt(key, inputFile, decryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
