package javapractice.interfacenabstractclass;

public abstract class TvDisplay implements Display {

    abstract int ssshow();


    public static int sshow(){return 1;}
    public abstract int defaultShow();

    protected int display(){
        return 4;
    }


}
