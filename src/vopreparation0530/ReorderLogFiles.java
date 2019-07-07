package vopreparation0530;

//937

import java.util.Arrays;

public class ReorderLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int idx1 = log1.indexOf(" ");
            int idx2 = log2.indexOf(" ");
            String identifier1 = log1.substring(0, idx1);
            String identifier2 = log2.substring(0, idx2);
            String content1 = log1.substring(idx1 + 1);
            String content2 = log2.substring(idx2 + 1);
            boolean isDigit1 = Character.isDigit(log1.charAt(idx1 + 1));
            boolean isDigit2 = Character.isDigit(log2.charAt(idx2 + 1));
            if(isDigit1 && isDigit2) return 0;
            if(isDigit1) return 1;
            if(isDigit2) return -1;
            int compareRst = content1.compareTo(content2);
            if(compareRst != 0) return compareRst;
            return identifier1.compareTo(identifier2);
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] rst = reorderLogFiles(logs);
        System.out.println(rst);
    }
}
