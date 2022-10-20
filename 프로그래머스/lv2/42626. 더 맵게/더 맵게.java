import java.util.PriorityQueue;
class Solution{
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int scoville : scovilles)
            minHeap.add(scoville);

        while (minHeap.element() < K) {
            if(minHeap.size()<2)
                return -1;
            int num1 = minHeap.remove();
            int num2 = minHeap.remove();
            minHeap.add(calc(num1, num2));
            answer++;
        }

        return answer;
    }
    public int calc(int num1, int num2) {
        return num1 + (num2 * 2);
    }
}