package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.
*/
public class Test13913 {
    static int n, m;
    static boolean[] visit;
    static int[] parent;
    static Queue<Position> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        parent = new int[100001];
        Q = new LinkedList<>();
        Q.offer(new Position(n, 0));

        bfs();

    }

    static void bfs() {
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int t = 0; t < size; t++) {
                Position tmp = Q.poll();

                if (tmp.x == m){
                    System.out.println(tmp.time);
                    Stack<Integer> stack = new Stack<>();
                    stack.push(tmp.x);
                    int num = tmp.x;
                    while (true){
                        if (num == n) break;
                        stack.push( parent[num]);
                        num = parent[num];
                    }
                    while (!stack.isEmpty()){
                        System.out.print(stack.pop()+" ");
                    }
                    return;
                }

                int n1 = tmp.x - 1;
                int n2 = tmp.x + 1;
                int n3 = tmp.x * 2;

                if (n1 >= 0 && !visit[n1]){
                    Q.offer(new Position(n1, tmp.time+1));
                    parent[n1] = tmp.x;
                    visit[n1] = true;
                }
                if (n2 <= 100000 && !visit[n2]){
                    Q.offer(new Position(n2, tmp.time+1));
                    parent[n2] = tmp.x;
                    visit[n2] = true;
                }
                if (n3 <= 100000 && !visit[n3]){
                    Q.offer(new Position(n3, tmp.time+1));
                    parent[n3] = tmp.x;
                    visit[n3] = true;
                }
            }
        }
    }

    static class Position {
        int x, time;

        public Position(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}
