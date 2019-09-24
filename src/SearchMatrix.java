//74. Search a 2D Matrix
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n -1 ]){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{
            1, 3
        }};
        int target = 3;
        boolean expected = true;
        boolean rst = searchMatrix(matrix, target);
        System.out.println(rst ==  expected);
    }
}
