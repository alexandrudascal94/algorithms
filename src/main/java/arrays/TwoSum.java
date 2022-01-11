package arrays;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    //Complexity N(n2)
    public int[] twoSum(int[] nums, int target) {
        int[] indeces = new int[2];
        var a = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                if(nums[j] + nums[i] == target){
                    indeces[0] = i;
                    indeces[1] = j;
                }
            }
        }
        return indeces;
    }
    // Complexity O(n)
    public int[] twoSum2(int[] nums, int target) {
        int[] indeces = new int[2];
        // number, indices
        // by accessing the map we find the compliment
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                nums[0] = i;
                nums[1] = map.get(target - nums[i]);
            }
            else{
                map.put(nums[i], i);
            }
        }
        return indeces;
    }


}
