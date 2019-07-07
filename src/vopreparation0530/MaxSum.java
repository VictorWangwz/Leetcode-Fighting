package vopreparation0530;


//一个数组里，找出连续子数组的最大的和。
//        -思路：扫一遍数组并累加求和，用sum来表示。若某一时刻sum>maxsum，则更新maxsum；若sum<0，则将sum重置为0，表示放弃前面的元素。（O(n) time）
public class MaxSum {
    public static int computeMaxSum(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int num: nums){
            sum += num;
            if(sum > maxSum) maxSum = sum;
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, -1, 4, -5, 9};
        int expected = 9;
        int rst = computeMaxSum(nums);
        System.out.print(rst == expected);
    }
}
