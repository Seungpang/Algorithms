package BJ;
// 개미굴

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class No14725 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        List<List<String>> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] foods = sc.nextLine().split(" ");
            paths.add(Arrays.asList(Arrays.copyOfRange(foods, 1, foods.length)));
        }

        Node root = buildTree(paths);
        printTree(root, "");
    }

    static Node buildTree(List<List<String>> paths) {
        Node root = new Node("");
        for (List<String> path : paths) {
            Node current = root;
            for (String food : path) {
                current.children.putIfAbsent(food, new Node(food));
                current = current.children.get(food);
            }
        }
        return root;
    }

    static void printTree(Node node, String prefix) {
        if (!node.food.isEmpty()) {
            System.out.println(prefix + node.food);
        }
        for (Node child : node.children.values()) {
            printTree(child, node.food.isEmpty() ? "" : prefix + "--");
        }
    }

    static class Node {
        String food;
        Map<String, Node> children = new TreeMap<>();

        Node(String food) {
            this.food = food;
        }
    }
}
