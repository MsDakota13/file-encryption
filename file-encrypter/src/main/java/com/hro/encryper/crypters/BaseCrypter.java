package com.hro.encryper.crypters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.hro.encrypter.CryptoException;

public abstract class BaseCrypter {
	
    protected static String ALGORITHM;
    protected static String TRANSFORMATION;
    
    public void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    public void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
 
    protected static void saveCrypto(Cipher cipher, File inputFile,
            File outputFile) throws CryptoException {
        try {
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (BadPaddingException | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    
    //sets up the keys and cipher required to execute doCrypto
    protected abstract void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws CryptoException;
	
	//input a key, input the file you want to encrypt, input file where to write the encrypted file to
	abstract String encryptFile(String key, File inputFile, File encryptedFile);
	
	//input a key, input the encrypetd file you wish to decrypt, input the decrypted file location/name
	abstract String decryptFile(String key, File inputFile, File decryptedFile);
	
	abstract int validateKey(String key);

}
