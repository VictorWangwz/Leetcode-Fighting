package javapractice.functionalprogramming;


@FunctionalInterface
public interface TriFunctional<T, R, U> {

    //lambda cannot use generic method, but generic class is fine
//     <T extends Functional, R extends Functional, U extends Functional> String toString(T t, R r, U u);
    //lambda can be used for common one
    String toString(T t, R r, U u);
}
