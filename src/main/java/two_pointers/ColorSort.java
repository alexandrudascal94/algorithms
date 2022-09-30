package two_pointers;

public class ColorSort {
    // [2,0,2,1,1,0]
    // start = 0, end = length - 1;
    // iterate, if 0 we swap with start and start++
    // else if 2 swap with end and end--
    // move the index
    public void sortColors(int[] nums) {

        int i = 0, start = 0, end = nums.length - 1;

        while(i <= end && start < end){
            int current = nums[i];
            if(current == 0){
                nums[i] = nums[start];
                nums[start] = 0;
                i++;
                start++;
            }else if(current == 2){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }
            else{
                i++;
            }
        }
    }
}
