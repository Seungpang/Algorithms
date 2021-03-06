package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses a = new GenerateParentheses();
        System.out.println(a.generateParenthesis_dfs(3));
    }

    public List<String> generateParenthesis_dfs(int n){
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n,"");
        return result;
    }

    private void dfs(List<String> result, String str, int left, int right, String str1){
        if(left < 0 || left > right)
            return;

        if(left==0 && right==0){
            result.add(str);
            return;
        }
        dfs(result, str+'(',left-1,right,str1+"+");
        dfs(result, str+')',left, right-1,str1+"-");
    }
}
