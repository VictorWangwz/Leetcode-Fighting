import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//368
public class LargestDivisionSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] dp = new List[nums.length];
        int maxSize = 1;
        int maxIdx = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = new ArrayList<Integer>();
            if(i == 0){
                dp[i].add(nums[i]);
                continue;
            }
            int max = 0;
            int idx = i;
            for(int j = 0; j < i; j ++){
                if(nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0){
                    if(max < dp[j].size()){
                        max = dp[j].size();
                        idx = j;
                    }
                }
            }
            dp[i].add(nums[i]);
            if(idx != i){
                dp[i].addAll(dp[idx]);
            }
            if(dp[i].size() > maxSize){
                maxSize = dp[i].size();
                maxIdx = i;
            }
        }
        return dp[maxIdx];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> rst = largestDivisibleSubset(nums);
        System.out.println(rst);
    }
}
