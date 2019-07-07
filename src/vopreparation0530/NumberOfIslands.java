package vopreparation0530;

public class NumberOfIslands {


    public static void bfsHelper(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||grid[i][j] == '0') return;
        grid[i][j] = '0';
        bfsHelper(grid, i - 1, j);
        bfsHelper(grid, i + 1, j);
        bfsHelper(grid, i, j - 1);
        bfsHelper(grid, i, j + 1);
        return;
    }
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rst = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1'){
                    bfsHelper(grid, i, j);
                    rst ++;
                }
        }
        return rst;

    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int expected = 3;
        int rst = numIslands(grid);
        System.out.println(rst == expected);

    }
}
