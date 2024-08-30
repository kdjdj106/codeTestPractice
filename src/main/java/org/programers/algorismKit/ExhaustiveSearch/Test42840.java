package org.programers.algorismKit.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42840
모의고사
* */
public class Test42840 {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,5};
        solution(arr);

    }
    static public int[] solution(int[] answers) {
        int[] answer = {};
        int[] first_tester = {1, 2, 3, 4, 5};
        int[] second_tester = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_tester = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first_tester[i%5]) score[0]++;
            if (answers[i] == second_tester[i%8]) score[1]++;
            if (answers[i] == third_tester[i%10]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) list.add(i+1);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
