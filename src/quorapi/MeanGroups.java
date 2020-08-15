package quorapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MeanGroups {
    int[][] meanGroups(int[][] a) {
        if(a == null || a.length == 0){
            return new int[0][];
        }
        Map<Float, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            int[] record = a[i];
            float mean = (float) IntStream.of(record).sum() / record.length;
            if(!map.containsKey(mean)){
                map.put(mean, new ArrayList<>());
            }
            map.get(mean).add(i);
        }
        return new int[0][];

    }
}
