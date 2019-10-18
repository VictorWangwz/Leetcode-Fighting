package cc.ArraysAndStrings;
//42. Trapping Rain Water
public class TrappingRainWater {

    public int trap(int[] height) {
        int rst = 0, start = 0;
        if(height == null || height.length <= 2){
            return 0;
        }
        while(start + 1 < height.length && height[start + 1] >= height[start]){
             start ++;
        }
        for(int i = start + 1; i < height.length - 1; i++){
            if(height[i] > height[i + 1] && height[i] >= height[start])
            {
                int h = Math.min(height[i], height[start]);
                for(int j = start + 1; j < i ; j++){
                    rst += h - height[j];
                }
                start = i;

            }

        }
        return rst;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int rst = trappingRainWater.trap(height);
        System.out.println(rst);
    }
}
