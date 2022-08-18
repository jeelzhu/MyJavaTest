package other;

public class OA {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 != length2 && (length1 != length2 +1|| length2 != length1+1))
            return false;


        boolean oneAway = false;

        if (length1 < length2){
            int j=0;
            for (int i=0 ; i< length1;i++){
                if (s1.charAt(i)!=s2.charAt(j)&!oneAway){
                    j++;
                    oneAway = true;
                }
                if (s1.charAt(i)!= s2.charAt(j)&&oneAway){
                    return false;
                }
                j++;

            }

        }
        else {
            int j=0;
            for (int i=0 ; i< length2;i++){
                if (s2.charAt(i)!=s1.charAt(j)&!oneAway){
                    j++;
                    oneAway = true;
                }
                if (s2.charAt(i)!= s1.charAt(j)&&oneAway){
                    return false;
                }
                j++;

            }

        }
        return true;

    }
}
