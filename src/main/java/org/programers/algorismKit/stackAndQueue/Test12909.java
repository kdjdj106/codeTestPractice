package org.programers.algorismKit.stackAndQueue;

import java.util.Stack;

/*
올바른 괄호
**/
public class Test12909 {
    public static void main(String[] args) {
        String s = ")()(";
        System.out.println(solution(s));
    }
    static boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c =='(') stack.push(c);
            else {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        if (stack.isEmpty()) answer = true;
        return answer;
    }
}
