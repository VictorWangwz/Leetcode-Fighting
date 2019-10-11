package cc.ArraysAndStrings;

import java.util.Arrays;

//1099. Two Sum Less Than K
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int rst = -1;
        while(l < r){
            if(A[l] + A[r] < K ){
                rst = Math.max(A[l] + A[r], rst);
                l++;
            }
            if(A[l] + A[r] >= K){
                r--;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] A = {803,468,292,154,924,424,197,277,753,86,984,144,105,450,287,265,655,404,407,794,513,976,241,272,84,503,65,654,805,413,362,907,297,473,113,567,646,607,806,674,424,753,870,574,765,170,603,696,513,58};
        int K = 300;
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int rst = twoSumLessThanK.twoSumLessThanK(A, K);
        System.out.println(rst);
    }
}
