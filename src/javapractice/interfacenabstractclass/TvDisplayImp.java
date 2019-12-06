package javapractice.interfacenabstractclass;

public class TvDisplayImp extends TvDisplay implements Display2 {
    public int x = 0;

    public int ssshow(){
        return 1;
    }

    @Override
    public int show() {
        return 0;
    }
    int show(int x){return 0;}

    public static int sshow(){
        return 3;
    }

    @Override
    public int display(){
        return 6;
    }

    @Override
    public int defaultShow(){
        return 4;
    }


    public static void main(String[] args) {
        Display tvDisplay = new TvDisplayImp();
        System.out.println(Display.sshow());
        System.out.println(tvDisplay.x);

        TvDisplayImp2 tvDisplayImp2 = new TvDisplayImp2();
        Display tvDisplay2 = (Display) tvDisplayImp2;

        System.out.println(tvDisplay2);
    }
}
