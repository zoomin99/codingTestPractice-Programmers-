class Solution {
    public int solution(int slice, int n) {
        int count = 2;
        if (slice >= n)
            return 1;
        else {
            while (slice * count < n) {
                count++;
            }
        }
        return count;
    }
}