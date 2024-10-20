package org.beakJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Test1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            String str = br.readLine();

            set.add(str);
        }
        for (int i = 0; i < b; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                list.add(str);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()+"\n");
        for (String s :list){
            sb.append(s + "\n");
        }
        System.out.println(sb.toString());
    }
}
