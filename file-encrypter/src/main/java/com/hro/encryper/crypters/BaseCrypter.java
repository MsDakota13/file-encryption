package com.hro.encryper.crypters;

import java.io.File;

public interface BaseCrypter {
	
	//input a key, input the file you want to encrypt, input file where to write the encrypted file to
	String encryptFile(String key, File inputFile, File encryptedFile);
	
	//input a key, input the encrypetd file you wish to decrypt, input the decrypted file location/name
	String decryptFile(String key, File inputFile, File decryptedFile);
	
	abstract int validateKey(String key);

}
