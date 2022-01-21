public class TwoPointers_ContainerWithMostWater {

    public int maxArea(int[] height) {
        // height[i] and heigth[j]
        // Area = (j - i) * min(h[i], h[j]);
        // max length is when we start from both sides  i = 0, j = lenght
        // when we iterate we want to find the next maximum thats why we move from the side that is minimum

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
