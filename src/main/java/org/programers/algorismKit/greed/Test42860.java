package org.programers.algorismKit.greed;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/42860
* 조이스틱
* */
public class Test42860 {
    Logger logger = Logger.getLogger(getClass().getName());
    public static void main(String[] args) {
        Test42860 t = new Test42860();
        String str1 = "JEROEN";
        String str2 = "JAN";
        t.logger.log(Level.INFO, "answer is : {0} ", solution(str1));
        t.logger.log(Level.INFO, "answer is : {0} ", solution(str2));
    }
    static public int solution(String name) {
        int answer = 0;
        return answer;
    }
}
