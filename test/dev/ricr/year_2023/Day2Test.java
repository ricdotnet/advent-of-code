package dev.ricr.year_2023;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

  private final Day2 day2 = new Day2();

  @Test
  void part1_sample() {
    assertEquals(8, day2.part1("test_1.txt"));
  }

  @Test
  void part2_sample() {
    assertEquals(2286, day2.part2("test_1.txt"));
  }

  @Test
  void part1() {
    assertEquals(2156, day2.part1("puzzle.txt"));
  }

  @Test
  void part2() {
    assertEquals(66909, day2.part2("puzzle.txt"));
  }

}
