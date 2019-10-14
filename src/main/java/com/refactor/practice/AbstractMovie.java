package com.refactor.practice;

public abstract class AbstractMovie {

  private String _title;

  AbstractMovie(String _title) {
    this._title = _title;
  }

  String get_title() {
    return _title;
  }

  public abstract MovieType triggerType();
  public abstract Double doCalculate(Rental rental);
}
