package javapractice.hashcode;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Example, Integer> hm = getAllData();

        Example dk = new Example("haha");
        System.out.println(dk.hashCode());

        Integer value = hm.get(dk);

        System.out.println(value);

    }

    private static Map<Example, Integer> getAllData() {
        Map<Example, Integer> hm = new HashMap<>();

        Example dk = new Example("haha");
        System.out.println(dk.hashCode());

        hm.put(dk, 10);
        System.out.println(hm.get(dk));
        return hm;
    }
}
