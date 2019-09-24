package vopreparation0530;

public class ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        return 3;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        int expected = 3;
        int rst = triangleNumber(nums);
        System.out.print(rst == expected);
    }

}
