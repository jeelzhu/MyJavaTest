package codility;

import java.util.*;

class Solution {

    public static int solution4(String S) {
        CallCharger charger = new CallCharger();
        String[] lines = S.split(System.getProperty("line.separator"));
        for (int i=0 ; i< lines.length; i++){
            String time = lines[i].substring(0, 8);
            String phoneNumber = lines[i].substring(9, 20);
            charger.addCall(new Call(time, phoneNumber));
            System.out.println();
        }

        return 1;
    }

    /*

        A[P] + A[Q] > A[R],
                A[Q] + A[R] > A[P],
                A[R] + A[P] > A[Q].
     */
    public static int solution2(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int i=0; i< length-2 ;i++){
            if(A[i]+A[i+1]>A[i+2]){
                return 1;
            }
        }
        return 0;

    }



    public static int solution(String S) {
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





    public static void main(String[] args) {
        int[] A = new int[4];

        A[0] = 3 ;
        A[1] = 8;
        A[2] = 10;
        A[3] = 12;

        String S = "{[]}";

        System.out.println(solution(S));


    }

}
class CallCharger {
    private SortedSet<Call> calls = new TreeSet<>();

    public int calculateCharge(){
        return 0;
    }

    public void addCall(Call call) {
        calls.add(call);
    }
}

class Call implements Comparable<Call> {

    private int hours;
    private int mins;
    private int seconds;
    private String phoneNumber;

    public Call(String time, String phoneNumber){
        String hoursStr = time.substring(0,2);
        String minsStr = time.substring(3,5);
        String secondsStr = time.substring(6,8);
        hours = Integer.parseInt(hoursStr);
        mins = Integer.parseInt(minsStr);
        seconds = Integer.parseInt(secondsStr);
        this.phoneNumber = phoneNumber;
    }

    public int getTotalSeconds() {
        int totalSeconds = 0;
        if (hours > 0) {
            totalSeconds += 3600 * hours;
        }
        if (mins > 0) {
            totalSeconds += 60 * mins;
        }
        if (seconds > 0){
            totalSeconds += seconds;
        }
        return totalSeconds;
    }

    public int getTotalMins(){
        int totalMins =0;
        if (hours >0){
            totalMins += 60*hours;
        }
        if (mins >0){
            totalMins += mins;
        }
        return totalMins;
    }

    public int calculateCharge(){
        if (getTotalMins() >= 5){
            if (seconds ==0)
                return 150 * getTotalMins();
            else
                return 150 * (getTotalMins()+1);
        }
        else {
            return 3 * getTotalSeconds();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Call o) {
        int result = this.getTotalSeconds() - o.getTotalSeconds();
        if (result ==0)
            return  this.getPhoneNumber().compareTo(o.getPhoneNumber());
        else
            return result;
    }
}

