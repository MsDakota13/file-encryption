package com.hro.encryper.crypters;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hro.encrypter.CryptoException;
import com.hro.encrypter.CryptoUtils;
import com.hro.gui.Frame;

public class AesCrypter extends CryptoUtils implements BaseCrypter {
	
	@SuppressWarnings("static-access")
	public AesCrypter(){
		super.ALGORITHM = "AES";
		super.TRANSFORMATION = "AES";
	}

	@Override
	public String encryptFile(String key, File inputFile, File encryptedFile) {
		// TODO Auto-generated method stub
		try {
            super.encrypt(key, inputFile, encryptedFile);
        } catch (CryptoException ex) { 
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            return "Encryption failed";
        }
		return "Encryption succeeded";
	}

	@Override
	public String decryptFile(String key, File inputFile, File decryptedFile) {
		// TODO Auto-generated method stub
		try {
            super.decrypt(key, inputFile, decryptedFile);
        } catch (CryptoException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            return "decryption failed";
        }
		return "Decryption succeeded";
	}

	@Override
	public int validateKey(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
