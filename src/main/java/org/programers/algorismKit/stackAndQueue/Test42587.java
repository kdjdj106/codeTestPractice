package org.programers.algorismKit.stackAndQueue;

import java.util.*;

/*
* 프로세스
* */
public class Test42587 {
    public static void main(String[] args) {
        int[] arr ={1, 1, 9, 1, 1, 1};
        int n = 0;
        solution(arr, n);
    }

    static public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Position> Q = new LinkedList<>();
        ArrayList<Position> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < priorities.length; i++) {
            Q.offer(new Position(priorities[i], i));
            list.add(new Position(priorities[i], i));
        }

        while (!Q.isEmpty()) {
            max = getMax(Q);
            Position tmp = Q.poll();
            if (tmp.priorities >= max){
                if (tmp.idx == location) return answer;
                else {
                    answer++;
                }
            }else{
                Q.offer(tmp);
            }
        }
        return answer;
    }
    static int getMax(Queue<Position> Q) {
        Position minPosition = Q
                .stream()
                .max(Comparator.comparing(Position::getPriorities))
                .orElseThrow(NoSuchElementException::new);
        return minPosition.priorities;
    }
    static class Position{
        int priorities;
        int idx;
        public Position(int priorities, int idx) {
            this.priorities = priorities;
            this.idx = idx;
        }
        public int getPriorities() {
            return priorities;
        }
    }


}
