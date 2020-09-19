package hackzurich.proj.util;

import net.bytebuddy.utility.RandomString;

public class GenIdUtil {
    public static String genId(int length){
        return RandomString.make(length);
    }
}