package quorapi;

import java.util.Stack;

//232. Implement Queue using Stacks
public class ImplementQueueusingStacks {
    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int val = -1;
            while(!s1.isEmpty()){
                if(s1.size() == 1){
                    val = s1.pop();
                }
                else{
                    s2.push(s1.pop());
                }
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return val;
        }

        /** Get the front element. */
        public int peek() {
            int val = -1;
            while(!s1.isEmpty()){
                if(s1.size() == 1){
                    val = s1.peek();
                }
                s2.push(s1.pop());
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return val;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }
}
