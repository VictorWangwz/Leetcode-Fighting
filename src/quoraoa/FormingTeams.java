package quoraoa;

import java.util.*;
import java.util.stream.IntStream;

public class FormingTeams {

    public List<Set<Integer>> formTeam(int k, int[] players){
        int[] sortedIndices = IntStream
                .range(0, players.length).boxed()
                .sorted((i, j) -> players[i] - players[j])
                .mapToInt(i -> i).toArray();
        Arrays.sort(players);

        List<Set<Integer>> rst = new ArrayList<>();

        for(int i = 0; i < players.length; i++){
            int target = k - players[i];
            int l = i + 1, h = players.length - 1;
            while(l < h){
                if(players[l] + players[h] == target){
                    Set<Integer> set = new HashSet<>();
                    set.add(sortedIndices[i]);
                    set.add(sortedIndices[h]);
                    set.add(sortedIndices[l]);
                    rst.add(set);
                    if(l + 1 < h && players[l] == players[l + 1]){
                        l++;
                    }
                    else if(h - 1 > l && players[h] == players[h - 1]){
                        h--;
                    }
                    else{
                        l++;
                        h--;
                    }
                }
                else if(players[l] + players[h] > target){
                    h--;
                }
                else{
                    l++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] players = {-1, 0, 1, 2, -1, -4};
        int k = 0;
        FormingTeams formingTeams = new FormingTeams();
        List<Set<Integer>> rst = formingTeams.formTeam(k, players);
        System.out.println(rst);
    }
}
