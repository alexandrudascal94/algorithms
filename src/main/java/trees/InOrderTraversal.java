package trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

// In order traversal: left, root, right;
// Keep in mind that the recursive call will go till the return and build up the method calls stack,
// When it hits return will pop each element.

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        getInorderList(root, inorderList);
        return inorderList;
    }

    private void getInorderList(TreeNode node, ArrayList<Integer> inorderList){
        if(node == null) {
            return;
        }

        getInorderList(node.left, inorderList);
        inorderList.add(node.val);
        getInorderList(node.right, inorderList);
    }
}
