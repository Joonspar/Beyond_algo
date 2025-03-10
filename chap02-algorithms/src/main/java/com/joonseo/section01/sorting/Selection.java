package com.joonseo.section01.sorting;

import java.util.Arrays;


public class Selection {

    public static void solution(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){ // 버블과 동일하게 길이 - 1번 반복 ( 루프를 의미 )
            System.out.println((i+1) + "번째 : " + Arrays.toString(arr));
            int minIdx = i; // 최솟값 찾는 변수
            for(int j = i + 1; j<arr.length; j++){
                if(arr[j] < arr[minIdx]){ // 만약 해당 인덱스보다 뒤의 값이 작다면
                    minIdx = j; // 제일 작은 값의 인덱스를 변경
                }
            }
            int temp = arr[i]; // swap 진행
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}