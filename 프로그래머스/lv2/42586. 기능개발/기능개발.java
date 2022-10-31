import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int[] count = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = 100 - progresses[i];
        }

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] > 0) {
                progresses[i] -= speeds[i];
                count[i]++;
            }
        }

        int temp = 0;
        for (int i = 1; i < progresses.length; i++) {
            if (count[i] > count[temp]) {
                answerList.add(i - temp);
                temp = i;
            }
            if (i == progresses.length - 1) {
                answerList.add(i - temp + 1);
            }
        }

        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}