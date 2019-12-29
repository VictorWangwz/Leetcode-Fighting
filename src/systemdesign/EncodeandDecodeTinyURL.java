package systemdesign;

import java.util.HashMap;
import java.util.Map;

//535. Encode and Decode TinyURL
public class EncodeandDecodeTinyURL {
    int lastIdx = 0;
    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String url = "http://tinyurl.com/" + lastIdx;;
        map.put(lastIdx++, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = Integer.valueOf(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(idx);
    }
}
