package dev.ricr.year_2023;

import dev.ricr.utils.Day;

import java.util.ArrayList;

public class Day2 extends Day {

  public Day2() {
    this.directory = "puzzles/2023/day2/";
  }

  public int part1(String fileName) {
    ArrayList<Integer> possibleGames = new ArrayList<>();

    for (String line : this.getLines(fileName)) {
      String[] gameLine = line.split(":");
      boolean isPossible = isGamePossible(gameLine);

      if (isPossible) {
        int gameNumber = Integer.parseInt(gameLine[0].trim().split(" ")[1]);
        possibleGames.add(gameNumber);
      }
    }

    return possibleGames.stream().reduce(0, Integer::sum);
  }

  private boolean isGamePossible(String[] gameLine) {
    String[] cubeSets = gameLine[1].split(";");
    for (String cubeSet : cubeSets) {
      String[] cubes = cubeSet.split(",");

      int red = 0, green = 0, blue = 0;

      for (String cube : cubes) {
        String[] amountAndColor = cube.trim().split(" ");
        int amount = Integer.parseInt(amountAndColor[0]);
        String color = amountAndColor[1];

        if (color.equals("red")) red = amount;
        if (color.equals("green")) green = amount;
        if (color.equals("blue")) blue = amount;
      }

      if (red > 12 || green > 13 || blue > 14) return false;
    }

    return true;
  }

  public int part2(String fileName) {
    ArrayList<Integer> powers = new ArrayList<>();
    for (String line : this.getLines(fileName)) {
      String[] gameLine = line.split(":");

      String[] cubeSets = gameLine[1].split(";");
      int red = findLowest("red", cubeSets);
      int green = findLowest("green", cubeSets);
      int blue = findLowest("blue", cubeSets);

      powers.add(red * green * blue);
    }

    return powers.stream().reduce(0, Integer::sum);
  }

  private int findLowest(String color, String[] cubeSets) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for (String cubeSet : cubeSets) {
      String[] cubes = cubeSet.split(",");
      for (String cube : cubes) {
        String[] amountAndColor = cube.trim().split(" ");
        int amount = Integer.parseInt(amountAndColor[0]);
        String _color = amountAndColor[1];
        if (color.equals(_color)) {
          numbers.add(amount);
        }
      }
    }
    return numbers.stream().max(Integer::compare).get();
  }

}
