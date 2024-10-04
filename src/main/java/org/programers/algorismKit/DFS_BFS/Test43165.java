package org.programers.algorismKit.DFS_BFS;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/43165
* 타겟넘버
* */
public class Test43165 {
    static int answer = 0;
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        Logger logger = Logger.getLogger(Test43165.class.getName());
        logger.log(Level.INFO, "answer is {0}", solution(arr, 3));
        answer =0;
        arr =new int[]{4, 1, 2, 1};
        logger.log(Level.INFO, "answer is {0}", solution(arr, 4));
    }
    static public int solution(int[] numbers, int target) {

        dfs(0, numbers, target, 0);
        return answer;
    }
    static void dfs(int L, int[] numbers, int target, int sum){
        if (L == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(L + 1, numbers, target, sum + numbers[L]);
        dfs(L + 1, numbers, target, sum - numbers[L]);
    }
}
