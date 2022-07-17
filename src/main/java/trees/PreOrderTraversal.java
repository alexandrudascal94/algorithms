package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        getPreorderList(root, result);
        return result;
    }

    private void getPreorderList(TreeNode node, ArrayList<Integer> list){
        if(node == null) {
            return;
        }
        list.add(node.val);

        getPreorderList(node.left, list);
        getPreorderList(node.right, list);
    }

    public List<Integer> preorderTraversalWhile(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;

        while(currentNode != null){
            result.add(currentNode.val);
            if(currentNode.right != null){
                stack.add(currentNode.right);
            }
            if(currentNode.left != null){
                stack.add(currentNode.left);
            }
            currentNode = stack.poll();
        }

        return result;
    }
}
