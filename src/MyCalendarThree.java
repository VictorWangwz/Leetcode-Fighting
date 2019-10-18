//732. My Calendar III

import java.util.TreeMap;

public class MyCalendarThree {

    private TreeMap<Integer, Integer> calendar;


    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int val: calendar.values()){
            count += val;
            if(count > max){
                max = count;
            }
        }
        return max;
    }
}
