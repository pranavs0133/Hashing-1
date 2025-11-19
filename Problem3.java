// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
Split the string into words and ensure the count matches the pattern length.
Use two HashMaps to maintain a bijection: pattern character → word and word → pattern character.
If any mapping conflicts during iteration, return false; otherwise return true.
 */

import java.util.HashMap;

public class Problem3 {

    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        if(pattern.length() != strArray.length) {
            return false;
        }

        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();

        for(int i = 0;i<pattern.length();i++) {
            char ch = pattern.charAt(i);
            String word = strArray[i];

            if(patternMap.containsKey(ch)) {
                if(patternMap.get(ch).equals(word) == false) {
                    return false;
                }
            } else {
                patternMap.put(ch, word);
            }

            if(wordMap.containsKey(word)) {
                if(wordMap.get(word) != ch) {
                    return false;
                }
            } else {
                wordMap.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = new Problem3().wordPattern(pattern, s);

        System.out.println("Output: " + result);
   }
}
