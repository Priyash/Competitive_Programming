import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstrinNonRepetitive
 */
public class LongestSubstrinNonRepetitive {

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){return 0;}
        int strLength = s.length();
        int maxUniqueSubstringLength = 0;
        boolean [][] table = new boolean[strLength][strLength];
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < strLength; i++){
            table[i][i] = true;
        }

        for(int i = 1; i < strLength; i++){
            if(s.charAt(i - 1) != s.charAt(i) && maxUniqueSubstringLength <= 2){
                table[i - 1][i] = true;
                startIndex = i - 1;
                endIndex = i;
                maxUniqueSubstringLength = 2;
            }
        }

        for(int i = 3; i <= strLength; i++){
            for(int k = 0; k <= strLength - i; k++){
                int j = i + k - 1;
                if(s.charAt(k) != s.charAt(j) && table[k][j - 1] == true && table[k + 1][j] == true && maxUniqueSubstringLength <= i){
                    table[k][j] = true;
                    startIndex = k;
                    endIndex = j;
                    maxUniqueSubstringLength = i;
                }
            }
        }

        return  s.substring(startIndex, endIndex + 1).length();
    }

    public static int lengthOfLongestSubstring_v2(String s) {
        if(s.isEmpty()) {return 0;}
        int max = 0;
        int curr_index = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(charMap.containsKey(s.charAt(i))){
                curr_index = Math.max(charMap.get(s.charAt(i)), curr_index);
            }
            charMap.put(s.charAt(i), i + 1);
            max = Math.max(max, i - curr_index + 1);
        }
        return max;
    }




    public static void main(String[] args) {
        String s = "abba";
        int strLength = lengthOfLongestSubstring_v2(s);
        System.out.println(strLength);
    }
}