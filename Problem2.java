// Time Complexity : O(N)
// Space Complexity : O(1) ~ because both array will have only 127 characters at most, hence constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
I maintained two map, one for s -> t mapping and the other for t -> s mapping.
I would check if s -> t mapping exists, if it exists, then if the character is not the same return false.
I would check if t -> s mapping exists, if it exists, then if the character is not the same return false.
 */

public class Problem2 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sMap = new char[127];
        char[] tMap = new char[127];

        for(int i = 0;i<s.length();i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sMap[sChar- ' '] != 0) {
                if(sMap[sChar - ' '] != tChar) {
                    return false;
                }
            } else {
                sMap[sChar - ' '] = tChar;
            }

            if(tMap[tChar - ' '] != 0) {
                if(tMap[tChar - ' '] != sChar) {
                    return false;
                }
            } else {
                tMap[tChar - ' '] = sChar;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem2 sol = new Problem2();

        String s = "egg";
        String t = "add";

        boolean result = sol.isIsomorphic(s, t);
        System.out.println("Result = " + result);
    }
}
