//7
public class ReverseInteger {
    public static int reverse(int x) {
        int rst = 0;
        while (x != 0) {
            if (rst > Integer.MAX_VALUE / 10 || rst < Integer.MIN_VALUE /10) return 0;
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        return rst;
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        int rst = reverse(x);
        System.out.println(rst);
    }
}
