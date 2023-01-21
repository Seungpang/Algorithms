package codingInterview;

public class LC116 {

    public static void main(String[] args) {
        final LC116 lc116 = new LC116();
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftEnd = root;
        while (leftEnd.left != null) {
            Node head = leftEnd;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftEnd = leftEnd.left;
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
