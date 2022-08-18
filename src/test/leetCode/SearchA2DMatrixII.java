package leetCode;


class Solution {
    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }
}

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix != null  ) {


            int x = matrix.length-1;
            int y = 0;
            int value;

            while(x >=0  && y < matrix[0].length ){
                value = matrix[x][y];
                if (value< target)
                    y++;
                else if (value > target) {
                    x--;
                } else {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        /*
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;
        matrix[1][0] = 2;
        matrix[1][1] = 5;
        matrix[1][2] = 8;
        matrix[2][0] = 3;
        matrix[2][1] = 6;
        matrix[2][2] = 9;*/

        int[][] test ={};

        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};



        System.out.println(new SearchA2DMatrixII().searchMatrix(matrix, 15));
    }
}
