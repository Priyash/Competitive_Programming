/**
 * removeElement
 */
public class removeElement {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[i] = nums[index];
                index++;
            }
        }

        return index;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4};
        int count = removeElement(nums, 4);
        System.out.println(count);
    }
}