import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 *
 * Example 1:
 *
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 *
 * Solution:
 * In order to form the chain we need to sort them.
 * WHen the array is sorted we can eliminate the
 * We need also to remove duplicates
 */
public class DP_MaximumLengthPairChain {

    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1) {
            return pairs.length;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> chain = new ArrayList<>();

        for (int i = 0; i < pairs.length - 1; ++i) {
            int[] current = pairs[i];
            for (int j = i + 1; j < pairs.length; j++) {
                int[] next = pairs[j];
                if (current[1] < next[0]) {
                    chain.add(current);
                    i = j;
                    break;
                }
            }
        }
        return chain.size();
    }
}
