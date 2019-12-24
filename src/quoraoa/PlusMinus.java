package quoraoa;

import java.util.Stack;

public class PlusMinus {
    public int cal(int num){
        Stack<Integer> stack = new Stack<>();
        while(num != 0){
            stack.push(num % 10);
            num /= 10;
        }

        int rst = 0;
        boolean plus = true;
        while(!stack.isEmpty()){
            if(plus){
                rst += stack.pop();
                plus = !plus;
            }else{
                rst -= stack.pop();
                plus = !plus;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int num = 12345;
        PlusMinus plusMinus = new PlusMinus();
        int rst = plusMinus.cal(num);
        System.out.println(rst);
    }
}
