package org.programers.algorismKit.heap;

import java.util.PriorityQueue;

/*
더 맵게

* 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
* */
public class Test42626 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(arr, 7));
    }

    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        while (pq.peek() < K) {
            if (pq.size() == 1)
                return -1;

            int n1 = pq.poll();
            int n2 = pq.poll();
            pq.offer(n1 + (n2 * 2));
            answer++;


        }
        return answer;
    }


}

