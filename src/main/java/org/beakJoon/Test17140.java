package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test17140 {
    static int eX, eY, eNum, answer = 0;
    static ArrayList<Point> boardList;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열을 101x101 으로 만들면 -1을 안해도 된다.
        // 필자는 그냥 100x100으로 만들어 -1을 해주었다.
        eX = Integer.parseInt(st.nextToken()) - 1;
        eY = Integer.parseInt(st.nextToken()) - 1;
        eNum = Integer.parseInt(st.nextToken());


        // 0을 신경쓰지 않기 위해 미리 100x100 크기의 배열을 만든다.
        int[][] board = new int[100][100];

        // 숫자와 카운트가 들어갈 map
        map = new HashMap<Integer, Integer>();


        //기본적으로 주어지는 첫번째 배열을 담는다.
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여기서 x는 행의 개수  y는 열의 개수이다.
        // 초기 배열을 3x3이니 미리 설정해둔다.
        int x = 3, y = 3;

        // 나중에 정열을 하기위해 리스트를 만든다.
        boardList = new ArrayList<>();

        // 여기부터 로직 시작
        while (true) {

            // 목표배열의 값이 목표값과 같으면 로직 종료
            if (board[eX][eY] == eNum) {
                break;
            }

            // 로직을 100이 초과된다면 로직종료
            if (answer > 100) {
                answer = -1;
                break;
            }

            // 보드를 건들지 않기 위해 임시 보드를 만든다.
            int[][] tmpBoard = new int[100][100];

            // 여기서 x는 행의 개수  y는 열의 개수이다.
            // 행(가로줄)의 줄 수가 열(세로줄) 이상일때
            if (x >= y) {
                // 보드값이 0이 아닐때 가로줄 값을 map에 담는다 이미 담은 숫자라면 cnt를 증가시켜준다.
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (board[i][j] != 0)
                            map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                    }
                    // map이 비었다면 생략
                    if (map.isEmpty()) continue;

                    // map을 list에 옮겨 담는다.
                    for (Integer key : map.keySet()) {
                        boardList.add(new Point(key, map.get(key)));
                    }

                    //리스트를 밑에 있는 Point의 정렬 방식대로 정렬
                    Collections.sort(boardList);

                    // index을 0으로 설정
                    int index = 0;

                    // 미리 만들어둔 임시보드에 값을 옮겨 담는다.
                    // 한번에 숫자의 값, 숫자의 cnt값을 담는다. 그러기 위해 숫자와 cnt를 담을때 마다 index++를 해준다.
                    for (Point p : boardList) {
                        tmpBoard[i][index++] = p.num;
                        tmpBoard[i][index++] = p.cnt;
                    }

                    // 열의 개수를 설정한다.
                    // 여기서 list*2의 값이 열의 개수가 된다. 예를 들어 list에 최대 3개의 숫자까지 들어갔다면
                    // 다음 보드의 열의 갯수는 6이 된다.  ex) (1, 1), (2, 1), (3, 1) 총 3개의 숫자와 cnt가 들어갔다면
                    // 다음 보드는 [1][1][2][1][3][1]이 되기 때문에 크기가 6이 된다.
                    y = Math.max(y, boardList.size() *2);

                    // map, list를 초기화 시켜준다.
                    map.clear();
                    boardList.clear();
                }

            }
            // 열(세로줄)의 줄 수가 행(가로줄)이상일때
            else {
                // 보드값이 0이 아닐때 세로줄 값을 map에 담는다 이미 담은 숫자라면 cnt를 증가시켜준다.
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        if (board[j][i] != 0)
                            map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
                    }
                    if (map.isEmpty()) continue;
                    for (Integer key : map.keySet()) {
                        boardList.add(new Point(key, map.get(key)));
                    }
                    Collections.sort(boardList);
                    int index = 0;
                    for (Point p : boardList) {
                        tmpBoard[index++][i] = p.num;
                        tmpBoard[index++][i] = p.cnt;
                    }
                    x = Math.max(x, boardList.size() *2);
                    map.clear();
                    boardList.clear();
                }
            }

            // R연산 또는 C연산을 마쳤으니 answer++을 해준다.
            answer++;

            // 그리고 수정한 보드 값을 원본 보드로 붙여놓고 위의 과정을 반복한다.
            board = tmpBoard;
        }
        System.out.println(answer);
    }


    // 카운트가 같으면 오름차순으로 정렬하지만 기본적으론 카운트를 기준으로 오름차 순으로 정렬한다.
    static class Point implements Comparable<Point>{
        int num, cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            } else
                return this.cnt - o.cnt;
        }
    }
}
