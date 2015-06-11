package com.hro.encrypter;

import java.io.File;

import com.hro.encryper.crypters.AesCrypter;

public class CryptoHandler {
	
	public String encrypt(String cryptoMethod, String key, File inputFile, File encryptedFile){
		switch (cryptoMethod.toUpperCase()){
			case "AES":
				return new AesCrypter().encryptFile(key, inputFile, encryptedFile);
			default:
				return "Invaled Crypto Method";
		}
	}
	
	public String decrypt(String cryptoMethod, String key, File inputFile, File decryptedFile){
		switch (cryptoMethod.toUpperCase()){
		case "AES":
			return new AesCrypter().decryptFile(key, inputFile, decryptedFile);
		default:
			return "Invaled Crypto Method";
	}
	}

}
