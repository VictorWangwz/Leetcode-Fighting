import java.util.HashMap;
import java.util.Map;


class FruitIntoBlanket {

    public int totalFruit(int[] tree) {
        int res = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< tree.length; i++){
            int ori = map.containsKey(tree[i])? map.get(tree[i]): 0;
            map.put(tree[i], ori + 1);
            while(map.size()>=3){
                int temp = map.containsKey(tree[start])? map.get(tree[start]): 0;
                map.put(tree[start], temp -1);
                if(temp-1 == 0){
                    map.remove(tree[start]);
                }
                start++;
            }
            res = res>i-start+1? res: i-start+1;
        }
        return res;

        }


        public static void main(String[] args) {
        FruitIntoBlanket f = new FruitIntoBlanket();
        int[] tree = {1,2,1};
        System.out.print(f.totalFruit(tree));
    }
}



