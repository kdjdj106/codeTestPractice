package org.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
* 가장 먼 노드
* */
public class Test49189 {
    public static void main(String[] args) {
        int[][] edge = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(6, edge);
    }
    static public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : edge){
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        boolean[] visited = new boolean[n+1];
         answer = bfs(graph, visited, n);
        return answer;
    }

    static public int bfs(ArrayList<ArrayList<Integer>> graph,
                   boolean[] visited, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] depth = new int[n+1];
        queue.add(1);
        visited[1] = true;
        depth[1] = 1;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0; i < graph.get(x).size(); i++) {
                int next = graph.get(x).get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    depth[next] += depth[x] + 1;
                    queue.add(next);
                }
            }
        }
        int m = Arrays.stream(depth).max().getAsInt();
        int answer = 0;
        for(int x: depth) {
            if(x == m) {
                answer++;
            }
        }
        return answer;
    }
}
