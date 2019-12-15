package quoraoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFreq {

    public int countFreq(int[] array, int[][] matrix){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int item = array[i];
            if(!map.containsKey(item)){
                map.put(item, new ArrayList<>());
            }
            map.get(item).add(i);
        }
        int rst = 0;
        for(int i = 0; i < matrix.length; i++){
            int l = matrix[i][0], r = matrix[i][1], target = matrix[i][2];
            if(map.containsKey(target)){
                for(int idx: map.get(target)){
                    if(idx >= l && idx <= r){
                        rst++;
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        CountFreq countFreq = new CountFreq();
        int[] array = {1,1,2,3,2};
        int[][] matrix = {
                {1,2,1},
                {2,4,2},
                {0,3,1}
        };
        int rst = countFreq.countFreq(array, matrix);
        System.out.println(rst);
    }
}
