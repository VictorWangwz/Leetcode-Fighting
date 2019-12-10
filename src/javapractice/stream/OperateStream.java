package javapractice.stream;

import java.util.stream.IntStream;

public class OperateStream {

    static public void mapTest(){
        IntStream.range(1,20).boxed().map(i -> IntStream.range(i, i * 10)).forEach(System.out::println);
    }

    static public void flatMapTest(){
        IntStream.range(1,20).flatMap(i -> IntStream.range(i, i * 10)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        mapTest();
        flatMapTest();

    }
}
