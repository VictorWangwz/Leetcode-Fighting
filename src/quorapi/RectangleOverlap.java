package quorapi;
//836. Rectangle Overlap
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int l = Math.max(rec1[0], rec2[0]), r = Math.min(rec1[2], rec2[2]),
                t = Math.min(rec1[3], rec2[3]), b = Math.max(rec1[1], rec2[1]);
        return l < r && b < t;
    }
}
