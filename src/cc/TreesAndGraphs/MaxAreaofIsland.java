package cc.TreesAndGraphs;
//695. Max Area of Island
public class MaxAreaofIsland {

    private void calIslandArea(int[][] grid, int r, int c){
        // if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
        //     return;
        // }
        if(grid[r][c] == 1){
            grid[r][c] = 0;
            area ++;
            if(r - 1 >= 0 && grid[r - 1][c] == 1){
                calIslandArea(grid, r - 1, c);
            }
            if(r + 1 < grid.length && grid[r + 1][c] == 1){
                calIslandArea(grid, r + 1, c);
            }
            if(c - 1 >= 0 && grid[r][c  -1] == 1){
                calIslandArea(grid, r, c - 1);
            }
            if(c + 1 < grid[0].length && grid[r][c + 1] == 1){
                calIslandArea(grid, r, c + 1);
            }
        }
    }

    private int area;
    public int maxAreaOfIsland(int[][] grid) {
        int rst = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    area = 0;
                    calIslandArea(grid, i, j);
                    if(area > rst){
                        rst = area;
                    }
                }
            }
        }
        return rst;
    }
}
