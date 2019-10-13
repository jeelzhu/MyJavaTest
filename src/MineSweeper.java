public class MineSweeper {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        mineSweeper(bombs1, 3, 3);// should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        mineSweeper(bombs2, 3, 4); //should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        mineSweeper(bombs3, 5, 5);// should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        System.out.println();
        int[][] field = new int[numRows][numCols];
        System.out.println(bombs.length);
        System.out.println(bombs[0].length);
        //System.out.println(field[1].length);

        for (int i=0; i< bombs.length; i++){
            int bombRow = bombs[i][0];
            int bombCol = bombs[i][1];
            System.out.println(bombRow+" "+bombCol);
            field[bombRow][bombCol] = -1;

        }

        /*
        System.out.println();
        for (int i=0; i< numRows; i++){
            for (int j=0; j< numCols; j++)
                System.out.print(field[i][j]+", ");

            System.out.println();
        }*/

        for (int i=0; i< numRows; i++) {
            for (int j = 0; j < numCols; j++){
                if (field[i][j]==-1){
                    continue;
                }
                else {
                    field[i][j]= countNearbyMine(i,j,field);
                }
            }
        }
        System.out.println();
        for (int i=0; i< numRows; i++){
            for (int j=0; j< numCols; j++)
                System.out.print(field[i][j]+", ");

            System.out.println();
        }

        return field;
    }

    private static int countNearbyMine(int row, int column, int[][] field){
        int count =0;
        if (row-1 >=0 && column -1 >=0){
            if (field[row-1][column-1] == -1)
                count++;
        }
        if (row-1 >=0 ){
            if (field[row-1][column] == -1)
                count++;
        }
        if (column -1 >=0){
            if (field[row][column-1] == -1)
                count++;
        }
        if (row+1 < field.length && column +1 < field[0].length){
            if (field[row+1][column+1] == -1)
                count++;
        }

        if (row+1 < field.length ){
            if (field[row+1][column] == -1)
                count++;
        }

        if (column +1 < field[0].length){
            if (field[row][column+1] == -1)
                count++;
        }

        if (row-1 >=0 && column +1 < field[0].length){
            if (field[row-1][column+1] == -1)
                count++;
        }

        if (row+1 < field.length && column -1 >=0){
            if (field[row+1][column-1] == -1)
                count++;
        }

        return count;


    }
}
