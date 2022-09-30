package two_pointers;

public class ContainerWithMostWater {

    /***
     *https://leetcode.com/problems/container-with-most-water/
     *
     *          height[i] and heigth[j]
     *          Area = (j - i) * min(h[i], h[j]);
     *         // max length is when we start from both sides  i = 0, j = lenght
     *         // when we iterate we want to find the next maximum thats why we move from the side that is minimum
     */
    public int maxArea(int[] height) {


        int i = 0, j = height.length - 1, maxArea = 0;

        while(i < j){
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if(height[i]  > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }
}
