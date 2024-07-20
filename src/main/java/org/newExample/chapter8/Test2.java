package org.newExample.chapter8;

import java.util.Scanner;

public class Test2 {
    static int c;
    static int n;
    static int[] arr;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        DFS(0, 0, arr);
        System.out.println(answer);
        
    }
    static void DFS(int sum, int L, int[] arr){
        if (sum > c) return;
        if (L == n) answer = Math.max(answer, sum);
        else {
            DFS(sum + arr[L], L+1, arr);
            DFS(sum, L+1, arr);}

    }
    
}
