//717. 1-bit and 2-bit Characters
public class OnebitandTwobitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int cur = 0;
        int step = bits[0] == 0? 1: 2;
        while(cur < bits.length ){
            step = bits[cur] == 0? 1: 2;
            cur += step;

        }
        return step == 1;
    }
}
