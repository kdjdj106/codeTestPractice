package org.beakJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> setFull = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            setFull.add(i+1);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;

            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) sb.append("1" + "\n");
                    else sb.append("0" + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set = (HashSet<Integer>) setFull.clone();
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }

        }
        System.out.println(sb.toString());
    }
}
