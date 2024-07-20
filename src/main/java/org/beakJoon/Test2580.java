package org.beakJoon;

import java.util.Scanner;

/*
스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다.
이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.



또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.



이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.
게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.

입력 :
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0

출력 :
1 3 5 4 6 9 2 7 8
7 8 2 1 3 5 6 4 9
4 6 9 2 7 8 1 3 5
3 2 1 5 4 6 8 9 7
8 7 4 9 1 3 5 2 6
5 9 6 8 2 7 4 1 3
9 1 7 6 5 2 3 8 4
6 4 3 7 8 1 9 5 2
2 5 8 3 9 4 7 6 1
 */
public class Test2580 {

    public static int[][] board = new int[9][9];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = in.nextInt();
            }
        }

        sudoku(0, 0);

    }
    public static void sudoku(int x, int y){
        if (y == 9){
            sudoku(x+1, 0);
        }
        if (x == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (board[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (checkPossibility(x, y, i)) {
                    board[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            // 스도쿠를 채워나가면서 계속 값이 바뀌는데 위 반복문으로 맞는 값을 찾을 수 없는 경우
            // 즉 마지막 board[x][y]에 들어간 값이 3인데, 재귀함수를 계속 타고가면서
            // 3 이후값이 아니라 1, 2같은 이전값이 들어가야 맞는 경우에는
            // 반복문을 처음부터 다시 돌리지 않는한 이전값인 1,2가 나올 수 없다.
            // 그러므로 board[x][y]를 0으로 만들고 return하여 이전 빈칸부터 재귀함수를 다시 호출한다.
            board[x][y] = 0;
            return;
        }

        sudoku(x, y + 1);
    }
    public static boolean checkPossibility(int x, int y, int value){
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == value) return false;
        }
        int nx = (x/3) * 3;
        int ny = (y/3) * 3;
        for (int i = nx; i < nx +3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if(board[nx][ny] == value) return false;
            }
        }
        return true;
    }
}
