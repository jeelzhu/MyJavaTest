package leetCode;

public class RemoveVowelsFromAString {
    public String removeVowels(String S) {

        String v ="oeiuaAEIUO";

        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray())
        {
            if(v.indexOf(c)==-1)
                sb.append(c);
        }

        return sb.toString();
        /*
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0 ; i < S.length(); i++){
            if (S.charAt(i) != 'a'
                    && S.charAt(i) != 'A'
                    && S.charAt(i) != 'e'
                    && S.charAt(i) != 'E'
                    && S.charAt(i) != 'i'
                    && S.charAt(i) != 'I'
                    && S.charAt(i) != 'o'
                    && S.charAt(i) != 'O'
                    && S.charAt(i) != 'u'
                    && S.charAt(i) != 'U'
            ){
                stringBuilder.append(S.charAt(i));
            }
        }

        return stringBuilder.toString();*/
    }

    public static void main(String[] args) {
        //new RemoveVowelsFromAString().removeVowels("leetcodeisacommunityforcoders");

        System.out.println((int)'a');
        System.out.println((int)'A');
    }

}
