package javapractice.multithread;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {

    static public void sequentialSumTest(){
        long t1 = System.currentTimeMillis();
        long rst = Stream.iterate(0L, i -> i+1).limit(10).reduce(0L,Long::sum);
        System.out.println(rst);
        System.out.println(System.currentTimeMillis() - t1);

    }

    static public void parallelSumTest(){
        long t1 = System.currentTimeMillis();
        long rst = Stream.iterate(0L, i -> i+1).limit(10).parallel().reduce(0L,Long::sum);
        System.out.println(rst);
        System.out.println(System.currentTimeMillis() - t1);
    }

    static public boolean isPrime(int n){
        return IntStream.rangeClosed(2,(int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    static public void findAllPrimesParalTest(){
        long t1 = System.currentTimeMillis();
        List<Integer> list = Stream
                .iterate(2, i -> i+ 1).parallel().limit(100).filter(ParallelStream::isPrime)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(System.currentTimeMillis() - t1);
    }
    static public void findAllPrimesTest(){
        long t1 = System.currentTimeMillis();
        List<Integer> list = Stream
                .iterate(2, i -> i+ 1).limit(100).filter(ParallelStream::isPrime)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void main(String[] args) {
        sequentialSumTest();
        parallelSumTest();
        findAllPrimesTest();
        findAllPrimesParalTest();

    }
}
