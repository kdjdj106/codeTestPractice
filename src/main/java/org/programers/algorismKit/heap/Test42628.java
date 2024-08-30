package org.programers.algorismKit.heap;

import java.util.PriorityQueue;
/*이중 우선순위 큐*/
public class Test42628 {
    public static void main(String[] args) {
        String[] arr = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        System.out.println(solution(arr));
        arr = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(solution(arr));
    }

    static public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> reversePq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String str : operations) {
            String[] arr = str.split(" ");
            String order = arr[0];

            switch (order) {
                case "I":
                    pq.offer(Integer.parseInt(arr[1]));
                    reversePq.offer(Integer.parseInt(arr[1]));
                    break;
                case "D":
                    if (arr[1].equals("1")) {
                        pq.remove(reversePq.poll());
                    } else {
                        reversePq.remove(pq.poll());
                    }
                    break;

            }

        }
        if (pq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[1] = pq.peek();
            answer[0] = reversePq.peek();
        }
        return answer;
    }
}
