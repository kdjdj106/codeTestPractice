package org.programers.algorismKit.greed;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/42885
* 구명보트
*
[70, 50, 80, 50]	100	3
[70, 80, 50]	100	3
* */
public class Test42885 {
    Logger logger = Logger.getLogger(getClass().getName());
    public static void main(String[] args) {
        Test42885 test = new Test42885();
        int[] arr= {70, 80, 50};
        test.logger.log(Level.INFO, "answer is : {0} ", solution(arr, 100));
    }
    static  public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;

        Arrays.sort(people);
        for (int i = people.length-1; i >= index ; i--) {
            if (people[index] + people[i] <= limit) {
                answer++;
                index++;
            }
            else answer++;
        }
        return answer;
    }
}
