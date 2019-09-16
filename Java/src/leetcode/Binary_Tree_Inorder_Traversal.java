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
<<<<<<< HEAD
 postorder : left right self
=======
 postorder : left righy
>>>>>>> 778f3664a4f8d2ec4d6980a8461481820c0b3e6b
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