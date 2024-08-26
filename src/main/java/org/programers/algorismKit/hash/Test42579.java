package org.programers.algorismKit.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class Test42579 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays ={500, 600, 150, 800, 2500};

        solution(genres, plays);
    }
    static public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int [plays.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> list = new ArrayList<>();
        for (String genre : genres) {
            list.add(genre);
        }
        // ArrayList<String> list = new ArrayList<>(Arrays.asList(genres)); 위 로직을 이렇게 한줄로 정의 할수도 있다.
        // 플레이한 횟수로 내림차순
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        return answer;
    }

    static class Song implements Comparable<Song> {
        @Override
        public int compareTo(Song o) {
            return o.plays - this.;
        }

        int idx, plays;
        public Song(int idx, int plays){
            this.idx = idx;
            this.plays = plays;
        }
    }
}
