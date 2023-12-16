package dev.ricr.year_2023;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {

  private final Day3 day3 = new Day3();

  @Test
  void part1_sample() {
    assertEquals(4361, day3.part1("test_1.txt"));
  }

  @Test
  void part2_sample() {
    assertEquals(467835, day3.part2("test_1.txt"));
  }

  @Test
  void part1() {
    assertEquals(536202, day3.part1("puzzle.txt"));
  }

  @Test
  void part2() {
    assertEquals(78272573, day3.part2("puzzle.txt"));
  }

}
