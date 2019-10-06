package cc.DpAndRecursion;

//733. Flood Fill
public class FloodFill {
    private static void helper(int[][] image,int sr, int sc, int oriColor, int newColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length){
            return;
        }
        if(image[sr][sc] == oriColor){
            image[sr][sc] = newColor;
            helper(image, sr - 1, sc, oriColor, newColor);
            helper(image, sr + 1, sc, oriColor, newColor);
            helper(image, sr, sc - 1, oriColor, newColor);
            helper(image, sr, sc + 1, oriColor, newColor);
        }

        return;
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oriColor = image[sr][sc];
        if(oriColor == newColor){
            return image;
        }
        helper(image,sr,sc, oriColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] rst =  floodFill(image, sr, sc,newColor);
    }
}
