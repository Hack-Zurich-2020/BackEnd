package hackzurich.proj.util;

import hackzurich.proj.model.Constants;

import java.util.*;

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

    public static Map<String, Integer> strToStrKeyMap(String data){
        Map<String, Integer> map = new HashMap<>();
        for (String each : data.split(Constants.COMMA)) {
            map.put(each.split(Constants.COLON)[0], Integer.parseInt(each.split(Constants.COLON)[1]));
        }
        return map;
    }

    public static Map<Integer, Integer> strToIntKeyMap(String data){
        Map<Integer, Integer> map = new HashMap<>();
        for (String each : data.split(Constants.COMMA)) {
            map.put(Integer.parseInt(each.split(Constants.COLON)[0]), Integer.parseInt(each.split(Constants.COLON)[1]));
        }
        return map;
    }

    public static List<Integer> strToIntList(String data){
        List<Integer> returnedCategoryIds = new ArrayList<>();
        Arrays.asList(data.split(Constants.COMMA)).forEach(strId -> returnedCategoryIds.add(Integer.parseInt(strId)));
        return returnedCategoryIds;
    }
}
