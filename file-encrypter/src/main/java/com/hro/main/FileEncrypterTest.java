package com.hro.main;

import java.io.File;
import com.hro.encrypter.*;

public class FileEncrypterTest {
	public static void main(String[] args) {
		String key = "Mary has one cat";
		File inputFile = new File("document.txt");
		File encryptedFile = new File("document.encrypted");
		File decryptedFile = new File("document.decrypted");
		
		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
