package company.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * Implement the Solution class:
 *
 * Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the
 * given shortUrl was encoded by the same object.
 */
public class EncodeAndDecodeTinyURL {
    Map<String, String> map = new HashMap<>();
    int count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        String generatedString = new String(array.toString());
        map.put(generatedString, longUrl);
        System.out.println("http://tinyurl.com/" + generatedString);
        return "http://tinyurl.com/" + generatedString;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
