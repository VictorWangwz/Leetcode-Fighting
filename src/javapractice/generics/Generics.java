package javapractice.generics;

public class Generics<T extends Number> {
    T val;
    public Generics(T val){
        this.val = val;
    }
    public T getVal(){
        return val;
    }

    public void test(Generics<? extends Number> generics){
        System.out.println(generics.getVal());


    }

    public static <E extends Number & GenericsInterface>void testStatic(Generics<E> generics){
        E newVal = generics.getVal();
        System.out.println(newVal);
    }

    public static void main(String[] args) {
        Generics<Number> generics = new Generics<>(10);
        Generics<Integer> generics1 = new Generics<>(11);
//        System.out.println(generics.getVal());
//        System.out.println(generics1.getVal());
        generics.test(generics);
        generics1.test(generics1);


//
//        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        lsa[1] = li; // Correct.
//        Integer i = (Integer) lsa[1].get(0);
//        System.out.println(i);


    }
}
