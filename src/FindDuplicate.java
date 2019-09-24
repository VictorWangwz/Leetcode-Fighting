//287. Find the Duplicate Number

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int previous = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == previous){
                return previous;
            }
            previous = nums[i];
        }
        return -1;
    }

    public static int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {
                1,3,4,2,2
        };
        int expected = 2;
        int rst = findDuplicate1(nums);
        System.out.println(expected == rst);
    }
}
