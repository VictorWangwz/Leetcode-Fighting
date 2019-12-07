package cc.TreesAndGraphs;

//1102. Path With Maximum Minimum Value

//todo
public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        boolean[][] path = new boolean[A.length][A[0].length];
        path[0][0] = true;
        int i = 0, j = 0;
        int min = A[0][0];
        while(!(i == A.length - 1 && j == A[0].length - 1)){

            int max = Integer.MIN_VALUE;
            int chosenI = i, chosenJ = j;
            if( i - 1 >= 0 && !path[i - 1][j]){
                if(A[i - 1][j] > max){
                    max = A[i - 1][j] ;
                    chosenI = i - 1;
                    chosenJ = j;
                }
            }
            if( i + 1 < A.length && !path[i + 1][j]){
                if(A[i + 1][j] > max){
                    max = A[i + 1][j] ;
                    chosenI = i + 1;
                    chosenJ = j;
                }
            }
            if(j - 1 >= 0 && !path[i][j - 1] ){
                if(A[i][j - 1] > max){
                    max = A[i][j - 1] ;
                    chosenI = i;
                    chosenJ = j - 1;
                }
            }
            if(j + 1 < A[0].length&&!path[i ][j + 1] ){
                if(A[i][j + 1] > max){
                    max = A[i][j + 1] ;
                    chosenI = i;
                    chosenJ = j + 1;
                }
            }
            path[chosenI][chosenJ] = true;
            min = Math.min(min, max);
            i = chosenI;
            j = chosenJ;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] A = {{2,0,2,3,1},{0,2,2,3,3},{2,3,0,2,3},{1,1,2,3,1},{2,2,0,0,1}};
        PathWithMaximumMinimumValue pathWithMaximumMinimumValue = new PathWithMaximumMinimumValue();
        int rst = pathWithMaximumMinimumValue.maximumMinimumPath(A);
        System.out.println(rst);
    }
}
