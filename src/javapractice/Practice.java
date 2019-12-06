package javapractice;

public class Practice {
    int x;

    public Practice(int x){
        System.out.println(1);
        this.x = x;
    }
    public Practice(){
        System.out.println(2);
    }

    public void test(){
        Outter.Inner i = new Outter().new Inner();
    }
    public int print(){
        return 100;
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        practice.test();
    }
}
