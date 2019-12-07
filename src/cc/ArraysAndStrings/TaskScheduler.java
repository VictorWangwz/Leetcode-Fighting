package cc.ArraysAndStrings;


import java.util.*;

//621. Task Scheduler
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: tasks){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                map.put(c, map.get(c) + 1);
            }
        }
        for(Character c: map.keySet()){
            pq.offer(map.get(c));
        }

        int rst = 0;
        while(!pq.isEmpty()){
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while(i <= n ){
                if(!pq.isEmpty()){
                    int tmp = pq.poll();
                    tmp--;
                    if(tmp != 0 ){
                        list.add(tmp);
                    }
                }
                rst++;
                if(pq.isEmpty() && list.size() == 0){
                    break;
                }

                i++;

            }
            for(int j = 0; j < list.size(); j++){
                pq.offer(list.get(j));
            }


        }
        return rst;

    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler taskScheduler = new TaskScheduler();
        int rst = taskScheduler.leastInterval(tasks, n);
        System.out.println(rst);
    }
}
