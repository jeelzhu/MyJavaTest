package ikm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class IkmTest {
    public void writeFile() {

        Path inputFile = Paths.get("input.txt");
        Path outputFile = Paths.get("output.txt");
        /*
        BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
        BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset());
        String lineFromFile = "";
        while ((lineFromFile = reader.readLine()) != null)
            writer.append(lineFromFile);
*/
        try (BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
             BufferedWriter writer = Files.newBufferedWriter(outputFile,    Charset.defaultCharset());) {
            String lineFromFile = "";
            while ((lineFromFile = reader.readLine()) != null)
                writer.append(lineFromFile);
        } catch (IOException e) {}
    }


    public IkmTest() {
        this(10);
    }
    public IkmTest(int data) {
        this.data = data;
    }
    public void display() {
        class Decrementer {
            public void decrement () {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }

    private int data;

    public static void main (String [] args) {


/*
        SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + " " + s.size());*/

        //System.out.println(isLeapYear(2021));
        Stream.of("little", "red", "riding", "hood")
                .parallel()
                .map(s -> {System.out.println("map: " + s + " " + Thread.currentThread().getName()); return s + "_";})
                .filter(s -> {System.out.println("filter: " + s + " " + Thread.currentThread().getName()); return s.length()>3;})
                .reduce( (s1, s2) -> {
                    System.out.println("reducer: " + s1 + " " + Thread.currentThread().getName());
                    return s1.length() > s2.length()? s1:s2;
                });
    }
/*
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 1, 1);
        int days = cal.getMaximum(Calendar.DAY_OF_MONTH);
        return (days == 29);
    }

    public static boolean isLeapYear(int year) {
        LocalDate date = LocalDate.of(year);
        return date.isLeapYear();
    }*/

    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return (days > 365);
    }


}

class Element implements Comparable {
    int id;

    Element(int id) {
        this.id = id;
    }

    public int compareTo(Object obj) {
        Element e = (Element)obj;
        return  this.id - e.id;
    }

    public String toString() {
        return "" + this.id;
    }
}
