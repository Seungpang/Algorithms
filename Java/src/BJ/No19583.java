package BJ;
// 싸이버개강총회

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startTime = convertToMinutes(st.nextToken());
        int endTime = convertToMinutes(st.nextToken());
        int streamEndTime = convertToMinutes(st.nextToken());

        Set<String> enteredMembers = new HashSet<>();
        Set<String> attendedMembers = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            int time = convertToMinutes(st.nextToken());
            String name = st.nextToken();

            if (time <= startTime) {
                enteredMembers.add(name);
            } else if (time >= endTime && time <= streamEndTime) {
                if (enteredMembers.contains(name)) {
                    attendedMembers.add(name);
                }
            }
        }

        System.out.println(attendedMembers.size());
    }

    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
