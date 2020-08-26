package com.metao.dp.saga.orchestration;

import java.util.ArrayList;
import java.util.List;

public class Saga {

  private final List<Chapter> chapters;


  private Saga() {
    this.chapters = new ArrayList<>();
  }


  public Saga chapter(String name) {
    this.chapters.add(new Chapter(name));
    return this;
  }


  public Chapter get(int idx) {
    return chapters.get(idx);
  }

  public boolean isPresent(int idx) {
    return idx >= 0 && idx < chapters.size();
  }


  public static Saga create() {
    return new Saga();
  }

  /**
   * result for saga.
   */
  public enum Result {
    FINISHED, ROLLBACK, CRASHED
  }

  /**
   * class represents chapter name.
   */
  public static class Chapter {
    String name;

    public Chapter(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }
}
