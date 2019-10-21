package cc.TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//547. Friend Circles
public class FriendCircles {
    public int findCircleNum0(int[][] M) {
        if( M == null || M.length == 0 || M[0].length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int circleN = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < M.length; i++){
            if(!set.contains(i)){
                stack.push(i);
                circleN ++;
                while(!stack.isEmpty()){
                    int idx = stack.pop();
                    for(int j = 0; j < M[0].length; j++){
                        if(M[idx][j] == 1 && !set.contains(j)){
                            set.add(j);
                            stack.push(j);
                        }
                    }
                }

            }


        }
        return circleN;


    }


    private void dfs(int[][] M, int[] visited, int i){
        visited[i] = 1;
        for(int j = 0; j < M[i].length; j++){
            if(M[i][j] == 1 && visited[j] == 0){
                dfs(M, visited, j);
            }
        }

    }


    //dfs
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++){
            if(visited[i] ==0){
                dfs(M, visited, i);
                count ++;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        FriendCircles friendCircles = new FriendCircles();
        int rst = friendCircles.findCircleNum(M);
        System.out.println(rst);
    }

}
