package javapractice.functionalprogramming.highorderfunction;

public class ProducerFunction {

    public StringComparator produceStringComparator(){
        return (s1,s2) -> s1.compareTo(s2);
    }
}
