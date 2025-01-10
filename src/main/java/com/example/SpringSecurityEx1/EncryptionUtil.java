package com.example.SpringSecurityEx1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionUtil {

    private static final SecretKey SECRET_KEY = generatKey();

    private static SecretKey generatKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);

            return keyGen.generateKey();
        } catch (Exception e){
            throw new RuntimeException("Error while generating key");
        }
    }

    public static String encrypt(String data){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);

            byte[] dataBytes = data.getBytes();
            byte[] encryptedBytes = cipher.doFinal(dataBytes);

            String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
            return encryptedString;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String decrypt(String encryptedData){
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);

            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            String decryptedString = new String(decryptedBytes);
            return decryptedString;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
