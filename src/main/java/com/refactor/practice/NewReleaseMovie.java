package com.refactor.practice;

public class NewReleaseMovie extends AbstractMovie {

  public NewReleaseMovie(String title) {
    super(title);
  }

  @Override
  public MovieType triggerType() {
    return MovieType.NEW_RELEASE;
  }

  @Override
  public Double doCalculate(Rental rental) {
    double NEW_RELEASE_MOVIE_PER_PRICE = 3.0d;
    return rental.getDayRented() * NEW_RELEASE_MOVIE_PER_PRICE;
  }
}
