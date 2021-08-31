package WeeklyChallenge;

public class Week5 {

    public static void main(String[] args) {
        Week5 a = new Week5();
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(a.solution(word1));
        System.out.println(a.solution(word2));
        System.out.println(a.solution(word3));
        System.out.println(a.solution(word4));

    }

    public int solution(String word) {
        int answer = 0;
        int wordNum = 781;//625 + 125 + 25 + 5 + 1
        char[] c = {'A', 'E', 'I', 'O', 'U'};

        for (int i=0; i<word.length(); i++) {
            for (int j=0; j<5; j++) {
                if (c[j] == word.charAt(i)) {
                    answer += 1 + j * wordNum;
                }
            }
            wordNum = (wordNum-1) / 5;
        }
        return answer;
    }


//    public int solution(String word) {
//        int answer = 0, per = 3905;
//        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
//        return answer;
//    }
}
