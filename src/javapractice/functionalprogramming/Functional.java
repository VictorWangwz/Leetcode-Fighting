package javapractice.functionalprogramming;

public class Functional {

    String name ;

    public String toString(String s){
        return s;
    }

    Functional(String name){
        this.name = name;
    }


    public String f(){
        return "unbound reference";
    }
}
