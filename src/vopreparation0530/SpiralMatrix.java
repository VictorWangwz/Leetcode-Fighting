package vopreparation0530;


import java.util.ArrayList;
import java.util.List;

//54. Spiral Matrix
public class SpiralMatrix {

    public static void layerByLayerOrder(List<Integer> l, int[][] matrix, int layer){
        if(matrix[0].length - layer - 1  < 0
                ||matrix.length - layer - 1 < 0
                || layer > matrix[0].length - layer - 1
                || layer > matrix.length - layer - 1 )
            return;
        for(int j = layer; j <= matrix[0].length -  layer - 1; j++ )
            l.add(matrix[layer][j]);
        for(int i = layer + 1; i <= matrix.length - layer - 1; i ++)
            l.add(matrix[i][matrix[0].length - layer - 1]);
        if(layer < matrix.length - 1 - layer){
            for(int j = matrix[0].length -  layer - 2; j >= layer; j--)
                l.add(matrix[matrix.length - layer - 1][j]);
        }
        if(layer < matrix[0].length - 1 - layer){
            for(int i = matrix.length - layer - 2; i > layer; i--)
                l.add(matrix[i][layer]);
        }

        return;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return rst;
        for(int i = 0; i < matrix.length/2 + 1; i++){
            layerByLayerOrder(rst, matrix, i);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 5, 8 },
                { 4, 0, -1 },

        };
        List<Integer> rst = spiralOrder(matrix);
        int[] expected = new int[]{1,2,3,6,9,8,7,4,5};
        System.out.println(rst);

    }
}
