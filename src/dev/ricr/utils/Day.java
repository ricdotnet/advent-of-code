package dev.ricr.utils;

import java.util.ArrayList;

public abstract class Day {
  public String directory;
  public ArrayList<String> getLines(String fileName) {
    return ReadFile.getLines(this.directory + fileName);
  }
}
