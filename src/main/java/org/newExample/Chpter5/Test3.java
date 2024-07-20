package org.newExample.Chpter5;

import java.util.Scanner;
import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer =0;
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : arr2) {
            for (int i = 0; i < n; i++) {
                int cur = arr[i][num - 1];
                if (cur != 0) {
                    arr[i][num-1] =0;
                    if (!stack.isEmpty() && cur == stack.peek()){
                        answer+=2;
                        stack.pop();
                    }else {
                        stack.push(cur);
                    }
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
