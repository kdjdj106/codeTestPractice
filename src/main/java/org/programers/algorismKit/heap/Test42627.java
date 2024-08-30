package org.programers.algorismKit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 디스크 컨트롤러

 * */
public class Test42627 {
    public static void main(String[] args) {
        int[][] arr = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(arr));
    }

    static public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int endTime = 0;
        int idx = 0;
        int endProcess = 0;
        int sum = 0;
        while (endProcess < jobs.length) {

            // 정렬한 작업중에 시작시간이 현재 끝날시간보다 작으면 pq에 추가
            while (idx < jobs.length && jobs[idx][0] <= endTime) {
                pq.offer(jobs[idx++]);
            }

            //
            if (pq.isEmpty()) {
                endTime = jobs[idx][0];
            }else {
                int[] tmp = pq.poll();
                sum += tmp[1] + endTime - tmp[0];
                endTime += tmp[1];
                endProcess++;
            }


        }
        answer = sum/jobs.length;

        return answer;
    }
}
