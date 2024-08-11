package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.

오늘부터 인구 이동이 시작되는 날이다.

인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)

둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)

인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.

출력
인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.

예제 입력 1
2 20 50
50 30
20 40
예제 출력 1
1
* */
public class Test16234 {
    static int n, lNum, rNum, answer =0;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = false;
    static Queue<Node> Q;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        lNum = Integer.parseInt(st.nextToken());
        rNum = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반복문 시작
        while (true){
            // 기본값으로 flag를 flase로 둔다.
            // 인구를 분배하지 못한다면  false 이기 때문에 나중에 반복문에서 빠져나오게 된다.
            flag = false;

            // 한번 반복문을 할때마다 visit배열을 초기화 해준다.
            visit = new boolean[n][n];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // 이전단계에서 방문하지 않았다면 bfs로 연합을 찾는다.
                    if (!visit[i][j]){
                        int sum = bfs(i, j);
                        if (list.size() >1){
                            // 배열을 평균값내서 계산  avg = sum / list.size()
                            changeBoardNum(sum);
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) break;
            answer++;
        }
        System.out.println(answer);
    }
    static int bfs(int x, int y){
        // 들어온 값도 sum에 포함시켜야 하므로 이렇게 초기화한다.
        int sum =board[x][y];

        // 현대배열 위치와 연합이 되는 값을 담을 list를 만든다.
        list = new ArrayList<>();

        // 마찬가지로 현재배열또한 연합에 포함되므로 list에 넣어준다.
        list.add(new Node(x, y));
        Q = new LinkedList<>();

        //bfs를 시작하기 위해서 Queue에 현재 위치 값을 넣어준다.
        Q.add(new Node(x, y));
        visit[x][y] = true;

        while (!Q.isEmpty()){
            Node tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                // 다음 값이 방문되어있지 않고 올바른 값이라면
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]){

                    // 현재 위치와 다음 값의 차이를 구한다.
                    int diff = Math.abs(board[tmp.x][tmp.y] - board[nx][ny]);

                    // 그 차이 값이 우리가 설정한 범위안에 속한다면 연합조건에 맞기 때문에
                    // Queue, list에 넣고 그 값을 sum에 더한다.
                    // sum은 연합의 총합이 되며 bfs가 끝난후 평균값을 내는데 사용된다.
                    if (lNum <= diff && rNum >= diff){
                        Q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += board[nx][ny];
                        visit[nx][ny] = true;
                    }
                }

            }
        }
        return sum;
    }

    // 리스트 사이즈만큰  sum을 나눠 평균값을 배분하는 함수이다.
    static void changeBoardNum(int sum){
        int avg = sum/ list.size();
        for (Node node : list){
            board[node.x][node.y] = avg;
        }
    }
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
