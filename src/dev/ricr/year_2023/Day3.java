package dev.ricr.year_2023;

import dev.ricr.utils.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Day3 extends Day {
  private final List<Integer> numbers;

  public Day3() {
    this.directory = "puzzles/2023/day3/";
    this.numbers = new ArrayList<>();
  }

  private void runNumbers(List<String> lines, String line, int i, Optional<List<Integer>> numbers2) {
    for (int j = 0; j < line.length(); j++) {
      String current = String.valueOf(line.charAt(j));

      if (this.isSymbol(current)) {
        List<Integer> numbersPart2 = new ArrayList<>();
        int top = this.getColumn(lines.get(i - 1), j);
        int bottom = this.getColumn(lines.get(i + 1), j);
        int left = this.getLine(line, j + 1, "right");
        int right = this.getLine(line, j - 1, "left");

        numbersPart2.add(top);
        numbersPart2.add(bottom);
        numbersPart2.add(left);
        numbersPart2.add(right);

        if (top == 0) {
          int topR = this.getColumn(lines.get(i - 1), j + 1);
          int topL = this.getColumn(lines.get(i - 1), j - 1);
          numbersPart2.add(topR);
          numbersPart2.add(topL);
        }
        if (bottom == 0) {
          int bottomR = this.getColumn(lines.get(i + 1), j + 1);
          int bottomL = this.getColumn(lines.get(i + 1), j - 1);
          numbersPart2.add(bottomR);
          numbersPart2.add(bottomL);
        }

        if (numbers2.isPresent()) {
          List<Integer> filteredNumbersPart2 = numbersPart2.stream().filter(a -> a != 0).toList();
          if (filteredNumbersPart2.size() == 2) {
            numbers2.get().add(filteredNumbersPart2.getFirst() * filteredNumbersPart2.getLast());
          }
        }
      }
    }
  }

  public int part1(String fileName) {
    List<String> lines = this.getLines(fileName);

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);

      this.runNumbers(lines, line, i, Optional.empty());
    }

    return this.numbers.stream().reduce(0, (a, b) -> a += b);
  }

  private boolean isSymbol(String s) {
    Pattern pattern = Pattern.compile("[^.a-z0-9A-Z]");
    return pattern.matcher(s).find();
  }

  private int getColumn(String l, int p) {
    StringBuilder number = new StringBuilder();
    if (!Character.isDigit(l.charAt(p))) return 0;

    while (Character.isDigit(l.charAt(p))) {
      if (p == 0 || !Character.isDigit(l.charAt(p - 1))) break;
      p--;
    }

    while (Character.isDigit(l.charAt(p))) {
      number.append(l.charAt(p));
      p++;
      if (p == l.length()) break;
    }

    if (number.isEmpty()) return 0;

    this.numbers.add(Integer.parseInt(number.toString()));
    return Integer.parseInt(number.toString());
  }

  private int getLine(String l, int p, String d) {
    StringBuilder number = new StringBuilder();

    while (p >= 0 && p < l.length() && Character.isDigit(l.charAt(p))) {
      if (d.equals("left")) {
        number.insert(0, l.charAt(p));
        p--;
      }
      if (d.equals("right")) {
        number.append(l.charAt(p));
        p++;
      }
    }

    if (number.isEmpty()) return 0;

    this.numbers.add(Integer.parseInt(number.toString()));
    return Integer.parseInt(number.toString());
  }

  public int part2(String fileName) {
    List<String> lines = this.getLines(fileName);
    int total = 0;

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      List<Integer> numbers2 = new ArrayList<>();

      this.runNumbers(lines, line, i, Optional.of(numbers2));

      if (!numbers2.isEmpty()) {
        total += numbers2.stream().reduce(0, (a, b) -> a += b);
      }
    }

    return total;
  }

}
