package codingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator2 {

    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        this.stack = new Stack<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = this.stack.pop();

        if (node.right != null) {
            inorder(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
