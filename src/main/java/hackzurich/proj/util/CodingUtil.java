package hackzurich.proj.util;

import hackzurich.proj.model.Constants;

import java.util.Map;

public class CodingUtil {
    public static String strMapToStr(Map<String, Integer> map){
        StringBuilder str = new StringBuilder();
        map.forEach((k,v) -> str.append(k).append(Constants.COLON).append(v).
                append(Constants.COMMA));
        return str.substring(0, str.length() - 1);
    }

    public static String intMapToStr(Map<Integer, Integer> map){
        StringBuilder str = new StringBuilder();
        map.forEach((k,v) -> str.append(k).append(Constants.COLON).append(v).
                append(Constants.COMMA));
        return str.substring(0, str.length() - 1);
    }
}
