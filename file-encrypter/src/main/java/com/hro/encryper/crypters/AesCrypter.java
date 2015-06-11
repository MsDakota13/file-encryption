package com.hro.encryper.crypters;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.hro.encrypter.CryptoException;
import com.hro.gui.Frame;

public class AesCrypter extends BaseCrypter {
	
	@SuppressWarnings("static-access")
	public AesCrypter(){
		super.ALGORITHM = "AES";
		super.TRANSFORMATION = "AES";
	}

	@Override
	public String encryptFile(String key, File inputFile, File encryptedFile) {
		if(validateKey(key) == 1){
			return "Encryption key is invalid";
		}
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
		if(validateKey(key) == 1){
			return "Encryption key is invalid";
		}
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
		if(!(key.length() == 16)){
			return 1;
		}
		return 0;
	}

	@Override
	protected void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws CryptoException {
		try {
			Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(cipherMode, secretKey);
			super.saveCrypto(cipher, inputFile, outputFile);
		}catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException ex){
			throw new CryptoException("Error encrypting/decrypting file", ex);
		}
	}
}
