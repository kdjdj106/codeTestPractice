package org.example.chapter8_DFS_BFS;

/*동전교환
        다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
        해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
        ▣ 입력설명
        첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종
        류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
        각 동전의 종류는 100원을 넘지 않는다.
        ▣ 출력설명
        첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
        ▣ 입력예제 1
        3
        1 2 5
        15
        ▣ 출력예제 1
        3
*/


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Quiz5 {
    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    private static void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m){
            answer = Math.min(L, answer);
        }else {
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }
}
