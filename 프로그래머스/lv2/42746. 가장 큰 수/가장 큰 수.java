import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] numbersToString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersToString[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numbersToString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });
        String answer = numbersToString[0];
        if (!(answer.equals("0"))) {
            for (int i = 1; i < numbersToString.length; i++) {
                answer += numbersToString[i];
            }
        }
        return answer;
    }
}