package org.programers.algorismKit.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*기능개발*/
public class Test42586 {
    public static void main(String[] args) {
        int[] arr = {93, 30, 55};
        int[] speed= {1, 30, 5};
        solution(arr, speed);
    }
    static public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Node> Q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            Q.offer(new Node(progresses[i], i));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!Q.isEmpty()) {
            int n = 0;
            if (Q.peek().num >= 100){
                while (true){
                    if (!Q.isEmpty() &&Q.peek().num >= 100){
                        Q.poll();
                        n++;
                    }else {
                        list.add(n);
                        break;
                    }

                }

            }else {
                for (int i = 0; i < Q.size(); i++) {
                    Node cur = Q.poll();
                    cur.num += speeds[cur.idx];
                    Q.offer(cur);
                }
            }

        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    static class Node{
        int num;
        int idx;
        public Node(int num, int idx){
            this.num  = num;
            this.idx  = idx;
        }
    }
}
