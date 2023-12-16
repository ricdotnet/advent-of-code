package dev.ricr.year_2023;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

  private final Day4 day4 = new Day4();

  @Test
  void part1_sample() {
    assertEquals(13, day4.part1("test_1.txt"));
  }

  @Test
  void part2_sample() {
    assertEquals(30, day4.part2("test_1.txt"));
  }

  @Test
  void part1() {
    assertEquals(23235, day4.part1("puzzle.txt"));
  }

  @Test
  void part2() {
    assertEquals(5920640, day4.part2("puzzle.txt"));
  }

}
