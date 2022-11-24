import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class PrintRequest {
        int priority;
        int index;

        public PrintRequest(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<PrintRequest> orderList = new LinkedList<>();
        int index = 0, answer = 0, maxPriority = 0;
        for (int priority : priorities) {
            orderList.add(new PrintRequest(priority, index++));
        }
        maxPriority = calcMax(orderList);

        while (true) {
            if (orderList.element().priority >= maxPriority) {
                answer++;
                int currentIndex = orderList.remove().index;

                if (currentIndex == location)
                    break;

                maxPriority = calcMax(orderList);
            } else {
                orderList.add(orderList.remove());
            }
        }

        return answer;
    }

    public int calcMax(Queue<PrintRequest> printRequests) {
        int maxPriority = 0;
        for (PrintRequest printRequest : printRequests) {
            if (printRequest.priority > maxPriority) {
                maxPriority = printRequest.priority;
            }
        }
        return maxPriority;
    }
}