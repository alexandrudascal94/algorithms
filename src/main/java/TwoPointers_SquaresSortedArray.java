public class TwoPointers_SquaresSortedArray {
    // https://leetcode.com/problems/squares-of-a-sorted-array/

    private static int[] getSquares(int[] numbers) {
        int[] result = new int[numbers.length];
        int k = 0;
        int i = numbers.length - 1;
        int insertP = i;

        while (k < i){
            if((numbers[k] * -1) > numbers[i]){
                result[insertP] = numbers[k] * numbers[k];
                k++;
            }
            else{
                result[insertP] = numbers[i] * numbers[i];
                i--;
            }
            insertP--;
        }
        return result;
    }

}
