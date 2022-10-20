import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        Queue <Integer>intQueue = new LinkedList<Integer>();
        intQueue.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arr[i-1])
                intQueue.add(arr[i]);
        }
        int[] answer = new int[intQueue.size()];

        for (int i = 0; !intQueue.isEmpty(); i++) {
            answer[i] = intQueue.remove();
        }
        return answer;
    }
}