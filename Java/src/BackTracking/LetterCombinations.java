package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations a = new LetterCombinations();
        System.out.println(a.solution("23"));
    }

    public List<String> solution(String digits){
        String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length()==0)
            return result;

        result.add("");
        for(int i=0; i<digits.length(); i++){
            result = combine(result, digitletter[digits.charAt(i) - '0']);
        }
        return result;
    }
    private List<String> combine(List<String> firstList, String digit){
        List<String> result = new ArrayList<>();
        for(int i=0; i<digit.length(); i++){
            for(String firstStr : firstList){
                result.add(firstStr + digit.charAt(i));
            }
        }
        return result;
    }
}
