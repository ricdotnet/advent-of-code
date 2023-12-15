package dev.ricr.year_2023;

import dev.ricr.utils.ReadFile;

import java.util.ArrayList;

public class Day1 {
  private final String directory;

  public Day1() {
    this.directory = "puzzles/2023/day1/";
  }

  public int part1(String fileName) {
    ArrayList<String> lines = ReadFile.getLines(this.directory + fileName);
    ArrayList<String> values = new ArrayList<>();

    for (String line : lines) {
      int front = 0;
      int back = line.length() - 1;
      int[] ints = {-1, -1};

      while (true) {
        if (Character.isDigit(line.charAt(front)) && ints[0] == -1) {
          ints[0] = Character.getNumericValue(line.charAt(front));
        }
        if (Character.isDigit(line.charAt(back)) && ints[1] == -1) {
          ints[1] = Character.getNumericValue(line.charAt(back));
        }

        if (ints[0] != -1 && ints[1] != -1) {
          break;
        }

        front++;
        back--;
      }

      values.add(String.valueOf(ints[0]) + String.valueOf(ints[1]));
    }

    int total = 0;
    for (String value : values) {
      total += Integer.parseInt(value);
    }

    return total;
  }

  private int getIntFromString(String integerString) {
    return switch (integerString) {
      case "one" -> 1;
      case "two" -> 2;
      case "three" -> 3;
      case "four" -> 4;
      case "five" -> 5;
      case "six" -> 6;
      case "seven" -> 7;
      case "eight" -> 8;
      case "nine" -> 9;
      case "zero" -> 0;
      default -> -1;
    };
  }

  public int part2(String fileName) {
    ArrayList<String> lines = ReadFile.getLines(this.directory + fileName);
    ArrayList<String> values = new ArrayList<>();

    for (String line : lines) {
      ArrayList<String> tempLine = new ArrayList<>();

      for (int i = 0; i < line.length(); i++) {
        StringBuilder integerString = new StringBuilder();
        if (Character.isDigit(line.charAt(i))) {
          tempLine.add(String.valueOf(line.charAt(i)));
          continue;
        }

        for (int j = i; j < line.length(); j++) {
          integerString.append(line.charAt(j));
          int intFromString = getIntFromString(integerString.toString());
          if (intFromString != -1) {
            tempLine.add(String.valueOf(intFromString));
            break;
          }
        }
      }

      values.add(tempLine.stream().reduce("", (a, b) -> a += b));
    }

    int total = 0;
    for (String value : values) {
      String first = String.valueOf(value.charAt(0));
      String last = String.valueOf(value.charAt(value.length() - 1));

      total += Integer.parseInt(first + last);
    }

    return total;
  }
}
