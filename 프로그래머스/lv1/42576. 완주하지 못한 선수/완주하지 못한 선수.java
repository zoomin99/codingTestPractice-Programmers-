import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Hashtable<String, Integer> participantTable = new Hashtable<String, Integer>();
        for (String str : participant) {
            if (participantTable.containsKey(str)) {
                participantTable.put(str, participantTable.get(str) + 1);
            } else
                participantTable.put(str, 1);
        }
        for (String str : completion) {
            participantTable.put(str, participantTable.get(str) - 1);
            if (participantTable.get(str) == 0)
                participantTable.remove(str);
        }

        for (String str : participantTable.keySet()) {
            answer = str;
            participantTable.remove(str);
        }

        return answer;
    }
}