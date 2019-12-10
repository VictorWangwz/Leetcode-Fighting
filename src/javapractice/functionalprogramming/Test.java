package javapractice.functionalprogramming;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class Test {

    public static void main(String[] args) {
        Functional1 functional1 = s -> String.join(" ", s);
        System.out.println(functional1.call("lambda"));

        Functional functional = new Functional("name");

        Functional1 functional11 = functional::toString;
        System.out.println(functional11.call("method reference"));

        Functional2 functional2 = Functional::toString;
        System.out.println(functional2.toString(functional, "unbound reference"));

        //method reference param and return of interface method and referenced one should be matchup, otherwise fail to compile
        Constructor constructor = Functional::new;
        Functional functional3 = constructor.construct("constructor reference");
        System.out.println(functional3.toString("constructor reference"));

        Functional3WithException functional3WithException = functional::toString;
        try{
            System.out.println(functional3WithException.get("functional interface with exception"));
        }catch (IOException e){
            e.printStackTrace();
        }

//        Predicate -- one param, return boolean,boolean test(T t)
//        Comparator -- one param, return int, compare
//        Consumer -- one param, no return，consume, void accept(T t)
//        Function -- one param, one retrun，R apply(T t)
//        Supplier -- no param, one return，T get()
//        UnaryOperator -- single operator， extends Function, type of param == type of return。
//        BinaryOperator -- binary operator， two param, extend BiFunction
        UnaryOperator<String> unaryOperator = functional::toString;
        System.out.println(unaryOperator.apply("util.function interface"));

        TriFunctional<Functional, Functional, Functional> triFunctional = Test::f;
        System.out.println(triFunctional.toString(functional, functional, functional));

        triFunctional = (i, l, d) -> (l.name + i.name + d.name + " lambda");
        System.out.println(triFunctional.toString(functional, functional, functional));


    }
    static String f(Functional i, Functional l, Functional d) { return l.name + i.name + d.name + " method reference"; }

}
