import java.util.HashSet;

public class SlidingWindow_MaximumErasureValue {
    // https://leetcode.com/problems/maximum-erasure-value/
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0, maxScore = 0, currentScore = 0;

        HashSet<Integer> subArray = new HashSet<Integer>();

        while(i < nums.length){
            if(subArray.contains(nums[i])){
                subArray.remove(nums[j]);
                currentScore-=nums[j];
                j++;
            }else{
                currentScore+=nums[i];
                subArray.add(nums[i]);
                i++;
            }
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}
