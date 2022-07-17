package trees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        getLevelOrder(root, levels, 0);
        return levels;
    }

    public void getLevelOrder(TreeNode node, List<List<Integer>> levels, int level){
        if(node == null){
            return;
        }

        if(levels.size() == level){
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            levels.add(l);
        }
        else{
            List<Integer> l = levels.get(level);
            l.add(node.val);
        }

        getLevelOrder(node.left, levels, level + 1);
        getLevelOrder(node.right, levels, level + 1);

    }
}
