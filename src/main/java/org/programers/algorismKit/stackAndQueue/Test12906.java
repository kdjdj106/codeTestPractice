package org.programers.algorismKit.stackAndQueue;

import java.util.Stack;

/*같은 숫자는 싫어
 */
public class Test12906 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }
    static public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int prevNum = stack.peek();
            if (prevNum != arr[i]) stack.push(arr[i]);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        answer = stack.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
