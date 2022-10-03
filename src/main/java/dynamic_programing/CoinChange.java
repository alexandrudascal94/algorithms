package dynamic_programing;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Solution.
 *
 * Dynamic Programing
 *
 * 1. Think about what means the amount. E.g. 11 = ways to change 1 and 10, 10 -> 6 and 5
 * 2. Create an array with all amounts from [0-n], where teh index represents the amount, and the value is the ways, for 0 we have by default 1 way
 * 3. For each denomination we check all amounts, if the  denom <= amount, we increase the amount with the rest ways,
 * where rest = amount - coin ( e.g. coin = 5, amount = 6, rest (1 = 6 - 5) )
 * 4. The max ways will be at position n
 *
 */
public class CoinChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if(denoms.length == 0) return -1;

        int[] ways = new int[n + 1];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        for(int denom: denoms){
            for(int amount = 0; amount < n + 1; amount++){
                // if the amount we want to build is bigger then denom
                if(amount >= denom) ways[amount]+= ways[amount - denom];
            }
        }

        return ways[n];
    }

}
