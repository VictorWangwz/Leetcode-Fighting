import java.util.ArrayList;
import java.util.List;

//729. My Calendar I
public class MyCalendar {

    private List<int[]>  calendar ;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
       if(calendar.isEmpty()){
           calendar.add(new int[]{start, end});
           return true;
       }
       for(int[] record: calendar){
           if(record[1] >  start && record[0] < end ){
               return false;
           }
       }
        calendar.add(new int[]{start, end});
        return true;

    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        int[][] dataList = {{97,100},{33,51},{89,100},{83,100},
                {75,92},{76,95},{19,30},{53,63},{8,23},{18,37},{87,100},{83,100},{54,67},{35,48},
                {58,75},{70,89},{13,32},{44,63},{51,62},{2,15}};
        for(int[] data: dataList){
            System.out.println(myCalendar.book(data[0], data[1]));
        }
    }
}
