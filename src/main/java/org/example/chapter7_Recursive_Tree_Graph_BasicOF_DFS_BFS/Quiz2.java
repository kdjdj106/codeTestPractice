package org.example.chapter7_Recursive_Tree_Graph_BasicOF_DFS_BFS;

/*
재귀함수를 이용한 이진수 출력
        2진수 N이입력되면 10진수로변환하여 출력하는 프로그램을 작성하세요 단 재귀함수를 이용
        해서 출력해야 합니다.
        ▣ 입력설명
        첫 번째 줄에 10진수 N(1<=N<=1,000) 이 주어집니다
        ▣ 출력설명
        첫 번째 줄에 이진수를 출력하세요.
        ▣ 입력예제 1
        11
        ▣ 출력예제 1
        1011
*/

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        DFS(n);

    }

    private static void DFS(int n) {
        if (n ==0) return;
        DFS(n/2);
        System.out.print(n%2);
    }
}
