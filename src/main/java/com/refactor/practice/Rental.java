package com.refactor.practice;

public class Rental {

  private AbstractMovie movie;

  private int dayRented;

  public Rental(AbstractMovie movie, int dayRented) {
    this.movie = movie;
    this.dayRented = dayRented;
  }

  AbstractMovie getMovie() {
    return movie;
  }

  int getDayRented() {
    return dayRented;
  }
}
