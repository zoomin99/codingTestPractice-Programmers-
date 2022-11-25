import java.util.Stack;

class Solution {
    /*
    이 문제에서 중요한건 일단 자기 바로 뒤에랑만 비교해서 작지 않으면
    그냥 스택에 먼저 넣자는거
    자기 뒤에랑 비교해서 작은 순간 이제부터 그 작은애랑 스택에 있는애랑 계속 도장깨기해서
    어느순간에서부터 떨어진것인지를 알아낸다.
     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //일단 0번째는 비교할 앞에가 없으니까 먼저 넣고 시작

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            //이제 도장깨기가 끝났으면 현재 i꺼도 넣어줘서 다시 똑같은 로직 반복
            stack.push(i);
        }

        //여기까지 안걸렸다면 끝날때까지 가격이 안떨어졌다 즉 자기의 역순 번호가 답
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.pop() - 1;
        }

        return answer;
    }
}