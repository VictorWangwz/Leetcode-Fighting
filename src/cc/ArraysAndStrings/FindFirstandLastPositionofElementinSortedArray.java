package cc.ArraysAndStrings;

import java.util.Arrays;

//34. Find First and Last Position of Element in Sorted Array
public class FindFirstandLastPositionofElementinSortedArray {
    private void helper(int[] nums, int l, int r, int target){
        if(l > r){
            return;
        }
        int mid = (l + r) >> 1;
        if(nums[mid] == target && (mid - 1  < 0 || nums[mid - 1] < target)){
            rst[0] = mid;
        }
        if(nums[mid] == target && ( mid + 1 == nums.length|| nums[mid + 1] > target )){
            rst[1] = mid;
        }
        if(nums[mid] == target){
            helper(nums, l, mid - 1, target);
            helper(nums, mid + 1, r, target);
        }
        else if(nums[mid] < target){
            helper(nums, mid + 1, r, target);
        }else{
            helper(nums, l, mid - 1, target);
        }

    }

    private int[] rst = new int[2];
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        Arrays.fill(rst, -1);
        helper(nums, l, r, target);


        return rst;

    }
}
