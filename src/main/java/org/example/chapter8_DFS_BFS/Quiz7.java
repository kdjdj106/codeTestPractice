package org.example.chapter8_DFS_BFS;

/*
조합의 경우수(메모이제이션)
            
         로 계산합니다. 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여
        재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
              
        ▣ 입력설명
        첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
        ▣ 출력설명
        첫째 줄에 조합수를 출력합니다.
        ▣ 입력예제 1
        5 3
        ▣ 출력예제 1
        10
        ▣ 입력예제 2
        33 19
        ▣ 출력예제 2
        818809200
*/

import java.util.Scanner;

public class Quiz7 {
    static int n, m;
    static int[][] arr = new int[35][35];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(DFS(n, m));
    }

    private static int DFS(int n, int m) {
        if (arr[n][m] > 0) return arr[n][m];
        if (n == m || m == 0) return 1;
        else return arr[n][m] = DFS(n - 1, m - 1) + DFS(n - 1, m);
    }
}
