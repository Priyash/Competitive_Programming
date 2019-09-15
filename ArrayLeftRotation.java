
package Competitive_Programming;

import java.util.Scanner;

/**
 * ArrayLeftRotation
 * 
 * @Author Priyash
 */
public class ArrayLeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] swap(int[] a, int index1, int index2)
    {
        int sum = a[index1] + a[index2];
        a[index1] = sum - a[index1];
        a[index2] = sum - a[index2];

        return a;
    }


    static int[] rotLeft(int[] a, int n, int d) {

        // for(int i = 0; i < d; i++)
        // {
        //     for(int j = 0; j < n - 1; j++)
        //     {
        //         ArrayLeftRotation.swap(a, j, j + 1);
        //     }
        // }

        int[] updated_arr = new int[n];
        for (int j = 0; j < n; j++) 
        {
            int updated_index = ((j + (n - d)) % n);
            updated_arr[updated_index] = a[j];
        }

        return updated_arr;
    }


    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, n, d);
    }
    
}