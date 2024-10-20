package org.programers;

import java.util.LinkedList;
import java.util.Queue;

/*
리코쳇 로봇

리코쳇 로봇이라는 보드게임이 있습니다.

이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.

이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.

다음은 보드게임판을 나타낸 예시입니다.

...D..R
.D.G...
....D.D
D....D.
..D....

여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.

게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.

* */
public class Test169199 {
    static char[][] board;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> Q;
    static int n, m;
    static int answer;
    static Point robot;
    static Point goal;

    public static void main(String[] args) {
        String[] arr = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(arr));
    }

    static public int solution(String[] arr) {
        int answer = 0;
        n = arr.length;
        m = arr[0].length();
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = arr[i].charAt(j);
                board[i][j] = ch;
                if (ch == 'R') {
                    robot = new Point(i, j, 0);
                } else if (ch == 'G') {
                    goal = new Point(i, j, 1);
                }
            }
        }
        answer = bfs();
        return answer;
    }

    static int bfs() {
        Q = new LinkedList<Point>();
        Q.offer(robot);
        visit = new boolean[n][m];
        visit[robot.x][robot.y] = true;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            // 목표지점에 로봇이 있다면 현재 값을 반환
            if (tmp.x == goal.x && tmp.y == goal.y) {
                return tmp.cnt;
            }


            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x;
                int ny = tmp.y;

                // 장애물을 만나지 않거나 올바른 범위에 있다면 계속 이동한다.
                while (check(nx, ny) && board[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 그 전위치로 한칸 이동
                nx -= dx[i];
                ny -= dy[i];

                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                Q.offer(new Point(nx, ny, tmp.cnt+1));
            }
        }
        return -1;
    }
    // 올바른 위치인지 검사하는 로직
    public static boolean check(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            return true;
        } else return false;
    }

    public static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
