import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class backtracking_Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generate(result, new ArrayList<>(), nums, 0);
        return result;
    }

    //[1,2,3]
    public void generate(List<List<Integer>> result, List<Integer> current,
                         int[] nums, int i){
        // adds the element
        result.add(new ArrayList<>(current));
        // combine the current subset with all other numbers
        // [1] -> [1,2], [1,3]
        for(int j = i; j < nums.length; j++){
            current.add(nums[j]);

            // use next integers to complete the combination
            generate(result, current, nums, j + 1);

            // backtracking
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        var a = new backtracking_Subset().subsets(new int[]{1,2,});

        for (var element :a) {
            System.out.println(element);
        }
    }
}
