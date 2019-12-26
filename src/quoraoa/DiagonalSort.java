package quoraoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiagonalSort {

    public void helper(int[][] matrix, int[] cur, int[] dir){
        while(cur[0] < matrix.length && cur[1] < matrix[0].length){
            List<Integer> tmp = new ArrayList<>();
            int[] tmpCur = cur.clone();
            while(tmpCur[0] < matrix.length && tmpCur[1] < matrix[0].length){
                tmp.add(matrix[tmpCur[0]][tmpCur[1]]);
                tmpCur[0]++;
                tmpCur[1]++;
            }
            tmp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            tmpCur = cur.clone();
            int i = 0;
            while(tmpCur[0] < matrix.length && tmpCur[1] < matrix[0].length){
                matrix[tmpCur[0]][tmpCur[1]] = tmp.get(i++);
                tmpCur[0]++;
                tmpCur[1]++;
            }
            cur[0] += dir[0];
            cur[1] += dir[1];
        }
    }
    public int[][] diagonalSort(int[][] matrix){
        int[] start = {0,0};

        int[] dir1 = {0,1};
        int[] dir2 = {1,0};
        int[] cur1 = start, cur2 = start;
        helper(matrix, cur1, dir1);
        helper(matrix, cur2, dir2);
        return matrix;


    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {8,4,1},
//                {4,4,1},
//                {4,8,9}
//        };
        int[][] matrix ={
                {2,2,3,5,5},
                {6,8,8,9,20},
                {11,22,14,14,35},
                {18,17,28,11,20},
                {22,22,43,26,25}
        };
        DiagonalSort diagonalSort = new DiagonalSort();
        int[][] rst = diagonalSort.diagonalSort(matrix);
        System.out.println(rst);
    }
}
