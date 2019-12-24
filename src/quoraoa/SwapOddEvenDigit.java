package quoraoa;

import java.util.Stack;

public class SwapOddEvenDigit {

    public int swap(int num){
        Stack<Integer> stack = new Stack<>();
        while(num != 0){
            stack.push(num % 10);
            num /= 10;
        }
        int rst = 0;
        while(stack.size() >= 2){
            int first = stack.pop();
            int second = stack.pop();
            rst = rst * 100 + second * 10 + first;
        }
        if(stack.size() == 1){
            rst = rst * 10 + stack.pop();
        }
        return rst;
    }

    public static void main(String[] args) {
        int num = 123456;
        SwapOddEvenDigit swapOddEvenDigit = new SwapOddEvenDigit();
        int rst = swapOddEvenDigit.swap(num);
        System.out.println(rst);
    }
}
