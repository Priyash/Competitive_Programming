

package Competitive_Programming;

import java.util.Scanner;

/**
 * HourglassSum
 * @author Priyash
 */
public class HourglassSum {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int NO_ROWS = 6;
    private static final int NO_COLS = 6;

    static int hourglassSum(int[][] arr) {
        int hourglass_max_sum = 0;

        for(int i = 0; i < HourglassSum.NO_ROWS - 2; i++)
        {
            int hourglass_unit_sum = 0;
            for(int j = 0; j < HourglassSum.NO_COLS - 2; j++)
            {
                int hourglass_unit_sum_row_first = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int hourglass_unit_sum_second_centre = arr[i + 1][j + 1];
                int hourglass_unit_sum_row_third = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                hourglass_unit_sum = hourglass_unit_sum_row_first + 
                                        hourglass_unit_sum_second_centre + 
                                        hourglass_unit_sum_row_third;
                if(i == 0 && j == 0)
                {
                    hourglass_max_sum = hourglass_unit_sum;
                }
                hourglass_max_sum = Math.max(hourglass_max_sum, hourglass_unit_sum);
            }

            
        }

        return hourglass_max_sum;
    }


    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) 
        {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) 
            {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        
    }
}