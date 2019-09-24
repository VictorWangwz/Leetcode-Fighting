import java.util.*;

//15
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int target =  nums[i] * -1;
            int l = i + 1, h = nums.length - 1 ;
            while(l < h){
                List<Integer> tempL = new ArrayList<>();
                if(nums[l] + nums[h] == target){
                    tempL = Arrays.asList( nums[i],nums[l++],nums[h--]);
                    if(!rst.contains(tempL)){
                        rst.add(tempL);
                    }
                }else if(nums[l] + nums[h] < target){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> rst = threeSum(nums);
        System.out.println(rst);
    }
}
