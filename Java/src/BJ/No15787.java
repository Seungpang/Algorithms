package BJ;
// 기차가 어둠을 헤치고 은하수를

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No15787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trains = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int seat = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            switch (command) {
                case 1 :
                    trains[index] |= (1 << seat); // 해당 비트 켜기
                    break;
                case 2 :
                    trains[index] &= ~(1 << seat); // 해당 비트 끄기
                    break;
                case 3 : trains[index] = (trains[index] << 1) & ((1 << 21) - 1);
                    break;
                case 4 : trains[index] = (trains[index] >> 1) & (~1);
                    break;
            }
        }

        Set<Integer> uniqueTrains = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniqueTrains.add(trains[i]);
        }
        System.out.println(uniqueTrains.size());
    }
}
