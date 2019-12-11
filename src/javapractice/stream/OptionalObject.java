package javapractice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalObject {

    public static void main(String[] args) {
        Optional optionalInteger = Stream.of(1,2,3,4).findAny();
        Optional optional1 = Optional.of(1);
        Optional optional = Stream.<String>empty().findFirst();
        System.out.println(optionalInteger);
        optionalInteger.ifPresent(System.out::println);
        System.out.println(optionalInteger.orElse(1));

        System.out.println(optionalInteger.filter(i -> (Integer)i > 2));
        System.out.println(optionalInteger.get());

        String[] arr = {"a", "b"};
        Stream stream = Arrays.stream(arr);
        Optional  optional2 = stream.skip(1).findFirst();
        System.out.println(optional2.filter(i -> {
            return i.equals("a");
        }));

        List<String> list = Arrays.stream(arr).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list);

        List<String> list1 = Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list1);

        String rst = Arrays.stream(arr).reduce("", (s1, s2) -> s1 + s2);
        System.out.println(rst);


    }
}
