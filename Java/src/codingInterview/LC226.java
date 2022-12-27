package codingInterview;

public class LC226 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = root.right;
        root.right = root.left;
        return root;
    }
}
