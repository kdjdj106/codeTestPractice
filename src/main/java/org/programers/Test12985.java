package org.programers;

/*
예상 대진표
* */
public class Test12985 {
    public static void main(String[] args) {
        solution(8, 4, 7);
    }

    static public int solution(int n, int a, int b) {
        int answer = 0;
        while (true){
            a = a /2 + a % 2;
            b = b /2 + b % 2;

            answer++;
            if (a == b) break;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}
