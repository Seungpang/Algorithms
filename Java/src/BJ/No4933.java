package BJ;
// 뉴턴의 사과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No4933 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            TreeNode tree1 = buildTree();
            TreeNode tree2 = buildTree();
            boolean result = isEquivalent(tree1, tree2);
            sb.append(result ? "true\n" : "false\n");
        }

        System.out.print(sb);
    }

    static TreeNode buildTree() throws IOException {
        st = new StringTokenizer(br.readLine());
        Stack<TreeNode> stack = new Stack<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("end")) break;

            if (token.equals("nil")) {
                stack.push(null);
            } else {
                TreeNode node = new TreeNode(token.charAt(0));
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
            System.out.println(stack);
        }

        return stack.isEmpty() ? null : stack.pop();
    }

    static boolean isEquivalent(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.value != b.value) return false;

        return (isEquivalent(a.left, b.left) && isEquivalent(a.right, b.right)) ||
                (isEquivalent(a.left, b.right) && isEquivalent(a.right, b.left));
    }

    static class TreeNode {
        char value;
        TreeNode left, right;

        TreeNode(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
