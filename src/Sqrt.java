//69. Sqrt(x)

public class Sqrt {

    public int mySqrt(int x) {

        for(int i = 1; i < x; i++){
            if(i <= x / i && (i + 1) >x/ (i + 1)  ){
                return i;
            }
        }


        return x;


    }


    public int mySqrt1(int x) {

       if(x < 2) return x;
       int left = mySqrt1(x >> 2) << 1;
       int right = left + 1;
       return (long) right * right > x? left: right;


    }
}
