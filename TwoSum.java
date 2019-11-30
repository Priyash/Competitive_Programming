import java.util.HashMap;

class Solution
{
    public static int[] twoSum(int[] nums, int target){
        int[] indices = new int[2];
        int first_number = 0;
        int second_number = 0;
        for(int i = 0; i < nums.length; i++){
            first_number = nums[i];
            second_number = target - first_number;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == second_number){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }

        return indices;
    }

    public static int[] twoSum_2(int[] nums, int target){
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numberMap.containsKey(target - nums[i])){
                return new int[] {numberMap.get(target - nums[i]), i};
            }
            numberMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No Two Sum Solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = twoSum(nums, target);

    }
}