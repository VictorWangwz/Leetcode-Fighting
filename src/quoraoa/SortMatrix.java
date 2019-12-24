package quoraoa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortMatrix
{

    public void sortMatrix(int[][] matrix){
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                pq.offer(matrix[i][j]);
            }
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = pq.poll().intValue();
            }
        }
        return;


    }

    public static void main(String[] args) {
        int[][] matrix = {
            {41, 45, 20, 21},
            {1 ,2, 3, 4},
            {30, 42, 43, 29 },
            {16, 17, 19, 10}
        };

        SortMatrix sortMatrix = new SortMatrix();
        sortMatrix.sortMatrix(matrix);
    }
}
