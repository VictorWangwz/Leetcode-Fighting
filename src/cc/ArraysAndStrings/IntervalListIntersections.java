package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//986. Interval List Intersections
public class IntervalListIntersections {

    //brute force
    public int[][] intervalIntersection0(int[][] A, int[][] B) {
        List<List<Integer>> list = new ArrayList<>();
        for(int[] pairA: A){
            for(int[] pairB: B){
                if(pairB[0] <= pairA[1] && pairB[1] >=pairA[0] ){
                    int left = Math.max(pairB[0], pairA[0]);
                    int right = Math.min(pairB[1], pairA[1]);
                    list.add(Arrays.asList(left, right));

                }
            }
        }
        int[][] rst = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            rst[i][0] = list.get(i).get(0);
            rst[i][1] = list.get(i).get(1);
        }
        return rst;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<List<Integer>> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            int[] pairA = A[i], pairB = B[j];
            if(pairB[0] <= pairA[1] && pairB[1] >=pairA[0] ){
                int left = Math.max(pairB[0], pairA[0]);
                int right = Math.min(pairB[1], pairA[1]);
                list.add(Arrays.asList(left, right));

            }
            if(pairA[1] < pairB[1]){
                i++;
            }
            else{
                j++;
            }
        }

        int[][] rst = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++){
            rst[k][0] = list.get(k).get(0);
            rst[k][1] = list.get(k).get(1);
        }
        return rst;
    }
}
