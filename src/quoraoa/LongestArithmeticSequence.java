package quoraoa;

import java.util.ArrayList;
import java.util.List;

//1027. Longest Arithmetic Sequence
public class LongestArithmeticSequence {
    //time limit exceeded
    public int longestArithSeqLength0(int[] A) {
        int rst = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int diff = A[j] - A[i];
                int start = A[j];
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                for(int k = j + 1; k < A.length; k++){
                    if(A[k] == start + diff){
                        start = A[k];
                        list.add(k);
                    }
                }
                int count = list.size();
                rst = count > rst ? count : rst;
            }
        }
        return rst;

    }


    public int longestArithSeqLength(int[] A) {
        int rst = Integer.MIN_VALUE;
        int[][] mem = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(mem[i][j] == 0){
                    int diff = A[j] - A[i];
                    int start = i, end = j;
                    mem[i][j] = 2;
                    for(int k = j + 1; k < A.length; k++){
                        if(A[k] == A[end] + diff){
                            mem[end][k] = mem[start][end] + 1;
                            start = end;
                            end = k;
                        }
                    }
                    int count = mem[start][end];
                    rst = count > rst ? count : rst;
                }

            }
        }
        return rst;

    }



}
