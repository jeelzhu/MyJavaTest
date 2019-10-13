package codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Bracket b = new Bracket();
        String s ="{[()()]}";
        String[] values = new String[1];
        values[0]= s;
        String[] results = braces(values);
        for (int i=0; i< values.length; i++){
            System.out.println(results[i]);
        }
    }

    public int solution(String S) {
        int length = S.length();
        if (length%2 != 0) return 0;
        Stack stack = new Stack();
        for (int i=0 ;i<length;i++){
            char newChar = S.charAt(i);
            if (newChar == '{' || newChar == '('  || newChar == '[' )
                stack.push(newChar);
            else{
                if (stack.empty())
                    return 0;
                else{
                    char currentChar = (char)stack.pop();
                    if ( ( (newChar =='}' && currentChar =='{')
                            ||  (newChar ==')' && currentChar =='(')
                            || ( newChar ==']' && currentChar =='[')) ){
                        continue;
                    }
                    return 0;
                }
            }
        }
        if (stack.empty())
            return 1;
        return 0;
    }

    static String[] braces(String[] values) {
        List<String> list = new ArrayList<>();
        for (int i=0; i< values.length; i++){
            list.add(toResult(values[i]));
        }
        String[] results = new String[list.size()];
        for (int i=0; i< list.size(); i++){
            results[i]=list.get(i);
        }

        return results;


    }
    static String toResult(String S) {
        int length = S.length();
        if (length%2 != 0) return "NO";
        Stack stack = new Stack();
        for (int i=0 ;i<length;i++){
            char newChar = S.charAt(i);
            if (newChar == '{' || newChar == '('  || newChar == '[' )
                stack.push(newChar);
            else{
                if (stack.empty())
                    return "NO";
                else{
                    char currentChar = (char)stack.pop();
                    if ( ( (newChar =='}' && currentChar =='{')
                            ||  (newChar ==')' && currentChar =='(')
                            || ( newChar ==']' && currentChar =='[')) ){
                        continue;
                    }
                    return "NO";
                }
            }
        }
        if (stack.empty())
            return "YES";
        return "NO";
    }
}
