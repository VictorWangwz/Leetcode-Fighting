package javapractice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creation {

    Stream.Builder<Integer> builder = Stream.builder();

    static public <T>void randomShow(Stream<T> stream){
        stream.forEach(System.out::println);
    }

    static public void randomTest(){
        Random random = new Random(10);
        randomShow(random.ints(10, 2,10).boxed());
        randomShow(random.doubles(10, 2,10).boxed());

    }

    static public void intStreamTest(){
        int rst = 0;
        for(int i: IntStream.range(1, 20).toArray()){
            rst += i;
        }
        System.out.println(rst);

        System.out.println(IntStream.range(1, 20).sum());


    }

    static public void generateTest(){
        List<Integer> list = Stream.generate(() -> new Random().nextInt()).limit(10).collect(Collectors.toList());
        System.out.println(list);
    }

    public void builderTest(){
        IntStream.range(1, 10).boxed().forEach(i -> builder.add(i));
        Stream<Integer> s = builder.build();
        s.forEach(System.out::println);
    }

    int x = 1;
    public void iteratorTest(){

        Stream.iterate(0, i -> {
            int rst = i + x;
            x = i;
            return rst;
        }).limit(10).forEach(System.out::println);
    }

    public void arrayStreamTest(){
        Arrays.stream(new int[]{1,2,3,4}).boxed().forEach(System.out::print);
    }


    public static void main(String[] args) {
        //1. use Stream.of()
        Stream.of(1, 2, 3, 4).forEach(System.out::println);

        //2. use collections.stream()
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        list.stream().forEach(i -> System.out.println(i));

        randomTest();

        intStreamTest();

        generateTest();

        Creation creation = new Creation();
        creation.iteratorTest();
        creation.builderTest();
        creation.arrayStreamTest();
    }
}
