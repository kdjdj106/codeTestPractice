package org.example.chapter8_DFS_BFS;

/*
중복순열 구하기
        1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
        하는 방법을 모두 출력합니다.
        ▣ 입력설명
        첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
        ▣ 출력설명
        첫 번째 줄에 결과를 출력합니다.
        출력순서는 사전순으로 오름차순으로 출력합니다.
        ▣ 입력예제 1
        3 2
        ▣ 출력예제 1
        1 1
        1 2
        1 3
        2 1
        2 2
        2 3
        3 1
        3 2
        3 3
*/


import java.util.Scanner;

public class QUiz4 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        DFS(0);
    }

    static void DFS(int L) {
        if (L == m) {
            for (int n : arr) System.out.print(n + " ");
            System.out.println();

        } else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }
}
