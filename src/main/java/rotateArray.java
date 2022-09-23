public class rotateArray {

    public static void rotate(int[] nums, int k) {

        int completed = 0;
        int current = 0;
        while (nums.length < completed) {
            int nextIdx = current + k;
            if (nextIdx > nums.length + 1) {
                nextIdx = nextIdx % nums.length;
            }
            int nextValue = nums[nextIdx];
            nums[nextIdx] = nums[current];
            nums[current] = nextValue;
            current = nextIdx++;
            completed++;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4}, 2);
    }
}
