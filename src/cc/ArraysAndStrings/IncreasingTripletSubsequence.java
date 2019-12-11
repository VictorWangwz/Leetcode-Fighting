package cc.ArraysAndStrings;
//334. Increasing Triplet Subsequence
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <=2 ){
            return false;
        }
        boolean[] t1 = new boolean[nums.length];
        t1[0] = false;
        boolean[] t2 = new boolean[nums.length];
        t2[nums.length - 1] = false;

        int min = nums[0], max = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            t1[i] = nums[i] > min;
            min = nums[i] > min? min: nums[i];
            t2[nums.length - i - 1] = nums[nums.length - i - 1] < max;
            max = nums[nums.length - i - 1] < max? max: nums[nums.length - i - 1];
        }
        for(int i = 0; i < nums.length; i++){
            if(t1[i] && t2[i]){
                return true;
            }

        }
        return false;
    }
}
