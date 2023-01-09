package codingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {

    public static void main(String[] args) {
        final LC144 lc144 = new LC144();
        System.out.println(
                lc144.preorderTraversal1(new TreeNode(1, null,new TreeNode(2, new TreeNode(3, null, null), null))));
    }

    private List<Integer> answer = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        dfs(root);
        return answer;
    }

    private void dfs(final TreeNode root) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if (currNode != null) {
                answer.add(currNode.val);
                stack.push(currNode.right);
                stack.push(currNode.left);
            }
        }
        return answer;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {

    }
}
