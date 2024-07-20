package org.newExample.chapter8;

import java.util.Scanner;

public class Test7 {
    static int n, m;
    static int[][] arr = new int[35][35];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(DFS(0, n, m));

    }
    public static int DFS(int L, int n, int r){
        if (arr[n][r] > 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        else {
             return arr[n][r] = DFS(L+1, n-1, r-1) + DFS(L+1, n-1, r);
        }
    }
}
