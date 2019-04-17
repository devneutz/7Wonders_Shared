package ch.fhnw.sevenwonders.encrypthelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author https://stackoverflow.com/questions/10696432/encryption-of-password-in-java-or-mysql
 *
 */

public class EncryptWithMD5 {
	
	private static MessageDigest md;

	   public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(EncryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


	   }

}
