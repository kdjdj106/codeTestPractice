package org.beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int n = Integer.parseInt(string);
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (char ch : str.toCharArray()){

                // '('이면 스택에 넣어준다.
                if (ch == '(') stack.push(ch);

                // ')' 이면
                else {
                    // 스택이 비어있지 않고 꺼냈을때 '(' 이라면 꺼낸다.
                    // 스택이 비어있지 않은지 먼저 검사를 해야 에러에 걸리지 않는다.
                    if (!stack.isEmpty() && stack.peek() == '(' ){
                        stack.pop();
                    }
                    // 조건에 맞지 않는다면 스택에 넣어준다.
                    else stack.push(')');
                }
            }

            // 짝이 다 맞는다면 스택이 비어있기 때문에 yes 출력
            if (stack.isEmpty()) System.out.println("YES");

            // 짝이 맞지 않는다면 스택에 무언가가 남아있기 때문에 no 출력
            else System.out.println("NO");
        }
    }

}
