


package Competitive_Programming;

import java.util.Scanner;

/**
 * RepetitiveString
 */
public class RepetitiveString {

    private static final Scanner scanner = new Scanner(System.in);
    private static final char A = 'a';


    static long get_a_count(String s, long n)
    {   
        long a_count = 0;
        char[] char_of_string = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (char_of_string[i] == RepetitiveString.A) {
                a_count = a_count + 1;
            }
        }
        return a_count;
    }

    static long repeatedString(String s, long n) 
    {
        long string_length = s.length();
        long a_count = 0;
        long remaining_a_count = 0;
        long no_of_repeated_char_a = 0;
        long no_of_repeated_char_a_mod = 0;
        long remaining_no_of_char_length = 0;
        long total_no_of_repetition_of_char_a = 0;

        no_of_repeated_char_a = n / string_length;
        no_of_repeated_char_a_mod = n % string_length;
        a_count = RepetitiveString.get_a_count(s, s.length());

        if(no_of_repeated_char_a_mod != 0)
        {
            remaining_no_of_char_length = no_of_repeated_char_a_mod;
            remaining_a_count = RepetitiveString.get_a_count(s, remaining_no_of_char_length);
        }
        else if(no_of_repeated_char_a_mod == 0)
        {
            remaining_a_count = 0;
        }

        total_no_of_repetition_of_char_a = (a_count * no_of_repeated_char_a) + remaining_a_count;

        return total_no_of_repetition_of_char_a;
    }






    public static void main(String[] args) {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
    }
}