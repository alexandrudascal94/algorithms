package bactraking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    //https://leetcode.com/problems/generate-parentheses/

    // ()(())open p == close p
    // length = n * 2
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generate(result,"",0, 0, n);
        return result;
    }

    public void generate(List<String> res, String str, int open, int close, int max){
        if(str.length() == max * 2){
            res.add(str);
            return;
        }

        //we keep track of how many parahtesis we added of one type to not exceed max;
        if(open < max){
            generate(res, str + "(", open + 1, close, max);
        }

        if(open > close){
            generate(res, str + ")", open, close + 1, max);
        }
    }
}
