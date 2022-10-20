class Solution {
    public String solution(String s) {
        s = " " + s;
        String answer = "";
        char[] chArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (chArr[i - 1] == ' ' && chArr[i] >= 'a' && chArr[i] <= 'z')
                chArr[i]-=32;

            else if (chArr[i - 1] != ' ' && chArr[i] >= 'A' && chArr[i] <= 'Z')
                chArr[i]+=32;

            sb.append(chArr[i]);
        }
        answer = sb.toString();
        return answer;
    }
}