package oa2preparation0519;

import java.util.Arrays;

public class TheMaze2 {

    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        int[][] dist = new int[maze.length][maze[0].length];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        helper(maze, start, dist);
        if(dist[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
        return dist[destination[0]][destination[1]];
    }

    public static void helper(int[][] maze, int[] start, int[][] dist){
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        for(int[] dir: dirs){
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                x += dir[0];
                y += dir[1];
                count += 1;
            }
            if(dist[start[0]][start[1]] + count < dist[x - dir[0]][y - dir[1]]){
                dist[x - dir[0]][y - dir[1]] = dist[start[0]][start[1]] + count;
                helper(maze, new int[]{x - dir[0], y - dir[1]}, dist);
            }

        }
    }

    public static void main(String[] args) {
        int[][] maze ={
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
                };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        int rst = shortestDistance(maze, start, destination);
        System.out.println(rst);
        }
}
