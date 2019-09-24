//240. Search a 2D Matrix II

public class SearchMatrix2 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix .length == 0 || matrix[0].length == 0
                || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
            return  false;
        }
        int m  = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bot = m - 1;
        for(int i = 0 ; i < n; i++){
            if( matrix [0][i] == target) return true;
            if(matrix[0][i] > target && i - 1 >= 0 ){
                right = i - 1;
                break;
            }


        }
        for(int i = 0 ; i < n; i++) {
            if (matrix[m - 1][n - 1 - i] == target) return true;
            if (matrix[m - 1][n - 1 - i] < target) {
                left = n - 1 - i;
                break;
            }
        }
        for( int j = 0; j < m ; j++){
            if( matrix[j][0] == target)
                return true;
            if( matrix[j][0] > target){
                bot = j - 1;
                break;
            }

        }
        for( int j = 0; j < m ; j++) {
            if (matrix[m - 1 - j][n - 1] == target) return true;
            if (matrix[m - 1 - j][n - 1] < target) {
                top = m - 1 - j;
                break;
            }
        }


        for(int i = top; i <= bot; i++){
            for( int j = left; j <= right; j++){
                if(matrix[i][j] ==  target){
                    return true;
                }
            }


        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target  = 19;
        boolean rst = searchMatrix(matrix, target);
        System.out.println(rst);
    }
}
