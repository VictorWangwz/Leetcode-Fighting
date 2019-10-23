package cc.ArraysAndStrings;
//75. Sort Colors
public class SortColors {
    //two pass
    public void sortColors0(int[] nums) {
        int numRed = 0, numWhite = 0, numBlue = 0;
        for(int num:nums){
            if(num == 0){
                numRed++;
            }else if(num == 1){
                numWhite ++;
            }
            else{
                numBlue++;
            }
        }
        for(int i = 0; i < numRed; i++){
            nums[i] = 0;
        }
        for(int i = numRed; i < numRed + numWhite; i++){
            nums[i]  = 1;
        }
        for(int i = numRed + numWhite; i < nums.length; i++){
            nums[i] = 2;
        }

    }

    // one pass
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while(cur <= p2){
            if(nums[cur] == 0){
                int tmp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
            if(nums[cur] == 2){
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            else{
                cur++;
            }

        }

    }
}
