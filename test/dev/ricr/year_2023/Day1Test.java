package dev.ricr.year_2023;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Day1Test {

    private final Day1 day1 = new Day1();

    @Test
    void part1_sample() {
        assertEquals(142, day1.part1("test_1.txt"));
    }

    @Test
    void part2_sample() {
        assertEquals(281, day1.part2("test_2.txt"));
    }

    @Test
    void part1() {
        assertEquals(56049, day1.part1("puzzle.txt"));
    }

    @Test
    void part2() {
        assertEquals(54530, day1.part2("puzzle.txt"));
    }

}
