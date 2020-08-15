package quoraoa;

import java.util.Stack;

public class AliceBobGame {

    public String play(int[] numbers){
        Stack<Integer> stack = new Stack<>();
        if(numbers == null && numbers.length == 0){
            return "Bob";
        }
        stack.push(numbers[0]);
        int num = 0;
        for(int i = 1; i < numbers.length; i++){
            if(stack.size() == 0){
                stack.push(numbers[i]);
            }
            else{
                int tmp = stack.peek();
                if(numbers[i] == tmp){
                    stack.pop();
                    num++;
                }
                else{
                    stack.push(numbers[i]);
                }
            }
        }
        if(num % 2 == 0){
            return "Bob";
        }
        else{
            return "Alice";
        }


    }

    public static void main(String[] args) {
        int[] numbers = {1,4,5,5,6};
//        int[] numbers = {1,2,2,3,3,1,1};
//        int[] numbers = {1,3,3,1,5};
        AliceBobGame aliceBobGame = new AliceBobGame();
        String rst = aliceBobGame.play(numbers);
        System.out.print(rst);
    }
}
