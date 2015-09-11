/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author filipzelic
 */
public class SHA256HashAlgorithm {
    public String getHash(String password) throws NoSuchAlgorithmException {
        return convertToHexString(createPasswordHash(password));
    }
    
    private byte[] createPasswordHash(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(input.getBytes());
        byte byteHash[] = messageDigest.digest();
        
        return byteHash;
    }
    
    private String convertToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
    	for (int i=0;i<bytes.length;i++) {
    		String hex=Integer.toHexString(0xff & bytes[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
        return hexString.toString();
    }
}
