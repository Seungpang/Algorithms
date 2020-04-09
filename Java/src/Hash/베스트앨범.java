package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {
    public static void main(String[] args) {
        베스트앨범 sol = new 베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(sol.solution(genres, plays));

    }

    public int[] solution(String[] genres, int[] plays) {
        Song[] songs = new Song[genres.length];
        HashMap<String, Genre> map = new HashMap<>();
        for(int i=0 ; i<genres.length ; i++){
            String genName = genres[i];
            int play = plays[i];
            Song s = new Song(i, play);
            if(!map.containsKey(genName)){
                map.put(genName, new Genre(genName));
            }
            Genre genre = map.get(genName);
            genre.songs.add(s);
            genre.total += play;
        }
        Object[] tmp = map.values().toArray();
        Genre[] gs = new Genre[tmp.length];

        for(int i=0 ; i<tmp.length ; i++){
            gs[i] = (Genre)tmp[i];
        }

        Arrays.sort(gs);
        ArrayList<Integer> ans = new ArrayList<>();

        for(Genre gg : gs){
            ArrayList<Song> ss = gg.songs;
            Collections.sort(ss);
            for(int i=0 ; i<(2 < ss.size() ? 2 : ss.size()); i++){
                ans.add(ss.get(i).idx);
            }
        }

        Object[] aa = ans.toArray();
        int[] bb = new int[aa.length];
        for(int i=0 ; i<aa.length ; i++) {
            bb[i] = (int)aa[i];
        }
        return bb;
    }
}
class Genre implements Comparable<Genre>{
    int total;
    String name;
    ArrayList<Song> songs;
    Genre(String name){
        this.name = name;
        songs = new ArrayList();
        this.total = 0;
    }
    @Override
    public int compareTo(Genre o){
        return o.total - this.total;
    }
}
class Song implements Comparable<Song>{
    int idx;
    int play;
    Song(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
    @Override
    public int compareTo(Song o){
        if(this.play == o.play){
            return this.idx - o.idx;
        }else{
            return o.play - this.play;
        }
    }
}
