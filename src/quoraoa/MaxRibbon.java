package quoraoa;

import java.util.Arrays;

// or CutWood: Given an int array wood representing the length of n pieces of wood and an int k.
// It is required to cut these pieces of wood such that more or equal to k pieces of the same length len are cut.
// What is the longest len you can get?
public class MaxRibbon {

    private boolean isValid(int[] wood, int length, int k){
        int num = 0;
        for(int w: wood){
            num += w /length;
        }
        return num >= k;
    }

    public int maxRibbon(int[] wood, int k){
        int max = Arrays.stream(wood).max().getAsInt();

        int left = 1, right = max;
        int rst = 0;
        while(left <= right){
            int mid = left + (right  - left )/2;
            if(isValid(wood, mid, k)){
                left = mid + 1;
                rst = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return rst;
    }


    private boolean valid(int[] piles, int len, int H){
        int num = 0;
        for(int pile: piles){
            num += pile / len;
            if(pile % len != 0){
                num ++;
            }
        }
        return num <= H;
    }

    public int minEatingSpeed(int[] piles, int H) {
        if(piles == null || piles.length == 0 || H == 0){
            return 0;
        }

        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = max;

        int rst = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(valid(piles, mid, H)){
                rst = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        MaxRibbon maxRibbon =  new MaxRibbon();
        int[] wood = {5, 9, 7};
        int k = 5;
        int rst = maxRibbon.maxRibbon(wood, k);

        int[] piles = {3,6,7,11};
        int H = 8;
        int rst2 = maxRibbon.minEatingSpeed(piles, H);
        System.out.println(rst);
        System.out.println(rst2);
    }
}
