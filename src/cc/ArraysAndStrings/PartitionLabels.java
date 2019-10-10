package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//763. Partition Labels
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {

        int[] max = new int[26];
        int[] min = new int[26];
        for( int i = 0; i < 26; i++){
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(i > max[c - 'a']){
                max[c - 'a'] = i;
            }
            if(i < min[c - 'a']){
                min[c - 'a'] = i;
            }
        }

        List<Integer> rst = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            int start = i;
            int mx = max[S.charAt(i) - 'a'];
            while(i < mx){
                i++;
                if(mx < max[S.charAt(i) - 'a']){
                    mx = max[S.charAt(i) - 'a'];
                }
            }
            rst.add(mx - start + 1);

        }
        return rst;

    }
}
