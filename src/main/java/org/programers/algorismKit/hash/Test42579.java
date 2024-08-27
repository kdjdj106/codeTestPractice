package org.programers.algorismKit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
/*베스트앨범*/
public class Test42579 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    static public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> genreList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            genreList.add(entry.getKey());
        }
        genreList.sort((o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Integer> answer = new ArrayList<>();
        for (String str : genreList) {
            ArrayList<Song> songList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (str.equals(genres[i])) {
                    songList.add(new Song(i, plays[i]));
                }
            }
            Collections.sort(songList);
            answer.add(songList.get(0).idx);
            if (songList.size() > 1) answer.add(songList.get(1).idx);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Song implements Comparable<Song> {
        @Override
        public int compareTo(Song o) {
            if (o.plays == this.plays) return this.idx - o.idx;
            return o.plays - this.plays;
        }

        int idx, plays;

        public Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
}
