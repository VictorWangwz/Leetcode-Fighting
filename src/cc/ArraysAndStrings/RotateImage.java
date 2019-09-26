package cc.ArraysAndStrings;//48. Rotate Image

public class RotateImage {

    public static void rotateOneLayer(int[][] matrix, int l){
        int n = matrix.length;
        int bound = n - l * 2 - 2;
        for( int i  = 0; i <= bound; i ++){
            int temp = matrix[n - 1 - l - i][l ];
            matrix[n - 1 - l - i][l] = matrix[n - 1 - l][n - 1 - l - i];
            matrix[n - 1 - l][n - 1 -l - i] = matrix[l + i][n - 1 - l];
            matrix[i + l][n - 1 - l] = matrix[l][i + l];
            matrix[l][i + l] = temp;
        }
        return;

    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        for(int i = 0; i < (n+1)/2; i++){
            rotateOneLayer(matrix, i);
        }
        return;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        System.out.println(matrix);
    }
}
