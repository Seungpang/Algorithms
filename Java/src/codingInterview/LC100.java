package codingInterview;

public class LC100 {

    public static void main(String[] args) {
        final LC100 lc100 = new LC100();
        System.out.println(lc100.isSameTree(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(1, null, null)),
                new TreeNode(1, new TreeNode(1, null, null), new TreeNode(2, null, null))));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
