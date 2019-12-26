package quoraoa;

import java.util.*;

//525. Contiguous Array
public class ContiguousArray {
//    time limited exceeded
    public int findMaxLength0(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int start = 0;
        for(int i = 0; i < dp.length; i++){
            start += nums[i] == 0? -1: 1;
            dp[i] = start;
        }

        int rst = 0;
        for(int i = dp.length - 1; i >= 0; i--){
            if(dp[i] == 0){
                rst = i + 1 > rst? i+1: rst;
            }
            else{
                for(int j = 0; j < i; j++){
                    if(dp[j] == dp[i]){
                        rst = i - j  > rst? i - j  : rst;
                        break;
                    }
                }
            }
        }
        return rst;
    }

    //pass 5%
    public int findMaxLength1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int rst = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(nums[0] == 0){
            dp[0] = -1;
        }
        else{
            dp[0] = 1;
        }
        map.put(dp[0], new ArrayList<>());
        map.get(dp[0]).add(0);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                dp[i] = dp[i - 1] - 1;
            }
            else{
                dp[i] = dp[i - 1] + 1;
            }
            if(dp[i] == 0){
                rst = i + 1;
            }
            if(!map.containsKey(dp[i])){
                map.put(dp[i], new ArrayList<>());
            }
            map.get(dp[i]).add(i);
        }
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            List<Integer> l = e.getValue();
            rst = Math.max((l.get(l.size() - 1) - l.get(0) ), rst);
        }
        return rst;


    }

    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        ContiguousArray contiguousArray = new ContiguousArray();
        int rst = contiguousArray.findMaxLength(nums);
        System.out.println(rst);
    }
}
