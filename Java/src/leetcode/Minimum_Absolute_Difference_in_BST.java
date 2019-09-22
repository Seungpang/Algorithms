/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Ʈ�� ��ȸ
    preorder : self left right
    inorder : left self right
    postorder : left right slef
    �����˻�Ʈ�� ���� -> inorder -> �������� ������ ��!
    */
    boolean init;
    int min;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        //self ó��
        if(!init){
            init = true;
        }else{
            min = Math.min(min, root.val-prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}