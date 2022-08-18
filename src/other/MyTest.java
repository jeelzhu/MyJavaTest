package other;

import java.io.IOException;
import java.util.Optional;

public class MyTest {

    public static double average(int a, int b) {
        return (double)((a + b) / 2);
    }

    public static void main(String[] args) {
        test1();

    }
    public static String test1(){
        try {
            System.out.println("gggg");
            if (false)
                throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("sdfasfsadf");
            return "sdfsaf";
        }
    }

    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text="dfas";

        System.out.println("Using orElseGet:");
        String defaultText =
                Optional.ofNullable(text).orElseGet(this::getMyDefault);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    }


    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

}
