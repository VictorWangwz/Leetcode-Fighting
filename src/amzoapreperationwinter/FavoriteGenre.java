package amzoapreperationwinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenre {

    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String> songType = new HashMap<>();
        for(Map.Entry<String, List<String>> entry: genreMap.entrySet()){
            for(String s: entry.getValue()){
                songType.put(s, entry.getKey());
            }
        }

        Map<String, List<String>> rst = new HashMap<>();

        for(Map.Entry<String, List<String >> userSong: userMap.entrySet()){
            rst.put(userSong.getKey(), new ArrayList<>());
            List<String> songs = userSong.getValue();
            Map<String, Integer> tmp = new HashMap<>();
            int max = 0;
            for(String song: songs){
                String genre = songType.get(song);
                if(!tmp.containsKey(genre)){
                    tmp.put(genre, 1);
                }
                else{
                    tmp.put(genre, tmp.get(genre) + 1);
                }
                if(tmp.get(genre) > max){
                    max = tmp.get(genre);
                }
            }
            for(Map.Entry<String, Integer> e: tmp.entrySet()) {
                if (e.getValue() == max) {
                    rst.get(userSong.getKey()).add(e.getKey());
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        FavoriteGenre favoriteGenre = new FavoriteGenre();
        Map<String, List<String>> rst = favoriteGenre.favoritegenre(null, null);
    }
}
