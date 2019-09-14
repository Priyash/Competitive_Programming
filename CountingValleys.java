package Competitive_Programming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CountingValleys
 * 
 * @author priyash
 */
public class CountingValleys {

    private static Scanner scanner = new Scanner(System.in);
    private static char UPHILL = 'U';
    private static char DOWNHILL = 'D';
    private static Boolean isValley = false;
    private static Boolean isSeaLevel = true;
    //Example Case : UDDDUDUU
    static int countingValleys(int n, String s) 
    {   
        Queue<Character> downhill_queue = new LinkedList<>();
        Queue<Character> uphill_queue = new LinkedList<>();
        int valley_count = 0;

        char[] seq_steps = new char[n + 1];
        seq_steps = s.toCharArray();

        for(int i = 0; i < s.length(); i++)
        {
            if(CountingValleys.isSeaLevel)
            {   
                if (seq_steps[i] == CountingValleys.DOWNHILL) 
                {
                    //IF HE GOES INTO THE VALLEY
                    CountingValleys.isValley = true;
                    downhill_queue.add(CountingValleys.DOWNHILL);
                } else if (seq_steps[i] == CountingValleys.UPHILL) 
                {
                    //IF HE CLIMBS THE MOUNTAIN
                    CountingValleys.isValley = false;
                    uphill_queue.add(CountingValleys.UPHILL);
                }
                CountingValleys.isSeaLevel = false;
            }
            else
            {
                if (seq_steps[i] == CountingValleys.DOWNHILL) 
                {
                    downhill_queue.add(CountingValleys.DOWNHILL);
                }
                else if(seq_steps[i] == CountingValleys.UPHILL)
                {
                    uphill_queue.add(CountingValleys.UPHILL);
                }
            }
            
            if(downhill_queue.size() == uphill_queue.size())
            {
                if(CountingValleys.isValley)
                {
                    valley_count = valley_count + 1;
                    downhill_queue.clear();
                    uphill_queue.clear();
                    CountingValleys.isSeaLevel = true;
                    CountingValleys.isValley = false;
                }
                else
                {
                    CountingValleys.isSeaLevel = true;
                    downhill_queue.clear();
                    uphill_queue.clear();
                }
            }
        }

        return valley_count;
    }



    public static void main(String[] args) {

        // System.out.println("Test");
        try {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String seq_steps = scanner.nextLine();

            int result = CountingValleys.countingValleys(n, seq_steps);
            System.out.println("Number of valleys : " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}