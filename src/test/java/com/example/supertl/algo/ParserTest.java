package com.example.supertl.algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void parseTest1() {
        Integer[] res = parser.parse("1,3-5");
        assertArrayEquals(new Integer[]{1, 3, 4, 5}, res);
    }

    @Test
    public void parseTest2() {
        Integer[] res = parser.parse("2");
        assertArrayEquals(new Integer[]{2}, res);
    }

    @Test
    public void parseTest3() {
        assertThrows(NumberFormatException.class, () -> parser.parse(""));
    }

    @Test
    public void parseTest4() {
        Integer[] res = parser.parse("5-10,15");
        assertArrayEquals(new Integer[]{5, 6, 7, 8, 9, 10, 15}, res);
    }

    @Test
    public void parseTest5() {
        Integer[] res = parser.parse("5-10,15,18-20");
        assertArrayEquals(new Integer[]{5, 6, 7, 8, 9, 10, 15, 18, 19, 20}, res);
    }

    @Test
    public void parseTest6() {
        assertThrows(NumberFormatException.class, () -> parser.parse("-1-3"));
    }

    @Test
    public void rangeFromStrTest1() {
        List<Integer> res = parser.rangeFromStr("0");
        assertEquals(List.of(), res);
    }

    @Test
    public void rangeFromStrTest2() {
        List<Integer> res = parser.rangeFromStr("");
        assertEquals(List.of(), res);
    }

    @Test
    public void rangeFromStrTest3() {
        assertThrows(NumberFormatException.class, () -> parser.rangeFromStr("-1-3"));
    }
}
