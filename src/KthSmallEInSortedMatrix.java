import java.util.*;

//378
public class KthSmallEInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 ||k <=0){
            return 0;
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                l.add(matrix[i][j]);
            }
        }
        int[] oneDArray = new int[l.size()];
        int i = 0;
        for(Integer e: l){
            oneDArray[i++] = e;
        }
        Arrays.sort(oneDArray);
        return oneDArray[k - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int rst = kthSmallest(matrix, k);
        System.out.println(rst);
    }
}
