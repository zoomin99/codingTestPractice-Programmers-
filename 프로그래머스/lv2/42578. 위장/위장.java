import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothTypeMap = new HashMap<String, Integer>();
        for (String[] cloth : clothes) {
            clothTypeMap.put(cloth[1], clothTypeMap.getOrDefault(cloth[1], 0) + 1);
        }
        Iterator<Integer> iterator = clothTypeMap.values().iterator();

        while (iterator.hasNext()) {
            answer *= iterator.next() + 1;
        }
        return answer - 1;
    }
}