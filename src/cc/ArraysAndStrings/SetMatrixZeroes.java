package cc.ArraysAndStrings;//73. Set Matrix Zeroes

import java.util.*;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return;
        }

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for( int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Iterator iterRow = rows.iterator();
        while(iterRow.hasNext())
        {
            int row = (int)iterRow.next();
            for( int i = 0; i < matrix[0].length; i++){
                matrix[row][i] = 0;
            }
        }
        Iterator iterCol = cols.iterator();
        while(iterCol.hasNext()){
            int col = (int) iterCol.next();
            for( int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
        return;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {0,1,2}
        };
        setZeroes(matrix);
    }
}
