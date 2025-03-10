package com.joonseo.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {
    static int[] act1,exp1;

    @BeforeAll
    static void setUp(){
        act1 = new int[] {42,32,24,60,15,5,90,45};
        exp1 = new int[] {5,15,24,32,42,45,60,90};

    }

    static Stream<Arguments> provideAscendingSource(){
        return Stream.of(
                Arguments.of(act1,exp1)
        );
    }

    @DisplayName("병합 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testBubbleSort(int[] actual , int[] expected){
        Merge.solution(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}