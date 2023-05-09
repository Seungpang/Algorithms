package Programmers;

import java.util.Arrays;

public class PG178871 {

    public static void main(String[] args) {
        final PG178871 pg178871 = new PG178871();
        System.out.println(Arrays.toString(pg178871.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})));
        System.out.println("mumu".equals("mumu"));
    }

    public String[] solution(String[] players, String[] callings) {
        int[] tmp = new int[players.length];


        for(int j = 0 ; j< callings.length;j++){
            for(int i = 0 ; i < players.length;i++){
                if(callings[j] == players[i]){
                    String stmp =players[i];
                    players[i] = players[i-1];
                    players[i-1] = stmp;
                }
            }
        }
        return players;
    }

//    public String[] solution(String[] players, String[] callings) {
//        Map<String, Integer> map1 = new HashMap<>();
//        Map<Integer, String> map2 = new HashMap<>();
//        int n = players.length;
//        for (int i=0; i<n; i++) {
//            map1.put(players[i], i);
//            map2.put(i, players[i]);
//        }
//
//        for (int i=0; i<callings.length; i++) {
//            String playerName = callings[i];
//            int idx = map1.get(playerName);
//            String reversedPlayer = map2.get(idx-1);
//
//            map1.put(reversedPlayer, idx);
//            map1.put(playerName, idx-1);
//
//            map2.put(idx, reversedPlayer);
//            map2.put(idx-1, playerName);
//        }
//
//        for (int i=0; i<n; i++) {
//            players[i] = map2.get(i);
//        }
//        return players;
//    }
}
