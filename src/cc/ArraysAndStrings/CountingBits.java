package cc.ArraysAndStrings;
//338. Counting Bits
public class CountingBits {

    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        if(num == 0){
            return rst;
        }
        if(num == 1){
            rst[1] = 1;
            return rst;
        }
        rst[1] = 1;
        for(int i = 2; i <= num; i *= 2 ){
            if(i % 2 == 0 && rst[i / 2] == 1){
                rst[i] = 1;
                for(int j = 0; j < i; j++){
                    if(i + j <= num){
                        rst[i + j] = rst[i] + rst[j];
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int num = 6;
        CountingBits countingBits = new CountingBits();
        int[] rst = countingBits.countBits(num);
        System.out.println(rst);
    }
}
