package org.programers.algorismKit.greed;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 * 단속카메라

 * */
public class Test42884 {


    public static void main(String[] args) {
        int[][] arr = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        Logger logger = Logger.getLogger(Test42884.class.getName());
        logger.log(Level.INFO, "answer is {0}", solution(arr));
    }

    static public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int camera = Integer.MIN_VALUE;

        for (int[] arr : routes) {
            if (camera < arr[0]){
                camera = arr[1];
                answer++;
            }
        }
        return answer;
    }
}
