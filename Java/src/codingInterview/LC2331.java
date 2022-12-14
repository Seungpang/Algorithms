package codingInterview;

public class LC2331 {

    public static void main(String[] args) {
        final LC2331 lc2331 = new LC2331();
        //System.out.println(lc2331.evaluateTree());
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left | right : left & right;
    }
}
