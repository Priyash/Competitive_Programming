package Competitive_Programming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * class SockMerchent
 * @author Priyash
 */

public class SockMerchant {

    private static Scanner scanner = new Scanner(System.in);
    private static int MIN_NUMER_OF_SAME_SOCKS = 2;

    static int sockMerchant(int n, int[] arr) {
        int total_no_of_pair = 0;

        HashMap<Integer, Integer> sockList = new HashMap<>();
        for (int i = 0; i < n; i++) 
        {
            int socksCount = 0;
            if(sockList.containsKey(arr[i]))
            {
                socksCount = sockList.get(arr[i]);
                socksCount = socksCount + 1;
                sockList.put(arr[i], socksCount);
            }
            else
            {
                socksCount = socksCount + 1;
                sockList.put(arr[i], socksCount);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sockList.entrySet()) {
            int total_number_of_same_socks = entry.getValue();
            if (total_number_of_same_socks >= SockMerchant.MIN_NUMER_OF_SAME_SOCKS)
            {
                total_no_of_pair += total_number_of_same_socks/2;
            }
        }

        return total_no_of_pair;
    }

    public static void main(String[] args) {

        //System.out.println("Test");
        try {
            
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++)
            {
                int arItem = Integer.parseInt(arItems[i]);
                arr[i] = arItem;
            }

        int result = sockMerchant(n, arr);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}