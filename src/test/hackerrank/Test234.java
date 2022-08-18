package hackerrank;

import java.util.*;

public class Test234 {
    public static void main(String[] args) {
        countLettersInString("The quick brown fox jumps over the lazy dog");
    }

    public static String countLettersInString(String inputText) {
        Map<String, Integer> map = new HashMap<>();

        int max =0;
        for (int i=0 ; i < inputText.length(); i++){
            String letter = String.valueOf(inputText.charAt(i)).toLowerCase();
            if (letter != " ") {
                if (map.get(letter) == null) {
                    map.put(letter, 1);
                } else {
                    map.put(letter, map.get(letter) + 1);

                    if ( map.get(letter) > max)
                        max = map.get(letter);
                }
            }
        }

        Map<Integer, String> results = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            results.put(entry.getValue(), entry.getKey());
        }
        return "";

    }
}
