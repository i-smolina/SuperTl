package com.example.supertl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PortTest {
        @Test
        public void parseTest1() {
            Port port = new Port(new String[]{"1,3-5", "2", "3-4"});
            assertArrayEquals(port.parse(), new Integer[][]{{1, 3, 4, 5}, {2}, {3, 4}});
        }

        @Test
        public void parseTest2() {
            Port port = new Port(new String[]{"1-2,2-5", "2", "3-4"});
            assertArrayEquals(port.parse(), new Integer[][]{{1, 2, 3, 4, 5}, {2}, {3, 4}});
        }

        @Test
        public void parseTest3() {
            assertThrows(NumberFormatException.class, () -> {
                Port port = new Port(new String[]{""});
                port.parse();
            });
        }

        @Test
        public void parseTest4() {
            Port port = new Port(new String[]{});
            assertArrayEquals(port.parse(), new Integer[][]{});
        }

        @Test
        public void sequenceTest5() {
            Port port = new Port(new String[]{});
            assertArrayEquals(port.sequence(), null);
        }

        @Test
        public void sequenceTest6() {
            Port port = new Port(new String[]{"1,3-5", "2", "3-4"});
            port.parse();
            assertArrayEquals(port.sequence(),
                    new Integer[][]{
                            {1, 2, 3}, {1, 2, 4}, {3, 2, 3},
                            {3, 2, 4}, {4, 2, 3}, {4, 2, 4},
                            {5, 2, 3}, {5, 2, 4}});
        }
}
