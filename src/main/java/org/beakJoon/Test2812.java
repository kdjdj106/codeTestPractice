package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)

둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.

출력
입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수를 출력한다.

예제 입력 1
4 2
1924
예제 출력 1
94
* */
public class Test2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = m;
        String str = br.readLine();

        char[] arr = str.toCharArray();
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            Q.offer(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int cnt =0;
        for (Integer i : Q) {
            while (cnt < m && !deque.isEmpty() && deque.getLast() < i) {
                deque.removeLast();
                cnt++;
            }
            deque.addLast(i);
        }

        for (int i = 0; i < n - k; i++) {
            System.out.print(deque.pollFirst());
        }
    }
}
