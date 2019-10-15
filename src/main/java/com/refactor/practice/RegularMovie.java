package com.refactor.practice;

public class RegularMovie extends AbstractMovie {

  public RegularMovie(String title) {
    super(title);
  }

  @Override
  public MovieType triggerType() {
    return MovieType.REGULAR;
  }

  @Override
  public Double doCalculate(Rental rental) {
    int REGULAR_MOVIE_BASE_DAY = 2;
    double REGULAR_MOVIE_BASE_PRICE = 2.0d;
    double REGULAR_MOVIE_PER_PRICE = 1.5;
    if (rental.getDayRented() > REGULAR_MOVIE_BASE_DAY) {
      return REGULAR_MOVIE_BASE_PRICE + ((rental.getDayRented() - REGULAR_MOVIE_BASE_DAY)
          * REGULAR_MOVIE_PER_PRICE);
    }
    return REGULAR_MOVIE_BASE_PRICE;
  }


}
