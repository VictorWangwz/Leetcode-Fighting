//796. Rotate String
public class RotateString {

    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);

    }

    public static void main(String[] args) {
        String A = "bbbacddceeb" , B ="ceebbbbacdd";
        boolean rst = rotateString(A, B);
        System.out.println(rst);
    }
}
