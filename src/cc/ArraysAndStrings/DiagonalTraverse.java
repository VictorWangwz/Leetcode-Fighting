package cc.ArraysAndStrings;
//498. Diagonal Traverse
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int[][] dirArr = {
                {-1,1},
                {1,-1}
        };
        int dirIdx = 0;
        int i = 0, j = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] rst = new int[m*n];
        int k = 0;
        while(k < m * n ){
            rst[k++] = matrix[i][j];
            int[] dir = dirArr[dirIdx];
            if(i + dir[0] < 0 && j + dir[1] >= n){
                i++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            if(i + dir[0] >= m && j + dir[1] < 0){
                j++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            if(i + dir[0] < 0){
                j++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            if(j + dir[1] < 0){
                i++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            if(j + dir[1] >= n){
                i++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            if(i + dir[0] >= m){
                j++;
                dirIdx = dirIdx == 0?1:0;
                continue;
            }
            i += dir[0];
            j += dir[1];

        }
        return rst;
    }

    public static void main(String[] args) {
        int[][]  matrix = {
                { 1, 2, 3 }
        };
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[] rst = diagonalTraverse.findDiagonalOrder(matrix);
        System.out.println(rst);
    }
}
