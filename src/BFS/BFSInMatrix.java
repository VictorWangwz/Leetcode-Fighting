package BFS;

public class BFSInMatrix {
    //Num of Islands
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                count += numIslandsBFS(grid, i, j);
            }
        }
        return count;
    }

    public static int numIslandsBFS(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        int rst = 1;
        grid[i][j] = '0';
        numIslandsBFS(grid, i + 1, j);
        numIslandsBFS(grid, i - 1, j);
        numIslandsBFS(grid, i, j + 1);
        numIslandsBFS(grid, i, j - 1);
        return rst;
    }

    //302. Smallest Rectangle Enclosing Black Pixels
    static class ResultType{
        int minX;
        int minY;
        int maxX;
        int maxY;
        public  ResultType(int minX, int minY, int maxX, int maxY){
            this.maxX = maxX;
            this.maxY = maxY;
            this.minX = minX;
            this.minY = minY;
        }
    }

    public static void minAreaBFS(char[][] image, int x, int y){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == '0') return;
        if(x > rst.maxX) rst.maxX = x;
        if(x < rst.minX) rst.minX = x;
        if(y > rst.maxY) rst.maxY = y;
        if(y < rst.minY) rst.minY = y;
        image[x][y] = '0';
        minAreaBFS(image, x - 1, y);
        minAreaBFS(image, x + 1, y);
        minAreaBFS(image, x, y - 1);
        minAreaBFS(image, x, y + 1);
    }
    static ResultType rst;
    public static int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0) {
            return 0;
        }
        rst = new ResultType(x, y , x, y);
        minAreaBFS(image, x, y);
        return (rst.maxY - rst.minY + 1) * (rst.maxX - rst.minX + 1);
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] image = {{'0','0','1','0'}, {'0','1','1','0'}, {'0','1','0','0'}};
        int x = 0;
        int y = 2;
        int rst = minArea(image, x, y);
        System.out.println(rst);
    }
}
