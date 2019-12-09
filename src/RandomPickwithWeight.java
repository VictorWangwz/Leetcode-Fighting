import java.util.HashMap;
import java.util.Map;

//528. Random Pick with Weight
public class RandomPickwithWeight {
    class Solution {

        Map<Integer, int[]> map = new HashMap<>();
        int capacity;


        public Solution(int[] w) {
            int cur = 0;
            for (int i = 0; i < w.length; ) {
                int tmp = w[i];
                capacity += tmp;
                map.put(i, new int[2]);
                map.get(i)[0] = cur;
                map.get(i)[1] = cur + tmp  - 1;
                cur = cur + tmp;
                i ++;
            }
        }

        public int pickIndex() {
            int x = (int)(Math.random() * capacity);
            for(Map.Entry<Integer, int[]> e: map.entrySet()){
                if(e.getValue()[0] <= x && e.getValue()[1] >= x){
                    return e.getKey();
                }
            }
            return -1;


        }
    }

    public static void main(String[] args) {
        RandomPickwithWeight randomPickwithWeight = new RandomPickwithWeight();
        int[] w = {1,3,1,2};
        Solution solution = randomPickwithWeight.new Solution(w);
        for(int i = 0; i < 10; i++){
           System.out.println(solution.pickIndex());
        }
    }
}
