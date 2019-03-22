import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int l = 0, r = matrix[0].length-1, u = 0, d = matrix.length-1;
        while(l <=r &&u <=d){
            int i = l;
            for(; i<=r; i++) list.add(matrix[u][i]);
            int j = u + 1;
            for(; j<=d; j++) list.add(matrix[j][r]);
            if( l <r &&u <d){
                for(int m = r - 1; m>l; m--) list.add(matrix[d][m]);
                for(int m = d; m>u; m--) list.add(matrix[m][l]);
            }
            l++;
            r--;
            u++;
            d--;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] m = {
                { 3 },
                { 2}
        };
//        int[][] m = {
//                { 1, 2, 3 }
//        };
        System.out.print(s.spiralOrder(m));

    }
}
