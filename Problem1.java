// Time Complexity : O(N . k) where k is the length of the str
// Space Complexity : O(N) + O(1) ~ O(1) for the fixed-size char[26] array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
For each string, build a 26-length frequency array to create a unique key representing its character counts.
Group strings in a HashMap where all anagrams share the same key and are stored in the same list.
Return all grouped lists as the final result.
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for(int i = 0;i<strs.length;i++) {
            String str = strs[i];
            String key = calculateKey(str);
            hmap.putIfAbsent(key, new ArrayList<>());
            hmap.get(key).add(str);
        }

        return new ArrayList<>(hmap.values());
    }


    private String calculateKey(String str) {
        char[] chArray = new char[26];
        for(int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            chArray[ch - 'a']++;
        }

        return String.valueOf(chArray);
    }
}