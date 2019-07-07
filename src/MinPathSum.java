// 64
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int min = 0;
                if(i <= 0 && j <= 0){
                    continue;
                }
                if(i <= 0 && j > 0 ){
                    min = grid[0][j - 1];
                }
                if(j <= 0 && i > 0){
                    min = grid[i - 1][0];
                }
                if(i > 0 && j > 0) {
                    min = Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
                grid[i][j] += min;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int rst = minPathSum(grid);
        System.out.println(rst);
    }
}
