package javapractice.hashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Example extends Object{
    private String name;

    public Example(String name){
        this.name = name;
    }


    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject == this) return true;
        if(otherObject == null) return false;

        if(! (otherObject instanceof Example)){
            return super.equals(otherObject);
        }
        Example other = (Example) otherObject;
        return  other.name == this.name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }


    public static void main(String[] args) {
        Example example1 = new Example("good");
        Example example2 = new Example(("good"));
        Map<Example,String> map = new HashMap<Example, String>();
        map.put(example1, "good");
//        map.put(example2, "best");
        System.out.println(example1.equals(example2));
        System.out.println(map.get(example1));
        System.out.println(map.get(example2));
    }

}
