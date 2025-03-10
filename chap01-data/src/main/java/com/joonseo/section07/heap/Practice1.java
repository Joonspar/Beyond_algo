package com.joonseo.section07.heap;

import java.util.PriorityQueue;

public class Practice1 {

    public String solution(Integer[] array){
        // 절댓값 기준 정렬, 같은 절댓값이면 원래 값이 작은 순서
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) {
                        return Integer.compare(a, b); // 원래 값이 작은 것이 우선
                    }
                    return Integer.compare(absA, absB); // 절댓값이 작은 것이 우선
                }
        );

        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            if (num != 0) {
                pq.offer(num); // 원래 값을 넣음 (절댓값 기준 정렬은 Comparator에서 수행)
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(pq.poll()).append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
