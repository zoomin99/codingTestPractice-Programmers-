import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer;
        String[] numStrArray = s.split(" ");
        Integer[] numArray = new Integer[numStrArray.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(numStrArray[i]);
        }
        Arrays.sort(numArray);

        answer = String.format("%d %d", numArray[0], numArray[numArray.length - 1]);
        return answer;
    }
}