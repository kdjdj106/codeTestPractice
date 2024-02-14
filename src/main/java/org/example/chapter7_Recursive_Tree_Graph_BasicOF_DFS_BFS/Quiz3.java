package org.example.chapter7_Recursive_Tree_Graph_BasicOF_DFS_BFS;

/*
팩토리얼
        자연수 N이입력되면  N! 를구하는프로그램을 작성하세요.
        예를 들어
        5! = 5*4*3*2*1=120입니다
        ▣ 입력설명
        첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
        ▣ 출력설명
        첫 번째 줄에 팩토리얼 N값을출력합니다
        ▣ 입력예제 1
        5
        ▣ 출력예제 1
        120
*/


import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(DFS(n));
    }

    private static int DFS(int n) {
        if (n ==1) return 1;
        return n* DFS(n-1);
    }
}
