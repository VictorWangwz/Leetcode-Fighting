import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//128
public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            set.add(num);
        }
        Integer[] newNums = new Integer[set.size()];
        set.toArray(newNums);
        Arrays.sort(newNums);
        int max = 1;
        int count = 1;
        int cur = newNums[0];
        for(int i = 1; i < newNums.length; i++){
            if(cur != newNums[i] - 1){
                count = 1;
                cur = newNums[i];
                continue;

            }
            cur = newNums[i];
            count++;
            if(count > max){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int rst = longestConsecutive(nums);
        System.out.println(rst);
    }
}
