package com.refactor.practice;

public class NewReleaseMovie extends AbstractMovie {

  public NewReleaseMovie(String _title) {
    super(_title);
  }

  @Override
  public MovieType triggerType() {
    return MovieType.NEW_RELEASE;
  }

  @Override
  public Double doCalculate(Rental rental) {
    return rental.getDayRented() * 3.0d;
  }
}
