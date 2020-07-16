package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_BFS a = new MaximumDepthOfBinaryTree_BFS();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(8);
        node.left.left.left = new TreeNode(7);

        System.out.println("val: "+a.bfs(node));
    }

    public int bfs(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
