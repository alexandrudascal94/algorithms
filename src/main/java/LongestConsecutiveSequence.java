import java.util.HashSet;

public class LongestConsecutiveSequence {
    //solution
    // hashset will give ass constant lookup time.
    // every sequence will start when there is no element on the left
    // we can check all numbers if they are a start of the sequence
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int maxSeq = 1;
        for(int num: nums){
            if(!set.contains(num - 1)){
                int next = num + 1;
                int currSeq = 1;
                while(set.contains(next)){
                    currSeq++;
                    set.remove(next);
                    next++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }

        }
        return maxSeq;
    }
}
