package com.joonseo.section07.heap;

import java.util.*;

public class Practice2 {

    public long solution(String input) {
        String[] put = input.split("\n");
        String[] firstLine = put[0].split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        int[][] jewels = new int[n][2];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            String[] jewelInfo = put[i + 1].split(" ");
            jewels[i][0] = Integer.parseInt(jewelInfo[0]); // 무게
            jewels[i][1] = Integer.parseInt(jewelInfo[1]); // 가격
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(put[n + 1 + i]); // 가방 무게
        }

        Arrays.sort(jewels, Comparator.comparingInt(a -> a[0]));

        Arrays.sort(bags);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long maxValue = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            while (jewelIndex < n && jewels[jewelIndex][0] <= bag) {
                maxHeap.offer(jewels[jewelIndex][1]);
                jewelIndex++;
            }
            if (!maxHeap.isEmpty()) {
                maxValue += maxHeap.poll();
            }
        }

        return maxValue;
    }
}
