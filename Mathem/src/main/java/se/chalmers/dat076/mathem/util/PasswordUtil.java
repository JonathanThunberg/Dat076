
package se.chalmers.dat076.mathem.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Responsibility: Hashes the passwords to MD5 to ensure some security
 * Used by: CustomerRegistryCtrl, LoginCtrl, MyPageCtrl
 */
public class PasswordUtil {
    public static String PasswordToHash(String password)
    {
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        }
        return generatedPassword;
    }
}
