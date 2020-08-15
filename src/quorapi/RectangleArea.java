package quorapi;
//223. Rectangle Area
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D - B) * (C - A), area2 = (H - F) * (G - E);
        int a = Math.max(A, E), b = Math.max(B, F), c = Math.min(C, G), d = Math.min(D, H);
        int dup = 0;
        if(a < c && b < d){
            dup = (c - a) * (d - b);
        }
        return area1 + area2 -dup;
    }

    public static void main(String[] args) {

        int A = -2, B = -2, C = 2, D = 2, E = 3, F = 3, G = 4, H = 4;
        RectangleArea rectangleArea = new RectangleArea();
        int rst = rectangleArea.computeArea(A, B, C, D, E, F, G, H);
        System.out.println(rst);
    }
}
