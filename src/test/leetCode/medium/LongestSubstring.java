package leetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int longest =0 , i =0, j=0, length = s.length();
        Set<Character> set = new HashSet<>();

        while(i < length && j < length ){
            if (!set.contains(s.charAt(j))){
                longest = Math.max(longest, j-i);
                set.add(s.charAt(j));
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;

            }
        }

        return longest;


    }
    /*

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int longest = 0;
        for (int i=0; i< length; i++){
            for (int j=i+1; j<length+1; j++){
                if (isSubStringWithoutRepeatingCharacters(s, i, j) )
                    longest = Math.max(longest, j - i);
            }
        }

        return longest;

    }

    private boolean isSubStringWithoutRepeatingCharacters(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i=start; i< end ; i++){
            Character c = s.charAt(i);
            if (set.contains(c))
                return false;
            set.add(c);
        }
        return true;
    }*/

    public static void main(String[] args) {
        String t="abcd";
        String p = t.substring(0,1);

        System.out.println(new LongestSubstring().lengthOfLongestSubstring(" "));

    }
}
