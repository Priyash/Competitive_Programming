package Competitive_Programming;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * JumpingOnTheClouds
 * 
 * @author Priyash
 */
public class JumpingOnTheClouds {

    private static Scanner scanner = new Scanner(System.in);
    
    static int jumpingOnClouds(int n, int[] c) {
        int start_index = 0;
        int end_index = n - 1;
        int total_jumps = 0;
        List<Integer> thunder_cloud_pos_list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            if(c[i] == 1)
            {
                thunder_cloud_pos_list.add(i);
            }
        }

        int thunder_cloud_list_size = thunder_cloud_pos_list.size();
        
        if(thunder_cloud_pos_list.isEmpty())
        {
            if(end_index > start_index)
            {
                total_jumps = total_jumps + (n / 2);
            }
        }

        for(int i = 0; i < thunder_cloud_list_size; i++){
            int thunder_cloud_pos = thunder_cloud_pos_list.get(i);
            
            if (thunder_cloud_list_size == 1)
            {
                if(i == thunder_cloud_list_size - 1 && thunder_cloud_list_size == 1)
                {
                    total_jumps = total_jumps + ((thunder_cloud_pos - start_index) / 2) + 1;
                    if (end_index - thunder_cloud_pos > 1) 
                    {
                        total_jumps = total_jumps + ((end_index - thunder_cloud_pos) / 2);
                    }
                }
            }
            else
            {
                if (i == start_index)
                {
                    if (thunder_cloud_pos - start_index == 1)
                    {
                        total_jumps = total_jumps + 1;
                    } 
                    else
                    {
                        total_jumps = total_jumps + ((thunder_cloud_pos - start_index) / 2) + 1;
                    }
                }
                else 
                {
                    int thunder_cloud_prev_pos = thunder_cloud_pos_list.get(i - 1);
                    if (thunder_cloud_pos - thunder_cloud_prev_pos - 1 == 1) 
                    {
                        total_jumps = total_jumps + 1;
                    } 
                    else 
                    {
                        total_jumps = total_jumps + ((thunder_cloud_pos - thunder_cloud_prev_pos - 1) / 2) + 1;
                    }
                }

                if(i == thunder_cloud_list_size - 1)
                {
                    if (end_index - thunder_cloud_pos > 1)
                    {
                        total_jumps = total_jumps + ((end_index - thunder_cloud_pos) / 2);
                    }
                } 
            }
        }

        return total_jumps;
    }


    public static void main(String[] args) {
        
        try {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                arr[i] = arItem;
            }

            int result = jumpingOnClouds(n, arr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}