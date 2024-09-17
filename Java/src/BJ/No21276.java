package BJ;
// 계보 복원가 호석
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class No21276 {

    static int N, M;
    static Map<String, Integer> nameToIndex = new HashMap<>();
    static String[] indexToName;
    static List<Integer>[] adj;
    static int[] indegree;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        indexToName = new String[N];
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            nameToIndex.put(name, i);
            indexToName[i] = name;
        }

        M = sc.nextInt();
        adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        indegree = new int[N];
        for (int i = 0; i < M; i++) {
            String X = sc.next();
            String Y = sc.next();
            int Xidx = nameToIndex.get(X);
            int Yidx = nameToIndex.get(Y);
            adj[Yidx].add(Xidx);
            indegree[Xidx]++;
        }

        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(a -> indexToName[a]));
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        parent = new int[N];
        Arrays.fill(parent, -1);
        depth = new int[N];

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : adj[u]) {
                indegree[v]--;
                if (depth[v] < depth[u] + 1) {
                    depth[v] = depth[u] + 1;
                    parent[v] = u;
                } else if (depth[v] == depth[u] + 1) {
                    if (indexToName[u].compareTo(indexToName[parent[v]]) < 0) {
                        parent[v] = u;
                    }
                }
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                roots.add(i);
            }
        }

        List<Integer>[] children = new List[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            }
        }

        System.out.println(roots.size());
        List<String> rootNames = new ArrayList<>();
        for (int idx : roots) {
            rootNames.add(indexToName[idx]);
        }
        Collections.sort(rootNames);
        for (String name : rootNames) {
            System.out.print(name + " ");
        }
        System.out.println();

        List<String> allNames = new ArrayList<>(Arrays.asList(indexToName));
        Collections.sort(allNames);
        for (String name : allNames) {
            int idx = nameToIndex.get(name);
            List<String> childrenNames = new ArrayList<>();
            for (int childIdx : children[idx]) {
                childrenNames.add(indexToName[childIdx]);
            }
            Collections.sort(childrenNames);
            System.out.print(name + " " + childrenNames.size());
            for (String childName : childrenNames) {
                System.out.print(" " + childName);
            }
            System.out.println();
        }
    }
}
