package org.programers.algorismKit.hash;

import java.util.Arrays;

/*전화번호 목록

 * */
public class Test42577 {
    public static void main(String[] args) {
        String[] str = {"119", "97674223", "1195524421"};
        System.out.println(solution(str));
    }
    static public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) answer = false;
        }
        return answer;
    }
}
