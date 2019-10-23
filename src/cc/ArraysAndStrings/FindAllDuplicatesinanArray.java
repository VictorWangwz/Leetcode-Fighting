package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//442. Find All Duplicates in an Array
public class FindAllDuplicatesinanArray {

    private int[] swap(int[] nums, int i){
        int tmp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = tmp;
        return nums;
    }
    public List<Integer> findDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1 && nums[nums[i] - 1] != nums[i]){
                nums = swap(nums, i );
                i--;
            }
        }
        List<Integer> rst = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+ 1){
                rst.add(nums[i]);
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindAllDuplicatesinanArray findAllDuplicatesinanArray = new FindAllDuplicatesinanArray();
        List<Integer> rst = findAllDuplicatesinanArray.findDuplicates(nums);
        System.out.println(rst);
    }
}
