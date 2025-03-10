package com.joonseo.section01.sorting;


import java.util.Arrays;

/* 최적화된 버블 정렬 구현하기
*  버블정렬은 인접한 두 요소를 비교하여 정렬하므로 일반적으로는 o(n^2)의 시간 복잡도를 갖는다.
*  정렬이 어느정도 되어 있는 경우 불필요한 비교를 줄이는 최적화를 통해 O(n)까지 성능을 개선할 수 있다.*/
public class Practice1 {
    public static void bubbleSort(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println( (i+1) + "번째 : " + Arrays.toString(arr));
            swapped = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void swap(int[] arr, int i , int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
}
