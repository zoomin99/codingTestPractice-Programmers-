import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] citationsToInteger = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(citationsToInteger, Collections.reverseOrder());

        for (int i = 0; i < citationsToInteger.length; ) {
            if (i + 1 < citationsToInteger[i]) {
                i++;
            } else {
                return i;
            }
        }
        return citationsToInteger.length;
    }
}
