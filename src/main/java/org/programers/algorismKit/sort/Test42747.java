package org.programers.algorismKit.sort;

import java.util.Arrays;
/*
H-Index
https://school.programmers.co.kr/learn/courses/30/lessons/42747


 */
public class Test42747 {
    public static void main(String[] args) {
        int[] arr ={3, 0, 6, 1, 5};
        solution(arr);
    }
    static public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 인용된 논문의 수
            if (citations[i] >= i){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
