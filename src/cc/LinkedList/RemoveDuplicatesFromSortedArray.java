package cc.LinkedList;//26. Remove Duplicates from Sorted Array

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int anchor = 0;
        for(int i = 0; i < nums.length; i++){
            if(i + 1 >= nums.length || nums[i + 1] != nums[i]){
                nums[anchor++] = nums[i];
            }
        }
        return anchor;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int rst = removeDuplicates(nums);
        System.out.println(rst);
    }
}
