package javapractice.functionalprogramming.highorderfunction;

public class Closure {
    String s2 = "z";

    public StringComparator produceWithLocalParam(){
        String s1 = "a";
        return (str1, str2) -> str1.compareTo(s1) > 0 && str2.compareTo(s1) > 0? 1: -1;
    }

    public StringComparator produceWithInnerClass(){
        //s1 must be effective final, this is the same for inner class and for lambda
        String s1 = s2;
        return new StringComparator(){
            public int compare(String str1, String str2){
                return str1.compareTo(s1) > 0 && str2.compareTo(s1) > 0? 1: -1;
            }
        };
    }

    public static void main(String[] args) {
        Closure closure = new Closure();
        StringComparator stringComparator1 = closure.produceWithLocalParam();
        System.out.println(stringComparator1.compare("z", "z"));

        StringComparator stringComparator2 = closure.produceWithInnerClass();
        System.out.println(stringComparator2.compare("z", "z"));
    }


}
