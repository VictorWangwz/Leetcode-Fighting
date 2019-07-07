import java.util.Arrays;
//45
public class JumpGame2 {
    public static int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;
        int[] min = new int[nums.length];
        boolean[] status = new boolean[nums.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(status, false);
        min[0] = 0;
        status[0] = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(status[i] && nums[i] > 0){
                for(int j = i + 1; j <= i + nums[i] && j < nums.length;j++){
                    min[j] = Math.min(min[j], min[i] + 1);
                    status[j] = true;
                }
            }
            status[i] = false;
        }
        if(status[nums.length - 1]) return min[nums.length - 1];
        return -1;
    }

    public static void main(String[] args) {
       int[] nums = {2,3,1,1,4};
       int rst = jump(nums);
       System.out.println(rst);
    }
}
