package javapractice;

public class Ex1 extends Ex0 {

    public static void test()  {
        System.out.println("ex1s ");
    }

    public static void main(String[] args) {
        Ex1.test();
        Ex0 ex0 = new Ex0();
        ex0.test();
        Ex0 ex1 = new Ex1();
        ex1.test();

    }

}
