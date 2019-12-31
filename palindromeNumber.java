/**
 * palindromeNumber
 */
public class palindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0)return false;
        long n = (long)x;
        long result = 0;
        while(n != 0){
            result = ((result << 1) + (result << 3)) + n % 10;
            n /=  10;
        }

        return x == result;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(404);
        System.out.println(result);
    }
}