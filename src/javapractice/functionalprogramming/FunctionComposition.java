package javapractice.functionalprogramming;

import java.util.function.Function;

public class FunctionComposition {

    static Function<String, String>
    f1 = s -> s.toLowerCase(),
    f2 = s -> s.substring(1),
    f3 = s -> "#" + s,
    f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("FUNCTION COMPOSITION"));
    }
}
