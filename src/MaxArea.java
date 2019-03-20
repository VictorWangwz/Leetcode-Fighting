public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = Math.min(height[l], height[r]) * (height.length - 1);
        while(l < r){
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
            int new_res = Math.min(height[l], height[r]) *(r-l);
            if( new_res>res){
                res = new_res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        int[] height = {
            1,8,6,2,5,4,8,3,7
        };
        System.out.print(m.maxArea(height));
    }
}
