


import java.util.ArrayDeque;

public class MS2 {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, -1, 1, 0}};

         click(field1, 3, 5, 2, 2) ;//should return:
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        click(field1, 3, 5, 1, 4);// should return:
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]
        System.out.println();
        for (int i=0; i< 3; i++){
            for (int j=0; j< 5; j++)
                System.out.print(field1[i][j]+", ");

            System.out.println();
        }


        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

        click(field2, 4, 4, 0, 1) ;//should return:
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        System.out.println();
        for (int i=0; i< 4; i++){
            for (int j=0; j< 4; j++)
                System.out.print(field2[i][j]+", ");

            System.out.println();
        }

        click(field2, 4, 4, 1, 3) ;//should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
        System.out.println();
        for (int i=0; i< 4; i++){
            for (int j=0; j< 4; j++)
                System.out.print(field2[i][j]+", ");

            System.out.println();
        }
    }

    // Implement your solution below.
    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        if (givenI >=0 && givenJ >=0 && givenI < numRows && givenJ < numCols && field[givenI][givenJ] == 0) {
            field[givenI][givenJ] = -2;
            click(field, numRows, numCols, givenI-1, givenJ-1);
            click(field, numRows, numCols, givenI, givenJ-1);
            click(field, numRows, numCols, givenI-1, givenJ);
            click(field, numRows, numCols, givenI-1, givenJ+1);
            click(field, numRows, numCols, givenI, givenJ+1);
            click(field, numRows, numCols, givenI+1, givenJ+1);
            click(field, numRows, numCols, givenI+1, givenJ);
            click(field, numRows, numCols, givenI+1, givenJ-1);
        }
        return field;
    }


}
