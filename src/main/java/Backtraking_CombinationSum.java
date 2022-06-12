import java.util.ArrayList;
import java.util.List;

public class Backtraking_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        combine(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    public void combine(List<List<Integer>> result, List<Integer> cur,
                        int[] candidates, int target, int i){
        int sum = sum(cur);
        if( sum > target || i >= candidates.length){
            return;
        }
        if(sum == target){
            result.add(new ArrayList(cur));
            return;
        }

        for(int j = i; i < candidates.length; i++){
            cur.add(candidates[j]);
            combine(result, cur, candidates, target, j++);
            cur.remove(cur.size() - 1);
        }
    }

    public int sum(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
