package StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solution(J,S));
    }
    public static int solution(String jew, String stone) {
        Set<Character> set = new HashSet<>();
        for(char jewel : jew.toCharArray()){
            set.add(jewel);
        }

        int count=0;
        for(char stoneChar : stone.toCharArray()) {
            if(set.contains(stoneChar)){
                count++;
            }
        }
        return count;
    }
}
