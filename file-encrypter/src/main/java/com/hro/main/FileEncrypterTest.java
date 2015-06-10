package com.hro.main;

import java.io.File;
import com.hro.encrypter.*;

public class FileEncrypterTest {
    
        static String target="C:\\Users\\cyvan\\Documents\\GitHub\\en\\";
    
	public static void main(String[] args) {
		String key = "Mary has one cat";
		File inputFile = new File(target+"New Text Document.txt");
		File encryptedFile = new File(target+"document.encrypted");
		File decryptedFile = new File(target+"document.decrypted");
		
		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
