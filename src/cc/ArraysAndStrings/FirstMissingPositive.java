package cc.ArraysAndStrings;

//41. First Missing Positive
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int l = 0, r = nums.length - 1;
        int count = 0;
        while(l <= r){
            if(nums[l] >= 1){
                count ++;
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                r--;
            }
            else{
                l++;
            }
        }

        if(count == 0){
            return 1;
        }
        int[] mem = new int[count + 1];
        for(int i = l; i < nums.length; i++){
            if(nums[i] < mem.length){
                mem[nums[i] - 1] = 1;
            }
        }

        for(int i = 0; i < count+1; i++){
            if(mem[i] != 1){
                return i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int rst = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(rst);
    }
}
