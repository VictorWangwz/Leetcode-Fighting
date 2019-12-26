package quoraoa;

import java.util.HashMap;
import java.util.Map;

//Give two String a and b find the is there any possible to repalce the same frequency character
//Sol: HashMap<Character, Integer> counts
//Check if keySet() eqauls()
//HashMap<Integer, Integer> counts of countr, check if the same
public class ConstructorNames {

    public boolean check(String a, String b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.length() != b.length()){
            return false;
        }
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for(Character character: a.toCharArray()){
            mapA.put(character, mapA.getOrDefault(character, 0) + 1);
        }
        for(Character character: b.toCharArray()){
            mapB.put(character, mapB.getOrDefault(character, 0) + 1);
        }
        for(Character character: mapA.keySet()){
            if(!mapB.keySet().contains(character)){
                return false;
            }
        }

        Map<Integer, Integer> countA = new HashMap<>();
        Map<Integer, Integer> countB = new HashMap<>();
        for(Map.Entry<Character, Integer> entry: mapA.entrySet()){
            countA.put(entry.getValue(), countA.getOrDefault(entry.getValue(), 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: mapB.entrySet()){
            countB.put(entry.getValue(), countB.getOrDefault(entry.getValue(), 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: countA.entrySet()){
            if(entry.getValue() != countB.get(entry.getKey())){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String a ="babzccc", b = "abbzczz";
        ConstructorNames constructorNames = new ConstructorNames();
        boolean rst = constructorNames.check(a, b);
        System.out.println(rst);
    }
}
