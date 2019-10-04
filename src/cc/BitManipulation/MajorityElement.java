package cc.BitManipulation;

//169. Majority Element
public class MajorityElement {

    // ez way by sorting
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2 ];
//    }


    //use bit manipulation: actually use int32 as a hash table
    public static int majorityElement(int[] nums) {
        int[] bits = new int[32];
        for(int num: nums){
            for(int i = 0; i < 32; i++){
                if((num & 1 << i) != 0){
                    bits[i]++;
                }
            }
        }
        int rst = 0;
        for( int i = 0; i < 32; i++){
            if(bits[i] > nums.length /2){
                int temp = 1 << i;
                rst += temp;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int rst = majorityElement(nums);
        System.out.println(rst);

    }
}
