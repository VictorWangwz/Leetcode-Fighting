package cc.ArraysAndStrings;
//994. Rotting Oranges
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        boolean change = true;
        int time = 0;
        boolean allrotten = true;
        while(change){
            change = false;
            allrotten = true;
            int[][] newGrid = new int[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){

                    newGrid[i][j] = grid[i][j];
                    if(grid[i][j] != 0 &&
                            ( (i - 1 >=0 && grid[i - 1][j] == 2)
                                    ||(i + 1 < grid.length && grid[i + 1][j] == 2)
                                    ||(j - 1 >=0 && grid[i][j - 1] == 2)
                                    ||(j + 1 < grid[0].length && grid[i][j + 1] == 2)
                            )
                    ){
                        newGrid[i][j] = 2;
                    }

                    if(grid[i][j] != newGrid[i][j]){
                        change = true;
                    }
                    if(newGrid[i][j] == 1 ){
                        allrotten = false;
                    }
                }
            }
            grid = newGrid;
            if(change){
                time++;
            }

            if(allrotten){
                return time;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 2},

        };
        RottingOranges rottingOranges = new RottingOranges();
        int rst = rottingOranges.orangesRotting(grid);
        System.out.println(rst);
    }
}
