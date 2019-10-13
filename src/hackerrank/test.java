package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        String message = "{ \"orgId\":\"00D7F000003CcNwUAK\", \"projectId\":\"5630be58204b89c90b2034f0\", \"key\":\"IFz2ppnQ3QXEPmzYfWZGYV8lswysCfWqCML6v6XSi5w\", \"pass\":\"ujGPiMkTFJM3yDU+wIMbfIOG8x944uhi829cOoOI6EuJInYophuczble/HriUdT5uyL7LyzZMhiuNSkkDBeA7bQJyDu4YPJZ0PwF5TxhcOI=\", \"url\":\"https://propertyreports.mesh-staging.com\", \"fromDateTime\":\"2019-02-07 04:05:09 \", \"toDateTime\":\"2019-03-07 21:12:57 \" }";

        String word="abaaaba";
        int count =0;
        int index =0;
        char current =0;
        for (char c :word.toCharArray()) {
            if (index == 0) {
                current = c;
                count++;
            }

            if (current != c){
                current = c;
                count=0;
            }
            else if (index >0 && current == c) {
                count++;
            }
            if (count >1)
                break;
            index++;
        }
        if (count>0)
            System.out.println(1);
        else
            System.out.println(0);
        /*
        String a = "fcrxzwscanmligyxyvym";
        String b= "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        Set<CharSequence> set = new HashSet<>();
        int count =0;
        for (int i=0; i< a.length();i++){
            CharSequence charSequence = a.subSequence(i,i+1);
            if(b.contains(charSequence) && !set.contains(charSequence))
                count ++;

            set.add(charSequence);

        }
        System.out.println(a.length()+b.length() - count*2);*/
    }
}
