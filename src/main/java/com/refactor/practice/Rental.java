package com.refactor.practice;

public class Rental {

  private AbstractMovie _movie;

  private int _dayRented;

  public Rental(AbstractMovie movie, int dayRented) {
    _movie = movie;
    _dayRented = dayRented;
  }

  AbstractMovie getMovie() {
    return _movie;
  }

  int getDayRented() {
    return _dayRented;
  }
}
