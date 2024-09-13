package org.programers.algorismKit.greed;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
* 큰 수 만들기
https://school.programmers.co.kr/learn/courses/30/lessons/42883
*
 number	        k	        return
"1924"	        2	        "94"
"1231234"	    3	        "3234"
"4177252841"	4	        "775841"
 * */
public class Test42883 {
    Logger logger = Logger.getLogger(getClass().getName());

    public static void main(String[] args) {
        Test42860 t = new Test42860();
        String str1 = "1924";
        t.logger.log(Level.INFO, "answer is : {0} ", solution(str1, 2));
    }
    static public String solution(String number, int k) {
        String answer = "";
        int idx =0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length() - k; i++) {
            char max = 0;
            for(int j = idx; j <= i + k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }

}

