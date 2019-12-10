package javapractice.functionalprogramming.highorderfunction;

import java.util.function.Function;

public class TransformFunction {

    static public Function<Integer, Object> transform(Function<Integer, Object> comparator){

        //andThen is a bit like js promise
        return comparator.andThen(
                o -> {
                    if(o.equals(1)){
                        return o;
                    }
                    else{
                        return new Object();
                    }
                }
        );

    }

    public static void main(String[] args) {
        Function<Integer,  Object> function = transform((o1) -> (1));
        Object o = function.apply(1);
        System.out.println(o);
    }
}
