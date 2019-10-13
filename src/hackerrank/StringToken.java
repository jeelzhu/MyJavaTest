package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class StringToken {
    public static void main(String[] args) {
        String s="He is a very very good boy, isn't he?";
        String[] tokens = s.split("([.,!?:;'\"-]|\\s)+", -1);

        System.out.println(tokens.length);
        for (String token: tokens)
            System.out.println(token);
    }
}
