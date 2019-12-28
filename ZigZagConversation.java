import java.util.Arrays;

/**
 * ZigZagConversation
 */
public class ZigZagConversation {

    
    public static String convert(String s, int numRows) {
        int numCols = (s.length() / 2) + (s.length() % 2);
        if (numRows == 1)
            return s;
        String[][] stringData = new String[numRows][numCols];
        int currCol = 0;
        int currRow = 0;
        int charIndex = 0;
        StringBuilder builder = new StringBuilder();
        // PAYPALISHIRING
        for (int i = 0; i < s.length(); i++) {
            if (charIndex == s.length()) {
                break;
            }
            stringData[currRow][currCol] = Character.toString(s.charAt(charIndex));
            currRow++;
            charIndex++;
            if (currRow == numRows) {
                currRow = numRows - 1;
                while (currRow != 0 && currRow < numRows && currCol < numCols && charIndex < s.length()) {
                    currRow--;
                    currCol++;
                    stringData[currRow][currCol] = Character.toString(s.charAt(charIndex));
                    charIndex++;
                }
                currRow++;

            }

        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (stringData[i][j] != null) {
                    builder.append(stringData[i][j]);
                }
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);
    }
}