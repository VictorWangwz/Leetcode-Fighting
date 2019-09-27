package cc.DpAndRecursion;

//Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
//different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
//of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
//constraints:
//(1) Only one disk can be moved at a time.
//(2) A disk is slid off the top of one tower onto another tower.
//(3) A disk cannot be placed on top of a smaller disk.
//Write a program to move the disks from the first tower to the last using Stacks.

import java.util.Stack;

public class TowersofHanoi {

    public static void move(int num, Stack src, Stack aux, Stack dest){
        if(num == 0){
            return;
        }
        if(num == 1){
            dest.push(src.pop());
            return;
        }
        if(num == 2){
            aux.push(src.pop());
            dest.push(src.pop());
            dest.push(aux.pop());
            return;
        }
        move(num - 1, src, dest, aux);
        move(1, src, aux, dest);
        move(num - 1, aux,  src, dest);
        return;

    }

    public static void main(String[] args) {
        Stack<Integer> src = new Stack<>();
        int num = 10;
        for(int i = num; i > 0; i--){
            src.push(i);
        }
        Stack<Integer> aux = new Stack<>(), dest = new Stack<>();

        move(num, src, aux, dest);
        System.out.println(src);
        System.out.println(dest);
    }

}
