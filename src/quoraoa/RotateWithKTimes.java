package quoraoa;

public class RotateWithKTimes {

    private void rotateOneLayer90Degree(int[][] matrix, int layer){
        for(int i = layer + 1; i <= matrix.length - 1 - layer - 1; i++){
            int tmp = matrix[layer][i];
            matrix[layer][i] = matrix[matrix.length - 1 - i][layer];
            matrix[matrix.length - 1 - i][layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - i];
            matrix[matrix.length - 1 - layer][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - layer];
            matrix[i][matrix.length - 1 - layer] = tmp;
        }
        return;
    }

    private void rotateOneLayer180Degree(int[][] matrix, int layer){
        for(int i = layer + 1; i <= matrix.length - 1 - layer - 1; i++){
            int tmp = matrix[layer][i];
            matrix[layer][i] = matrix[matrix.length - 1 - layer][matrix.length - 1 - i];
            matrix[matrix.length - 1 - layer][matrix.length - 1 - i] = tmp;

            tmp = matrix[matrix.length - 1 - i][layer];
            matrix[matrix.length - 1 - i][layer] = matrix[i][matrix.length - 1 - layer];
            matrix[i][matrix.length - 1 - layer] = tmp;
        }
        return;
    }

    private void rotateOneLayer270Degree(int[][] matrix, int layer){
        for(int i = layer + 1; i <= matrix.length - 1 - layer - 1; i++){
            int tmp = matrix[layer][i];
            matrix[layer][i] = matrix[i][matrix.length - 1 - layer];
            matrix[i][matrix.length - 1 - layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - i];
            matrix[matrix.length - 1 - layer][matrix.length - 1 - i] =  matrix[matrix.length - 1 - i][layer];
            matrix[matrix.length - 1 - i][layer] = tmp;
        }
        return;
    }

    public void rotate(int[][] matrix, int k){
        switch (k % 4){
            case 1:
            {
                for(int i = 0; i < (matrix.length - 1) / 2; i++){
                    rotateOneLayer90Degree(matrix, i);
                }
                return;
            }
            case 2:
            {
                for(int i = 0; i < (matrix.length - 1) / 2; i++){
                    rotateOneLayer180Degree(matrix, i);
                }
                return;

            }
            case 3:
            {
                for(int i = 0; i < (matrix.length - 1) / 2; i++){
                    rotateOneLayer270Degree(matrix, i);
                }
                return;

            }
            default:{
                return;
            }
        }

    }

    public static void main(String[] args) {
        RotateWithKTimes rotateWithKTimes = new RotateWithKTimes();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int k = 3;
        rotateWithKTimes.rotate(matrix, k);
    }
}
