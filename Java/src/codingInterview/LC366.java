package codingInterview;

import java.util.ArrayList;
import java.util.List;


public class LC366 {

    private int[] nums;

    public static void main(String[] args) {
        final LC366 lc366 = new LC366();
        //System.out.println(lc366.findLeaves(new TreeNode(1, null, null)));

        System.out.println(lc366.findLeaves(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, null, null))));
    }

    List<List<Integer>> result;

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.result = new ArrayList<>();
        getHeight(root);
        return this.result;
    }

    private int getHeight(final TreeNode root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        if (this.result.size() == currHeight) {
            this.result.add(new ArrayList<>());
        }
        this.result.get(currHeight).add(root.val);

        return currHeight;
    }
}
