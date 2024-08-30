package org.programers.algorismKit.ExhaustiveSearch;
/*
https://school.programmers.co.kr/learn/courses/30/lessons/86491
최소 직사각형
* */
public class Test86491 {
    public static void main(String[] args) {
        int[][] arr = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(arr));
    }
    static  public int solution(int[][] sizes) {
        int answer = 0;
        int max_width=0;
        int max_height=0;
        for (int[] arr : sizes){
            int width = Math.max(arr[0], arr[1]);
            int height = Math.min(arr[0], arr[1]);

            max_width = Math.max(width, max_width);
            max_height = Math.max(height, max_height);
        }

        return max_width * max_height;
    }
}
