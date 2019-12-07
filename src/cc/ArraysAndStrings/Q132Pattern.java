package cc.ArraysAndStrings;
//456. 132 Pattern
public class Q132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        int[] minL = new int[nums.length - 1];
        minL[0] = nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            minL[i] = Math.min(nums[i], minL[i - 1]);
            if(nums[i] > minL[i - 1]){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] > minL[i - 1] && nums[j] < nums[i]){
                        return true;
                    }
                }
            }

        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {
                -2,1,1,-2,1,1
        };
        Q132Pattern q132Pattern = new Q132Pattern();
        boolean rst = q132Pattern.find132pattern(nums);
        System.out.println(rst);
    }
}
