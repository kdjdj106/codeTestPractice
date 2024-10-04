package org.programers.algorismKit.DFS_BFS;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * */
public class Test43162 {
    static boolean visit[];

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Logger logger = Logger.getLogger(Test43162.class.getName());
        logger.log(Level.INFO, "answer is {0}", solution(3, computers));
    }


    static public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];


        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                answer++;
                DFS(i, computers, n);
            }
        }

        return answer;
    } // End of main

    static void DFS(int i, int computers[][], int n) {
        visit[i] = true;

        for (int j = 0; j < n; j++) {
            if (visit[j] == false && computers[i][j] == 1) {
                DFS(j, computers, n);
            }
        }

    }
}
