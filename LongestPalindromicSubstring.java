/**
 * LongestPalindromicSubstring
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s){
        if(s.isEmpty()) return "";
        boolean [][] table = new boolean[s.length()][s.length()];
        int start_index = 0;
        int end_index = 0;
        int longestStringLength = 0;
        for(int i = 0; i < s.length(); i++){
            table[i][i] = true;
        }

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i) && longestStringLength <= 2){
                table[i - 1][i] = true;
                start_index = i - 1;
                end_index = i;
                longestStringLength = 2;
            }
        }

        for(int i = 3; i <= s.length(); i++){
            for(int k = 0; k <= s.length() - i; k++){
                int j = i + k - 1;
                if(s.charAt(k) == s.charAt(j) && table[k + 1][j - 1] == true && longestStringLength <= i){
                    table[k][j] = true;
                    start_index = k;
                    end_index = j;
                    longestStringLength = i;
                }
            }
        }


        return s.substring(start_index, end_index + 1);
    }




    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }
}