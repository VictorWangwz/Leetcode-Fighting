package cc.TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//1197. Minimum Knight Moves
//four Quadrants are the same, so only consider one Quadrant to accelerate;
// change x y to hash cuz there is a constraint on x, y : |x| + |y| < 300
public class MinimumKnightMoves {


//    private void helper(int tX, int tY, int x, int y, int dist){
//        if(found){
//            return;
//        }
//        dist++;
//        if(x == tX && y == tY){
//            rst = dist;
//            found = true;
//            return;
//        }
//        for(int[] dir: dirs){
//            if((tX - x)* (dir[0] - 0) > 0 && (tY - y)* (dir[1] - 0) > 0){
//                int tmpX = x+dir[0];
//                int tmpY = y+dir[1];
//                Integer[] tmp = {tmpX, tmpY};
//                if(!mem.contains(tmp)){
//                    mem.add(tmp);
//                    helper(tX, tY, tmpX, tmpY, dist);
//                }
//            }
//
//        }
//
//
//    }
public int minKnightMoves(int x, int y) {
    int rst = 0;
    int[][] dirs = {
            {1,2},
            {-1,2},
            {2,1},
            {2,-1},
            {1,-2},
            {-1,-2},
            {-2,1},
            {-2,-1}
    };
    if(x == 0 && y == 0){
        return rst;
    }
    x = Math.abs(x);
    y = Math.abs(y);
    Set<Integer> mem = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    while(!q.isEmpty()){
        int layerSize = q.size();
        while(layerSize -- > 0){
            int[] cur = q.poll();
            for(int[] dir: dirs){
                int nextX = cur[0] + dir[0], nextY = cur[1] + dir[1];
                int hash = 1000 *(nextX) + nextY;
                int[] nextArr = new int[]{nextX,nextY};
                if(nextX >= -2 && nextY >= -2 && !mem.contains(hash)){
                    if( nextX== x && nextY == y){
                        return rst + 1;
                    }
                    q.offer(nextArr);
                    mem.add(hash);
                }
                else{
                    continue;
                }
            }
        }
        rst++;


    }

    return  -1;
}

    public static void main(String[] args) {
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        int x = -172,
            y = -110;
        int rst = minimumKnightMoves.minKnightMoves(x, y);
        System.out.println(rst);
    }
}
