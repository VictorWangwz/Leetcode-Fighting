package oa2preparation0519;


public class TwoSumClosest {
    // Brute Force
    public static int[] closesTwoSum(int ar1[], int ar2[], int x){
        int dist = Integer.MAX_VALUE;
        int[] rst = new int[2];
        if(ar1.length == 0 || ar2.length == 0){
            return rst;
        }
        for(int i = 0; i < ar1.length; i++){
            for(int j = 0; j < ar2.length; j ++){
                if(dist > Math.abs(ar1[i] + ar2[j] - x)){
                    dist = Math.abs(ar1[i] + ar2[j] - x);
                    rst[0] = ar1[i];
                    rst[1] = ar2[j];
                }
            }
        }
        return rst;
    }

    public static int[] closesTwoSum2(int ar1[], int ar2[], int x){
        int[] rst = new int[2];
        if(ar1.length == 0 || ar2.length == 0){
            return rst;
        }
        int dist = Integer.MAX_VALUE;
        int pt1 = 0, pt2 = ar2.length - 1;
        while(pt1 < ar1.length && pt2 >= 0){
            int temp = x - ar1[pt1] - ar2[pt2];
            if(temp > 0 && dist > temp){
                dist = x - ar1[pt1] - ar2[pt2];
                rst[0] = pt1;
                rst[1] = pt2;
            }
            if(temp > 0){
                pt1++;
            }else{
                pt2--;
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        int x = 32;
        int[] rst = closesTwoSum2(ar1, ar2, x);
        System.out.println(rst);
    }
}
