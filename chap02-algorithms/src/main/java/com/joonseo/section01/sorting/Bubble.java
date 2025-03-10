package com.joonseo.section01.sorting;

import java.util.Arrays;

/* 버블 정렬
*  인접한 두 요소를 비교하여 크기가 순서대로 정렬되지 않았으면 교환하는 방식의 정렬이다.
*  배열 전체를 여러번 반복하며 각 반복마다 가장 큰 요소가 끝으로 이동한다.
*  시간 복잡도는 O(N^2)이며, 데이터가 거의 정렬 된 경우 O(N)이 될 수도 있다.
*  하지만 교환 연산이 많아 다른 O(N^2) 정렬보다 느릴 수 있다.*/
public class Bubble {

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 어차피 가장 큰 값은 맨 마지막에 위치를 할 것이기 때문에 길이 -1 만큼 반복 진행한다.
            System.out.println((i + 1) + "번째 : " + Arrays.toString(arr)); // 확인용 출력문
            for (int j = 0; j < arr.length - 1 - i; j++) { // i라는 턴을 돌때 값 비교를 위한 인덱스
                if (arr[j] > arr[j + 1]) { // 다음 값보다 그 이전 값이 크게 되면 ( 만약 내림차순이면 반대로 진행 )
                    int temp = arr[j]; // 임시변수를 활용하여 swap을 진행한다.
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}