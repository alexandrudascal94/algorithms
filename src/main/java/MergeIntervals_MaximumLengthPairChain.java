import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/
public class MergeIntervals_MaximumLengthPairChain {

    // sort by the left
    // [1, 1, 2]
    // dynamic programing
    public int findLongestChain(int[][] pairs) {
        if(pairs.length <= 1){
            return pairs.length;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] l = new int[pairs.length];
        Arrays.fill(l, 1);
        int max = -1;

        for(int i = 1; i < pairs.length; ++i){
            for(int j = 0; j < i; j++){
                if(pairs[i][0] > pairs[j][1]){
                    l[i] = Math.max(l[j] + 1, l[i]);
                }
            }
            max = Math.max(max, l[i]);
        }
        return max;
    }
}
