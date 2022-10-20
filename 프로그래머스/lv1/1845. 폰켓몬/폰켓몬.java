import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> pocketMonSet = new HashSet<Integer>();

        for (int num : nums)
            pocketMonSet.add(num);

        if (pocketMonSet.size() < nums.length / 2)
            answer = pocketMonSet.size();

        else
            answer = nums.length / 2;
        return answer;
    }
}