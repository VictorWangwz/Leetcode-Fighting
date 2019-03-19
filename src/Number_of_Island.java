class Solution {
    public int numIslands(char[][] grid) {
        int number = 0;
        if(grid.length == 0){
            return 0;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                char temp = '1';
                if(grid[i][j] == temp){
                    number += 1;
                    grid = dfs(grid, i, j);
                }
            }
        }
        return number;

    }
    public char[][] dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if(i+1<grid.length && grid[i+1][j]=='1'){
            grid = dfs(grid, i+1, j);
        }
        if (j+1<grid[0].length && grid[i][j+1]=='1' ){
            grid = dfs(grid, i, j+1);
        }
        return grid;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.print(sol.numIslands(grid));

    }

}