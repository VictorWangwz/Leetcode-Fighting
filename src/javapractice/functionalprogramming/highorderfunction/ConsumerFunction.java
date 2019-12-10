package javapractice.functionalprogramming.highorderfunction;

public class ConsumerFunction {

    public int comsume(StringComparator stringComparator, String s1, String s2){
        return stringComparator.compare(s1, s2);
    }

    public static void main(String[] args) {
        ProducerFunction producerFunction = new ProducerFunction();
        StringComparator stringComparator = producerFunction.produceStringComparator();
        ConsumerFunction consumerFunction = new ConsumerFunction();
        String s1 = "s1", s2 = "s2";
        int rst = consumerFunction.comsume(stringComparator, s1, s2);
        System.out.println(rst);
    }
}
