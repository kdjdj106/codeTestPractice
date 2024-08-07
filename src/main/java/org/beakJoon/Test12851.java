package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.

예제 입력 1
5 17
예제 출력 1
4
2
* */
public class Test12851 {
    static int n, m;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Position> Q = new LinkedList<>();
        Q.offer(new Position(n, 0));
        int checkTime = -1;
        int answer = 0;
        boolean flag = false;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int t = 0; t < size; t++) {
                Position tmp = Q.poll();
                visit[tmp.x] = true;
                if (tmp.x == m){
                    checkTime = tmp.time;
                    answer++;
                    flag = true;
                }
                int n1 = tmp.x - 1;
                int n2 = tmp.x + 1;
                int n3 = tmp.x * 2;

                if (n1 >= 0 && !visit[n1]) Q.offer(new Position(n1, tmp.time+1));
                if (n2 <= 100000 && !visit[n2]) Q.offer(new Position(n2, tmp.time+1));
                if (n3 <= 100000 && !visit[n3]) Q.offer(new Position(n3, tmp.time+1));
            }
            if (flag) break;
        }
        System.out.println(checkTime);
        System.out.println(answer);
    }

    public static class Position {
        int x, time;

        public Position(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
