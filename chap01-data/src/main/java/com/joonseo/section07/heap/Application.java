package com.joonseo.section07.heap;

/*Java Collection Framework 에서 heap을 직접 지원하는 클래스는 없지만
* PriorityQueue에서 지원해준다.*/
import java.util.PriorityQueue;

public class Application {
    public static void main(String[] args) {
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 요소 추가
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(8);

        // 최솟값 조회
        System.out.println(minHeap.peek());

        // 최소값 제거
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());

        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        // 요소 추가
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(8);

        // 최솟값 조회
        System.out.println(maxHeap.peek());

        // 최소값 제거
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());
    }
}
