package ch.fhnw.sevenwonders.encrypthelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Gabriel de Castilho -> Source from
 *         https://stackoverflow.com/questions/10696432/encryption-of-password-in-java-or-mysql
 * 
 *         Diese Klasse stellt die Hashfunktion MD5 zur Verfügung, welche für
 *         die Passwortverschlüsselung verwendet wird.
 *
 */

public class EncryptWithMD5 {

	private static MessageDigest md;

	/*
	 * Diese statische Methode stellt die Hashfunktion MD5 zur Verfügung.
	 */
	public static String cryptWithMD5(String pass) {
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}

}
