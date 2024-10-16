package BJ;
// 폴더 정리 (large)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class No22861 {
    static int N, M, K, Q, cnt = 0;
    static final int FILE = 0, FOLDER = 1;
    static Map<String, HashSet<String>> haveFiles = new HashMap<>();
    static Map<String, HashSet<String>> haveFolders = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String parentFolder = st.nextToken();
            String name = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());
            add(parentFolder, name, isFolder);
        }

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            String[] folderA = st.nextToken().split("/");
            String[] folderB = st.nextToken().split("/");
            move(folderA, folderB);
        }

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String[] folders = st.nextToken().split("/");
            find(folders);
        }

        System.out.print(sb);
    }

    private static void add(String parentFolder, String name, int isFolder) {
        if (isFolder == FOLDER) {
            haveFolders.putIfAbsent(parentFolder, new HashSet<>());
            haveFolders.get(parentFolder).add(name);
        } else if (isFolder == FILE) {
            haveFiles.putIfAbsent(parentFolder, new HashSet<>());
            haveFiles.get(parentFolder).add(name);
        }
    }

    private static void move(String[] folderA, String[] folderB) {
        String target = folderA[folderA.length - 1];
        String dest = folderB[folderB.length - 1];

        if (haveFolders.containsKey(target)) {
            haveFolders.putIfAbsent(dest, new HashSet<>());
            haveFolders.get(dest).addAll(haveFolders.get(target));
            haveFolders.remove(target);
        }

        if (haveFiles.containsKey(target)) {
            haveFiles.putIfAbsent(dest, new HashSet<>());
            haveFiles.get(dest).addAll(haveFiles.get(target));
            haveFiles.remove(target);
        }

        String parent = folderA[folderA.length - 2];
        haveFolders.get(parent).remove(target);
    }

    private static void find(String[] folders) {
        cnt = 0;
        set = new HashSet<>();
        String target = folders[folders.length - 1];
        findFolderAndFile(target);
        sb.append(set.size()).append(" ").append(cnt).append("\n");
    }

    private static void findFolderAndFile(String target) {
        if (haveFolders.containsKey(target)) {
            for (String nextFolder : haveFolders.get(target)) {
                findFolderAndFile(nextFolder);
            }
        }
        if (haveFiles.containsKey(target)) {
            for (String file : haveFiles.get(target)) {
                set.add(file);
                cnt++;
            }
        }
    }
}
