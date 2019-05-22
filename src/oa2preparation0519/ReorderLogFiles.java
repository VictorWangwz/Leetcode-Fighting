package oa2preparation0519;

import java.util.*;

public class ReorderLogFiles {
//    Give a log, consisting of List< String >, each element representing one line of logs. Each line of log
//    information is separated by a space. The first is ID of the log, followed by the log content. There are two
//    ways to make content:
//            1. All consist of letters and spaces.
//            2. All consist of numbers and spaces.
//    Now that the logs are sorted, it is required that component 1 be sorted in order of content
//    lexicography and placed at the top, and component 2 should be placed at
//    the bottom and output in the order of input. (Note that the space also belongs to the content, and
//    when the lexicographic order of the composition method 1 is equal, sort according to the dictionary
//    order of log ID., and the guarantee ID is not repeated)


    // Use Arrays.sort
    public static String[] logSort(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> {
            int contentIdx1 = str1.indexOf(" ");
            int contentIdx2 = str2.indexOf(" ");
            boolean isDigit1 = Character.isDigit(str1.charAt(contentIdx1 + 1));
            boolean isDigit2 = Character.isDigit(str2.charAt(contentIdx2 + 1));
            if(isDigit1 && isDigit2){
                return 0;
            }
            if(isDigit1) return 1;
            if(isDigit2) return -1;
            int compare = str1.substring(contentIdx1 + 1).compareTo(str2.substring(contentIdx2 + 1));
            if(compare != 0){
                return compare;
            }
            return str1.substring(0, contentIdx1).compareTo(str2.substring(0, contentIdx2));
        });
        return logs;
    }

    //Use Collections.sort
    static class MyCompartor implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            int contentIdx1 = s1.indexOf(" ");
            int contentIdx2 = s2.indexOf(" ");
            String h1 = s1.substring(0, contentIdx1);
            String h2 = s2.substring(0, contentIdx2);
            String c1 = s1.substring(contentIdx1 + 1);
            String c2 = s2.substring(contentIdx2 + 1);
            boolean isDigit1 = Character.isDigit(s1.charAt(contentIdx1 + 1));
            boolean isDigit2 = Character.isDigit(s2.charAt(contentIdx2 + 1));
            if(isDigit1 && isDigit2){
                return 0;
            }
            if(isDigit1){
                return 1;
            }
            if(isDigit2){
                return -1;
            }
            if(c1.compareTo(c2) == 0){
                return h1.compareTo(h2);
            } else{
                return c1.compareTo(c2);
            }
        }
    }

    public static String[] logSort2(String[] logs) {
        List<String> log_list = new ArrayList<>();
        for(String log: logs){
            log_list.add(log);
        }
        MyCompartor compartor = new MyCompartor();
        Collections.sort(log_list, compartor);
        String[] rst = new String[logs.length];
        int cnt = 0;
        for(String i: log_list) {
            rst[cnt++] = i;
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] logs = {"zo4 4 7","a100 Act zoo","a1 9 2 3 1","g9 act car"};
        String[] rst = logSort2(logs);
        System.out.println(rst);
    }
}
