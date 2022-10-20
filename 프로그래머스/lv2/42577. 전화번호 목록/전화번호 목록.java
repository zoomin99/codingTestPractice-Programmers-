import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
for (int i = 1; i < phone_book.length; i++) {
            int pos = 0;
            if (phone_book[i].length() > phone_book[i - 1].length())
                pos = -1;
            else if (phone_book[i].length() < phone_book[i - 1].length())
                pos = 1;

            if (pos == 0)
                continue;
            else if (pos == 1) {
                if (phone_book[i].equals(phone_book[i - 1].substring(0, phone_book[i].length())))
                    return false;
            } else if (pos == -1) {
                if (phone_book[i - 1].equals(phone_book[i].substring(0, phone_book[i - 1].length())))
                    return false;
            }
        }
        return true;
    }
}