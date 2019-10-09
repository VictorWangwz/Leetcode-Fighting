package cc.ArraysAndStrings;
//31. Next Permutation
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                helper(nums, i);
                return;
            }
        }
        int l = 0 ;
        reverse(nums, l);
        return;
    }

    private void reverse(int[] nums, int l){
        int r = nums.length - 1;
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    private void helper(int[] nums, int idx ){
        int i = idx + 1;
        for(; i < nums.length && nums[i] > nums[idx]; i++){}
        int tmp = nums[i - 1];
        nums[i - 1] = nums[idx];
        nums[idx] = tmp;
        reverse(nums, idx + 1);
        return;
    }
}
