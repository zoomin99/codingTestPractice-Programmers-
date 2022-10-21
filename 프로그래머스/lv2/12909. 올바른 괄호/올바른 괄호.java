class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int openCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                openCount++;
            else if (ch==')')
                openCount--;

            if(openCount<0)
                return false;
        }

        if(openCount==0)
            answer = true;
        else
            answer = false;


        return answer;
    }
}