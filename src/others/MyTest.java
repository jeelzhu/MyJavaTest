package others;

import java.util.*;
import java.util.stream.Stream;

class Position{
    int row;
    int col;
    Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}


/*
 * A-Z: 65-90
a-z: 97-122
Space: 32
 */
// public static void main(String[] args) {
//     String encoded = "23511011501782351112179911801562340161171141148";
//     System.out.println(decode(encoded));  // This should print "Truth Always Wins"
// }


public class MyTest {
        
        public static String toStr(int number){
            if (number>=65 && number<=90){
                char a ='a';
                char b = (char)(a+number-65);
                return ""+b;

            } else if (number >=97 && number <=122){
                char a ='A';
                char b = (char)(a+number-65);
                return ""+b;
            } else if (number == 32){
                return " ";
            }
            return "";
        }
        public static String decode(String str) {
            StringBuilder builder = new StringBuilder();
            int size = str.length();
            int index =0;

            while (index < size){
                Integer number = Integer.parseInt(str.substring(index, index+2));
                if (number>=65 && number <=90 || number >=97 && number<=122 || number ==32){
                    builder.append(toStr(number));
                    index +=2;

                } else {
                    number = Integer.parseInt(str.substring(index, index+3));
                    if (number>=65 && number <=90 || number >=97 && number<=122 || number ==32){
                    builder.append(toStr(number));

                        index +=3;

                    }
                }


                

            }

            return builder.toString();

        }



    public static int getNumberOfUniqueCharacters(List<String> words) {
        return (int)words.stream().flatMapToInt(String::chars)
                                            .mapToObj(c -> (char) c).distinct().count();
                         

    }


    public static void main(String[] args) {
        String encoded = "23511011501782351112179911801562340161171141148";
        System.out.println(decode(encoded));  // This should print "Truth Always Wins"


        // int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        // new MyTest().eraseOverlapIntervals(intervals);
        // int[] temperatures = {73,74,75,71,69,72,76,73};
        // new MyTest().dailyTemperatures(temperatures);
    }

    


    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{ 
            if (a[0]==b[0]){
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        });

        int count =0;
        for (int i=0; i<intervals.length-1;i++){
            if (intervals[i][1]>intervals[i+1][0]){
                count++;
            }
        }
        System.out.println(count-1);

        return count-1;
        
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }

    

    public int uniquePaths(int m, int n) {
        // Create a 2D DP table with dimensions m x n
        int[][] dp = new int[m][n];
        
        // Initialize the top row and the left column to 1
        // as there is only one way to reach any cell in the top row or left column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill in the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of ways to reach a cell is the sum of the number of ways
                // to reach the cell above it and the number of ways to reach the cell to its left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // The bottom-right cell contains the number of unique paths from the top-left to the bottom-right
        return dp[m-1][n-1];
    }

    public int uniquePaths33(int m, int n) {
        if (m == n && m==1)
            return 1;
        int count = 0;
        int row =0, col =0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(row, col));
        while(!queue.isEmpty()){
            Position pos = queue.poll();
            if (pos.col == n-1 && pos.row == m-1){
                count++;
            }

            if (pos.col+1 <= n-1){
                queue.add(new Position(pos.row, pos.col+1));
            }
            if (pos.row+1 <= m-1){
                queue.add(new Position(pos.row+1, pos.col));
            }
        }

        return count;


    }

    public void move(int m, int n, int row, int col, Integer count){
        if (row == m-1 && col == n-1){
            count=count++;
            return;
        }
        if (col+1 <=n)
            move(m,n,row,col+1, count);
        if (row+1<= m)
            move(m,n,row+1,col, count);

    }

    
}