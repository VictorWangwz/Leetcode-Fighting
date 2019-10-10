package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//609. Find Duplicate File in System
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();
        String sep = "/";
        for(String path: paths){
            String[] segs = path.split(" ");
            String folder = segs[0];

            for(int i = 1; i < segs.length; i++){
                StringBuffer sb = new StringBuffer();
                String[] fileSegs = segs[i].split("\\(");
                String file = fileSegs[0];

                for( int j = 0; j < fileSegs[1].length() - 1; j++){
                    sb.append(fileSegs[1].substring(j, j+ 1));
                }
                StringBuffer fullPath = new StringBuffer();
                fullPath.append(folder);
                fullPath.append(sep);
                fullPath.append(file);
                List<String> tmp = map.getOrDefault(sb.toString(), new ArrayList<>());
                tmp.add(fullPath.toString());
                map.put(sb.toString(), tmp);
            }
        }
        List<List<String>> rst = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            if(e.getValue().size() > 1){
                rst.add(e.getValue());
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        FindDuplicateFileinSystem findDuplicateFileinSystem = new FindDuplicateFileinSystem();
        List<List<String>> rst = findDuplicateFileinSystem.findDuplicate(paths);
        System.out.println(rst);
    }
}
