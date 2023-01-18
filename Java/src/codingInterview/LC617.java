package codingInterview;

public class LC617 {

    public static void main(String[] args) {
        final LC617 lc617 = new LC617();
        System.out.println(
                lc617.mergeTrees(new TreeNode(1, null, null), new TreeNode(1, null, new TreeNode(2, null, null))));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root1.left);
        return root1;
    }
}
