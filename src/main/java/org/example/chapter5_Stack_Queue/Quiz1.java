package org.example.chapter5_Stack_Queue;
/*

괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
        (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
        ▣ 입력설명
        첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
        ▣ 출력설명
        첫 번째 줄에 YES, NO를 출력한다.
        ▣ 입력예제 1
        (()(()))(()
        ▣ 출력예제 1
        NO
*/

import java.util.Scanner;
import java.util.Stack;

public class Quiz1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for (char c : s.toCharArray()){
            if (c =='(') stack.push('(');
            else {
                if (stack.empty()){
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }
        System.out.println(answer);
    }
}
