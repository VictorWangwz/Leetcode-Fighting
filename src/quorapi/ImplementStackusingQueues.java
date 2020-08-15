package quorapi;

import java.util.LinkedList;
import java.util.Queue;

//225. Implement Stack using Queues
public class ImplementStackusingQueues {
    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.offer(x);

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int val = - 1;
            while(!q1.isEmpty()){
                if(q1.size() == 1){
                    val = q1.poll();
                }
                else{
                    q2.offer(q1.poll());
                }

            }
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
            return val;

        }

        /** Get the top element. */
        public int top() {
            int val = - 1;
            while(!q1.isEmpty()){
                if(q1.size() == 1){
                    val = q1.peek();
                }
                q2.offer(q1.poll());
            }
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
            return val;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }

    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.pop();
        System.out.print(myStack.empty());

    }


}
