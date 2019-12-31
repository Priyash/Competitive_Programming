import java.util.List;
import java.util.ArrayList;

/**
 * detectDuplicateFromSortedArray
 */
public class detectDuplicateFromSortedArray {

    public static int[] getDuplicates(int[] nums){
        List<Integer> dupList = new ArrayList<>();
        int index = 1;
        for(int j = 0; j < nums.length - 1; j++){
            if(nums[j] != nums[j + 1]){
               nums[index] = nums[j + 1];
               index++;
            }
        }

        return nums;
    }

    public static void getDuplicatesFromUnsortedArray(int[] nums){
        boolean [] count = new boolean[2*nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if(count[nums[i]] == true){
                System.out.println(nums[i]);
            }else{
                count[nums[i]] = true;
            }
        }

    }



    public static void main(String[] args) {
        int[] nums = new int[]{8,2,8};
        getDuplicatesFromUnsortedArray(nums);
        //System.out.println(updatedNums);
    }
}