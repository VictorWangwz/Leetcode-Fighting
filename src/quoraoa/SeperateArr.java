package quoraoa;

import java.util.Arrays;

public class SeperateArr {

    public int[][] seperateArr(int[] arr){


        if(arr == null || arr.length % 2 != 0){
            return new int[2][];
        }
        int[][] rst = new int[2][arr.length /2];

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            rst[i % 2][i /2] = arr[i];
            if(i /2 - 1 >= 0 && rst[i % 2][i /2] ==  rst[i % 2][i /2 - 1]){
                return new int[2][];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,4,5,6};
        SeperateArr seperateArr = new SeperateArr();
        int[][] rst = seperateArr.seperateArr(arr);
        System.out.println(rst);
    }
}
