package codingInterview;

public class LC235 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;
        int parentValue = root.val;

        if (pValue < parentValue && qValue < parentValue) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (pValue > parentValue && qValue > parentValue) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;
        TreeNode node = root;

        while (node != null) {
            int parentValue = node.val;
            if (pValue < parentValue && qValue < parentValue) {
                node = node.left;
            } else if (pValue > parentValue && qValue > parentValue) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
}
