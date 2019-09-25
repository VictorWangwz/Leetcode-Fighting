//165. Compare Version Numbers


public class CompareVersionNumber {

    public static int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return 0;
        }
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int v1Len = version1s.length;
        int v2Len = version2s.length;
        int len = v1Len > v2Len? v1Len: v2Len;
        for( int i = 0; i < len; i++){
            int v1, v2;
            if( i >= v1Len && i < v2Len){
                v1 = 0;
            }
            else {
                v1 = Integer.parseInt(version1s[i]);
            }
            if( i >= v2Len && i < v1Len){
                v2 = 0;
            }else {
                v2 = Integer.parseInt(version2s[i]);
            }

            if( v1 == v2){
                continue;
            }
            else {
                return v1 > v2? 1: -1;
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0";
        int rst = compareVersion(version1, version2);
        System.out.println(rst);
    }
}
