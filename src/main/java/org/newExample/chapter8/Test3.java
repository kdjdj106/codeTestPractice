package org.newExample.chapter8;

import java.util.Scanner;

public class Test3 {
    static int n;
    static int SCORE;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        SCORE = sc.nextInt();
        Quiz[] arr = new Quiz[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Quiz quiz = new Quiz(a, b);
            arr[i] = quiz;
        }

        DFS(arr, 0, 0, 0);
        System.out.println(answer);

    }

    static void DFS(Quiz[] arr, int scoreSum, int timeSum, int L) {
        if (timeSum > SCORE) return;
        if (L == n) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(arr, scoreSum + arr[L].score, timeSum + arr[L].time, L+1);
            DFS(arr, scoreSum, timeSum, L+1);

        }
    }

    public static class Quiz {
        int score;
        int time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
