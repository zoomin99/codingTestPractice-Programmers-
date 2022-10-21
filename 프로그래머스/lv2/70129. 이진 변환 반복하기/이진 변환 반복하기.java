class Solution {
    public int[] solution(String s) {

        int countZero = 0;
        int convertCount=0;
        while (s.length() > 1) {

            int countOne = 0;
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '0') countZero++;
                else countOne++;
            }

            s = Integer.toBinaryString(countOne);
            convertCount++;
        }

        int[] answer = {convertCount, countZero};
        return answer;
    }
}