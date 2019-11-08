package leetCode;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] numbers = new int[26];
        for (int i=0; i< s.length(); i++){
            numbers[s.charAt(i) -'a'] ++;

        }
        for (int i=0; i< s.length(); i++){
            if (numbers[s.charAt(i) -'a'] == 1)
                return i;

        }
        return -1;
    }
}
