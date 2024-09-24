package org.programers.algorismKit.greed;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java
섬 연결하기
* */
public class Test42861 {
    Logger logger = Logger.getLogger(getClass().getName());
    static int[] parents;
    public static void main(String[] args) {
        int[][] arr = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        Test42861 t = new Test42861();
        t.logger.log(Level.INFO, "answer is {0}", solution(4, arr));
    }
    static int find(int a){
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }
    static void union(int a, int b){
        int uNum1 = find(a);
        int uNum2 = find(b);
        if (uNum1 != uNum2){
            parents[uNum2] = uNum1;
        }
    }
    static public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }

}
