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
    if (rental.getDayRented() > 2) {
      return 2.0d + ((rental.getDayRented() - 2) * 1.5);
    }
    return 2.0d;
  }


}
