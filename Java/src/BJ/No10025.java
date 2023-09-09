package BJ;
// 게으른 백곰
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] ice = new long[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] += g;
        }

        long sum = 0;
        long result = 0;
        for (int i = 0; i <= Math.min(1000000, 2 * K); i++) {
            sum += ice[i];
        }
        result = sum;

        for (int left = 1, right = 2 * K + 1; right <= 1000000; left++, right++) {
            sum -= ice[left - 1];
            sum += ice[right];
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
