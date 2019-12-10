package javapractice.functionalprogramming.highorderfunction;

@FunctionalInterface
public interface TransformInterface  {
    StringComparator andThen(IntegerComparator integerComparator);
}
