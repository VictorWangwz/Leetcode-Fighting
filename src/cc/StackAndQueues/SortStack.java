package cc.StackAndQueues;

import java.util.Stack;

//Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
//an additional temporary stack, but you may not copy the elements into any other data structure
//(such as an array). The stack supports the following operations: push, pop, peek, and is Empty
public class SortStack {

    public void sort(Stack<Integer> stack){
        Stack<Integer> temp  = new Stack<Integer>();
        while( !stack.isEmpty()){
            int val = stack.pop();
            while( !temp.isEmpty() && temp.peek() > val){
                stack.push(temp.pop());
            }
            temp.push(val);
        }
        while( !temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}
