package com.refactor.practice;

public class ChildrenMovie extends AbstractMovie {

  public ChildrenMovie(String title) {
    super(title);
  }

  @Override
  public MovieType triggerType() {
    return MovieType.CHILDREN;
  }

  @Override
  public Double doCalculate(Rental rental) {
    int CHILDREN_MOVIE_BASE_DAY = 3;
    double CHILDREN_MOVIE_BASE_PRICE = 1.5d;
    double CHILDREN_MOVIE_PER_PRICE = 1.5;
    if (rental.getDayRented() > CHILDREN_MOVIE_BASE_DAY) {
      return CHILDREN_MOVIE_BASE_PRICE + ((rental.getDayRented() - CHILDREN_MOVIE_BASE_DAY)
          * CHILDREN_MOVIE_PER_PRICE);
    }
    return CHILDREN_MOVIE_BASE_PRICE;
  }
}
