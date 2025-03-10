package com.joonseo.section01.sorting;


import java.util.Arrays;

public class Quick {
    public static void solution(int[] arr){
        System.out.println("원본 배열 : " + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1); // low는 맨 왼쪽, high는 맨 오른쪽
        System.out.println("정렬된 배열 : " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int low , int high){
        if(low >= high) return; // low가 high와 겹칠 때 종료가 되는 조건

        int partitionIndex = partition(arr,low,high); // 분할 행위
        quickSort(arr,low,partitionIndex-1); // pivot을 기준으로 왼쪽 부분 재귀 호출
        quickSort(arr,partitionIndex,high); // pivot을 기준으로 오른쪽 부분 재귀 호출
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[(low + high)/2]; // pivot은 중간이 좋다
        System.out.println("피벗 : " + pivot + "기준,인덱스 범위 : " + low + " ~ " + high); // 디버깅용 출력
        System.out.println("분할 전 배열 : " + Arrays.toString(arr)); // 디버깅용 출력

        while(low <= high){
            while(arr[low] < pivot){ // pivot보다 작으면
                low++; // low는 하나씩 오른쪽으로 이동
            }
            while(arr[high] > pivot){ // pivot보다 크면
                high--; // high는 하나씩 왼쪽으로 이동
            }
            if(low <= high){
                swap(arr,low,high);
                low ++;
                high --;;
            }
        }
        System.out.println("분할 후 배열 : " + Arrays.toString(arr)); // 디버깅용 출력
        System.out.println("반환후 pivot 인덱스 : " + pivot);
        System.out.println("===================================");
        return low;
    }

    private static void swap(int[] arr, int idx1 , int idx2){ // swap 함수
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
