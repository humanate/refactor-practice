package com.refactor.practice;

public class ChildrenMovie extends AbstractMovie {

  public ChildrenMovie(String _title) {
    super(_title);
  }

  @Override
  public MovieType triggerType() {
    return MovieType.CHILDREN;
  }

  @Override
  public Double doCalculate(Rental rental) {
    if (rental.getDayRented() > 3) {
      return 1.5d + ((rental.getDayRented() - 3) * 1.5);
    }
    return 1.5;
  }
}
