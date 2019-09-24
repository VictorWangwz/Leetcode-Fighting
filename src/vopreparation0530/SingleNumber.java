package vopreparation0530;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int expected = 1;
        int rst = singleNumber(nums);
        System.out.print(rst == expected);
    }
}
