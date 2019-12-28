/**
 * ReverseInteger
 */
public class ReverseInteger {

    static int reverse(int x) {
        int reverseInt = 0;
        int result = 0;
        while(x != 0){
            result = x % 10;
            reverseInt = reverseInt * 10  + result;
            if(reverseInt > Integer.MAX_VALUE){
                return 0;
            }
            x = x / 10;

        }
        

        return reverseInt;
    }



    public static void main(String[] args) {
        int result = reverse(1534236469);
        System.out.println(result);
    }
}