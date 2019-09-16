/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 inorder : left self right
 preorder : self left right
 postorder : left righy
 */
class Solution {
	List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret = new ArrayList<Integer>();
        traverse(root);
        return ret;
    }
    public void traverse(TreeNode self) {
    	if(self==null) return;
    	traverse(self.left);
    	ret.add(self.val);
    	travers(self.right);
    }
}