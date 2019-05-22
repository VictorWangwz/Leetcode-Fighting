package oa2preparation0519;

public class KMinDist {
    static int rst = Integer.MAX_VALUE;
    public static int removeObstacle(int m, int n, int[][] lot){
        helper(lot, 2, 2, 0);
        return rst;
    }
    public static void helper(int[][] lot, int i, int j, int step){
        if(i < 0 || i >= lot.length || j < 0 || j >= lot[0].length || lot[i][j]==0) return;
        if(lot[i][j] == 9) {
            rst = Math.min(rst, step);
            return;
        }
        lot[i][j] = 0;
        helper(lot, i, j + 1, step +1);
        helper(lot, i, j - 1, step +1);
        helper(lot, i + 1, j, step +1);
        helper(lot, i - 1, j + 1, step +1);
        lot[i][j] = 1;
    }

    public static void main(String[] args) {
        int[][] lot = {
                {1, 0, 0},
                {1, 1, 1},
                {1, 1, 9}
        };
        int m = 0, n = 0;
        int opt = removeObstacle(m, n, lot);
        System.out.println(opt);
    }
}
