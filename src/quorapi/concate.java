package quorapi;

public class concate {
    long concatenationsSum(int[] a) {
        long rst = 0;
        for(int num1: a){
            for(int num2:a){
                rst += cal(num1, num2);
            }
        }
        return rst;
    }

    long cal(int num1, int num2){

        long l1 = Long.valueOf(num1);
        int tmp = num2, count = 0;
        while(tmp != 0){
            tmp /= 10;
            count++;
        }
        long l2 =  Long.valueOf(num2);
        l1 = l1 * (long)Math.pow(10, count) + l2;
        return l1;
    }
}
