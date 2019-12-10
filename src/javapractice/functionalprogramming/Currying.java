package javapractice.functionalprogramming;

import java.util.function.Function;

public class Currying {

    // a is effective final, just the same idea as hof
    static Function<String, Function<String, String>> curry = a -> b -> a + " " + b;

    public static void main(String[] args) {
        Function<String, String> function1 = curry.apply("Do you");
        System.out.println(function1.apply("have lunch"));
        System.out.println(function1.apply("finish homework"));
    }
}
