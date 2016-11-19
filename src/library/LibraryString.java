package library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryString {
        
    public static String md5(String input) {
        String result = input;
        MessageDigest md = null; 
        if(input != null) {
            try {
                md = MessageDigest.getInstance("MD5"); //or "SHA-1"
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LibraryString.class.getName()).log(Level.SEVERE, null, ex);
            }
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }
    
    public static boolean isPassword(String password){
        String regex = "^[a-zA-Z]([a-zA-Z0-9!@#$%^&]{5,29})";
        return password.matches(regex);
    }
	
    public boolean checkValidateVietnamese(String str){
        boolean result = true;
//        Pattern p = Pattern.compile("!@#$%^&*()?|':,.<>?}{|][~`-=_+123456789");
        Pattern p = Pattern.compile("[^A-Za-z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ']");
        Matcher m = p.matcher(str);
        boolean b = m.find();
        if(b == false){
            result = false;
        }
        return result;
    }
}
