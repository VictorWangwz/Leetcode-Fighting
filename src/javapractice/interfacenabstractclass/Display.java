package javapractice.interfacenabstractclass;

public interface Display {

    int show();
    default int defaultShow(){
        return 3;
    }

    static int sshow(){
        return 0;
    }
    int x = 0;
}
