package org.newExample.chapter8;

import java.util.Scanner;

public class Test8 {
    static int n;
    static int targetNum;
    static int[] answer, check, arr;
    static int[][] ch;
    static boolean flag = false;
    public static int combination(int n, int r){
        if (ch[n][r] > 0) return ch[n][r];
        if (n==r || r ==0) return 1;
        else {
            return ch[r][n] = combination(n-1, r-1) + combination(n-1, r);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        targetNum = sc.nextInt();
        answer = new int[n];
        arr = new int[n+1];
        check = new int[n+1];
        ch = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = combination(n-1, i);
        }
        DFS(0, 0);
    }
    public static void DFS(int sum, int L){
        if (flag) return;
        if (L == n){
            if (sum == targetNum){
                for (int i : answer){
                    System.out.print(i + " ");
                    flag = true;
                }
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0){
                    check[i] = 1;
                    answer[L] =i;
                    DFS(sum + (arr[L] * answer[L]), L+1);
                    check[i] =0;
                }
            }
        }
    }

}
