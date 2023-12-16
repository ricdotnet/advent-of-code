package dev.ricr.year_2023;

import dev.ricr.utils.Day;

import java.util.*;

public class Day4 extends Day {

  public Day4() {
    this.directory = "puzzles/2023/day4/";
  }

  private List<String[]> getGames(String fileName) {
    return this.getLines(fileName)
        .stream()
        .map(line -> line.split(":"))
        .toList();
  }

  private List<List<Integer>> getMatches(String fileName) {
    return this.getGames(fileName)
        .stream()
        .map((card) -> {
          String[] pairs = card[1].trim().split("\\|");
          String[] winningNumbers = pairs[0].trim().split(" ");
          String[] myNumbers = pairs[1].trim().split(" ");
          List<Integer> matches = new ArrayList<>();
          Arrays.stream(myNumbers)
              .filter(a -> !a.isEmpty())
              .forEach(mn -> {
                if (Arrays.asList(winningNumbers).contains(mn)) {
                  matches.add(Integer.parseInt(mn));
                }
              });

          return matches;
        }).toList();
  }

  public int part1(String fileName) {
    List<Integer> values = new ArrayList<>();
    this.getMatches(fileName)
        .forEach(match -> {
          values.add(match.stream().reduce(0, (a, b) -> {
            if (a == 0) {
              return a = 1;
            }
            return a *= 2;
          }));
        });

    return values.stream().reduce(0, (a, b) -> a += b);
  }

  public int part2(String fileName) {
    List<List<Integer>> originalCards = this.getMatches(fileName);
    int[] totalCards = new int[originalCards.size()];

    for (int i = 0; i < originalCards.size(); i++) {
      totalCards[i] = 1;
    }


    for (int i = 0; i < originalCards.size(); i++) {
      for (int j = 1; j <= originalCards.get(i).size(); j++) {
        totalCards[i + j] += totalCards[i];
      }
    }

    return Arrays.stream(totalCards).reduce(0, (a, b) -> a += b);
  }

}
