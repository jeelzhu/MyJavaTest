package other.mosh;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {

        String str ="<>{}()";
        System.out.println(isBalanced(str));

    }

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for (Character c: input.toCharArray()){
            if (c == '(' || c=='[' || c=='<' || c=='{'){
                stack.push(c);
            }
            else if (c == ')' || c ==']' || c =='>' || c=='}' ){
                if (stack.empty()) return false;

                Character top = stack.pop();
                if ( (c =='(' && top !=')' ) ||
                        (c =='[' && top !=']' ) ||
                        (c =='<' && top !='>' ) ||
                        (c =='{' && top !='}' )
                ) return false;
            }
        }
        return stack.empty();
    }
}
