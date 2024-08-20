package BJ;
// 부품 대여장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class No21942 {

    static class Rental {
        String part;
        String member;
        LocalDateTime startTime;

        Rental(String part, String member, LocalDateTime startTime) {
            this.part = part;
            this.member = member;
            this.startTime = startTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] rentalPeriod = st.nextToken().split("/");
        int days = Integer.parseInt(rentalPeriod[0]);
        String[] time = rentalPeriod[1].split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int F = Integer.parseInt(st.nextToken());

        Duration rentalDuration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);
        Map<String, Map<String, Rental>> rentals = new HashMap<>();
        Map<String, Long> fines = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            LocalDateTime dateTime = LocalDateTime.parse(st.nextToken() + " " + st.nextToken(), formatter);
            String part = st.nextToken();
            String member = st.nextToken();

            if (!rentals.containsKey(member)) {
                rentals.put(member, new HashMap<>());
            }

            if (rentals.get(member).containsKey(part)) {
                Rental rental = rentals.get(member).get(part);
                Duration overdue = Duration.between(rental.startTime.plus(rentalDuration), dateTime);
                if (!overdue.isNegative()) {
                    long fine = overdue.toMinutes() * F;
                    fines.put(member, fines.getOrDefault(member, 0L) + fine);
                }
                rentals.get(member).remove(part);
            } else {
                rentals.get(member).put(part, new Rental(part, member, dateTime));
            }
        }

        List<Map.Entry<String, Long>> sortedFines = new ArrayList<>(fines.entrySet());
        Collections.sort(sortedFines, Map.Entry.comparingByKey());

        if (sortedFines.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Map.Entry<String, Long> entry : sortedFines) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        }
    }
}
