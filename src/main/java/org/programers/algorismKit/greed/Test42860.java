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
        t.logger.log(Level.INFO, "answer is : {0}", solution(str2));
    }
    static public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }

        }
        return answer + move;
    }
}
