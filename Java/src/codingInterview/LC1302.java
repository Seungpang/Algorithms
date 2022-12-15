package codingInterview;

import java.util.LinkedList;
import java.util.Queue;

public class LC1302 {

    public static void main(String[] args) {
        final LC1302 lc1302 = new LC1302();
        System.out.println(lc1302.deepestLeavesSum(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7, null, null), null),
                        new TreeNode(5, null, null)),
                        new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8, null, null))))
        )); //15
    }

    public int deepestLeavesSum(TreeNode root) {
        int result = 0, i;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            for (i = q.size() - 1, result = 0; i >= 0; --i) {
                TreeNode nowNode = q.poll();
                result += nowNode.val;
                if (nowNode.right != null) {
                    q.add(nowNode.right);
                }
                if (nowNode.left != null) {
                    q.add(nowNode.left);
                }
            }
        }
        return result;
    }
}
