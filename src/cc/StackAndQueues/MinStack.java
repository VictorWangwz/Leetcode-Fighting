package cc.StackAndQueues;

import java.util.Stack;

//155. Min Stack
public class MinStack {

    class Min{
        int val;
        int min;

        public Min(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<Min> stack ;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Min min = new Min(x, Math.min(getMin(), x));
        stack.push(min);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        if(stack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return stack.peek().min;
        }
    }
}
