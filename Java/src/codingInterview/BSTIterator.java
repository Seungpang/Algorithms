package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    private List<Integer> nodesSorted;
    private int index;

    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        this.nodesSorted.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
