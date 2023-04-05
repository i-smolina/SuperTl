package com.example.supertl.algo;

import com.example.supertl.algo.sequence.SequenceRecursion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceRecursionTest {
    SequenceRecursion sequenceRecursion = new SequenceRecursion();

    @Test
    public void getTest1() {
        List<List<Integer>> res = sequenceRecursion.get(new Integer[][]{{1, 2, 3}, {6, 7}});
        assertEquals(List.of(
                        List.of(1, 6), List.of(1, 7)
                        , List.of(2, 6), List.of(2, 7)
                        , List.of(3, 6), List.of(3, 7)),
                res);
    }

    @Test
    public void getTest2() {
        List<List<Integer>> res = sequenceRecursion.get(new Integer[][]{{1}, {6, 7}});
        assertEquals(List.of(
                        List.of(1, 6), List.of(1, 7)),
                res);
    }

    @Test
    public void getTest3() {
        List<List<Integer>> res = sequenceRecursion.get(new Integer[][]{{1, 2}, {6}});
        assertEquals(List.of(
                        List.of(1, 6), List.of(2, 6)),
                res);
    }

    @Test
    public void getTest4() {
        List<List<Integer>> res = sequenceRecursion.get(new Integer[][]{{1, 2}});
        assertEquals(List.of(
                        List.of(1), List.of(2)),
                res);
    }
}
