import java.util.*;

//403
public class FrogJump {
    public static boolean canCross(int[] stones) {
        if(stones == null || stones.length <= 1 || stones[1] - stones[0] != 1)
            return false;
        if(stones.length == 2 && stones[1] - stones[0] == 1)
            return true;
        Map<Integer, Set<Integer>> m = new HashMap<>();
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        m.put(1, s1);
        for(int i = 2; i < stones.length; i++){
            Set<Integer> si = new HashSet<>();
            for(Map.Entry<Integer, Set<Integer>> e: m.entrySet()){
                int temp = e.getKey().intValue();
                Set<Integer> sT = e.getValue();
                for(Integer ele: sT){
                    if(stones[i] <= ele + 1 + stones[temp] && stones[i] >= ele -1 + stones[temp]){
                        si.add(stones[i] - stones[temp]);
                    }
                }
            }
            m.put(i, si);
        }
        return m.get(stones.length - 1).size() != 0;
    }

    // memory limit exceeded
    public static boolean canCross2(int[] stones) {
        if(stones == null || stones.length <= 1 || stones[1] - stones[0] != 1)
            return false;
        List<Integer>[] dp = new List[stones.length - 1];
        dp[0] = new ArrayList<>();
        dp[0].add(1);
        for(int i = 2; i < stones.length; i++){
            dp[i - 1] = new ArrayList<>();
            for(int j = 0; j < i-1; j++){
                int max = 0;
                for(Integer e : dp[j]){
                    if(stones[i] <= e.intValue() + 1 + stones[j + 1] && stones[i] >= e.intValue() -1 + stones[j + 1]){
                        dp[i - 1].add(stones[i] - stones[j + 1]);
                    }
                    if(max < e.intValue())
                        max = e.intValue();
                }
                if(stones[i] > max + 1 + stones[j + 1]){
                    dp[j].clear();
                }
            }
        }
        return !dp[stones.length - 2].isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        boolean rst = canCross(stones);
        System.out.println(rst);
    }
}
