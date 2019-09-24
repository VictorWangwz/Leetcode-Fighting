import java.util.*;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        List<Integer> rst = new ArrayList<>();
        for(int i: nums){
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> l = new ArrayList<>(m.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(int i = 0; i < k; i++){
            rst.add(l.get(i).getKey());
        }
        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> rst = topKFrequent(nums, k);
        System.out.println(rst);
    }
}
