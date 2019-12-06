package javapractice.generics;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    private static void dot(Set set, String s){
        set.add(s);
        set.add(1);
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        dot(set, "laa");
        System.out.println(set);
        for(Object i: set){
            System.out.println(i);
        }
    }
}
