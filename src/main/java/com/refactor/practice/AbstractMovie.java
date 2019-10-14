package com.refactor.practice;

public abstract class AbstractMovie {

  private String title;

  AbstractMovie(String title) {
    this.title = title;
  }

  String getTitle() {
    return title;
  }

  public abstract MovieType triggerType();

  public abstract Double doCalculate(Rental rental);
}
