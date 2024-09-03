package org.programers.algorismKit.greed;

import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42862
체육복
* */
public class Test42862 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }

    static public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
