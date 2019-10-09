package googleoa;

import java.util.LinkedList;

//552. Student Attendance Record II
public class StudentAttendanceRecordII {

    private static int total = 0;

    private static void count(int pre, int end, int numOfA, LinkedList<Character> list){
        if(pre == end){
            total ++;
            return ;
        }
        int tempNumOfA = numOfA;
        //when ith is A:
        if(tempNumOfA  < 1){
            tempNumOfA ++;
            LinkedList<Character> aList = new LinkedList<>();
            if(list != null && list.size() != 0){
                aList.add(list.peekLast());
            }
            aList.addLast('A');
            count(pre+1, end, tempNumOfA, aList);
        }

        //when ith is P:
        LinkedList<Character> pList = new LinkedList<>();
        if(list != null && list.size() != 0){
            pList.add(list.peekLast());
        }
        pList.addLast('P');
        count(pre + 1, end , numOfA, pList);

        //when ith is L:
        LinkedList<Character> lList = new LinkedList<>();
        if(list != null && list.size() != 0){
            lList.add(list.peekLast());
        }
        lList.add('L');
        if(list.size() < 2){
            count(pre + 1, end, numOfA, lList);
        }
        else if(!(list.get(0).equals('L') &&list.get(1).equals('L'))){
            count(pre + 1, end, numOfA, lList);
        }


    }

    public static int checkRecord(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 3;
        }
        int numOfA = 0;
        LinkedList<Character> preTwoItem = new LinkedList<>();
        count(0, n, numOfA, preTwoItem);
        return total;
    }


    public static int checkRecord1(int n) {
        long M = 1000000007;
        long[] f = new long[n<=5? 6: n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;

        for(int i = 4; i <= n; i++){
            f[i] = (2 * f[i - 1]) % M + (M - f[i - 4]) % M;
        }

        long sum = f[n];
        for( int i = 0; i < n; i++){
            sum += (f[i] * f[n - i]) % M;
        }

        return (int) (sum % M);
    }

    public static void main(String[] args) {
        int n = 100;
        int rst = checkRecord(n);
        System.out.println(rst);
    }
}
