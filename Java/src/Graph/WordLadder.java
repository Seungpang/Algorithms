package Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);
        WordLadder a = new WordLadder();
        System.out.println(a.ladderLength_neighbor("hit", "cog", wordList));
    }

    public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList){
        if(wordList==null || !wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str, wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> neighbors(String s, List<String> wordlist){

        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordlist);

        for(int i=0; i<s.length(); i++){
            char[] chars = s.toCharArray();
            for(char ch='a'; ch <='z'; ch++){
                chars[i]=ch;
                String word = new String(chars);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }
}
