package javapractice;

public class Outter {
    int a = 1;
    static int b = 1;

    public class Inner{
        int a = 0;
        private void print(){
            System.out.println(Outter.this.a);
        }
    }

    public static class StaticInner{
        int a = 0;
        int b = 0;
        private void print(){
            System.out.println(b);
        }
    }

    public Practice cont(int x, String dest) {
        return new Practice(x) {
            private int i = x;
            private String d;
            {
                d = dest;
                System.out.println(3);
            }
            @Override
            public int print(){
                return super.print() * i;
            }
        };
    }

        public void test(){
            try{
                throw new Ex1();
            }catch (Ex1 e){

            }catch (Ex0 e){

            }catch ( ArithmeticException e){

            }

            Outter.Inner i0 = new Outter.Inner();
            Outter.Inner i1 = new Inner();
            Outter.Inner i = Outter.this.new Inner();
            Outter o1 = Outter.this;
            Outter o = new Outter();
            Outter.Inner i2 = o.new Inner();
//        i.print();
//        i2.print();

        Outter.StaticInner si = new Outter.StaticInner();
        si.print();

        Practice p = cont(1, "great");
        int rst = p.print();
        System.out.println(rst);
    }

    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.test();
//        Outter o = new Outter();
//        Outter.Inner i2 = o.new Inner();
//        i2.print();



    }
}
