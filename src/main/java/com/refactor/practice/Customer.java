package com.refactor.practice;

import java.util.Enumeration;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Customer {

  private String _name;
  private Vector<Rental> _rentals;

  public Customer(String _name, Vector<Rental> _rentals) {
    this._name = _name;
    this._rentals = _rentals;
  }

  private String getName() {
    return _name;
  }

  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  private Rental getRental(MovieType movieType) {
    return _rentals.stream()
        .filter(it -> Objects.equals(it.getMovie().triggerType(), movieType))
        .findAny()
        .orElseThrow(() -> new RuntimeException("Movie is not found"));
  }

  private double calculateThisAmount(Rental rental) {
    return getRental(rental.getMovie().triggerType()).getMovie().doCalculate(rental);
  }

  public double calculateTotalAmount() {
    AtomicReference<Double> totalAmount = new AtomicReference<>((double) 0);
    _rentals.forEach(it -> totalAmount.updateAndGet(v -> v + calculateThisAmount(it)));
    return totalAmount.get();
  }

  public int calculateFrequentRenterPoints() {
    AtomicInteger frequentRenterPoints = new AtomicInteger(0);
    _rentals.forEach(it -> {
      //add frequent renter points
      frequentRenterPoints.getAndIncrement();
      //add bonus for a two day new release rental
      if ((it.getMovie().triggerType() == MovieType.NEW_RELEASE) &&
          it.getDayRented() > 1) {
        frequentRenterPoints.getAndIncrement();
      }
    });

    return frequentRenterPoints.get();
  }

  public String getStatement() {
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      //show figures for this rental
      result += "\t" + each.getMovie().get_title() +
          "\t" + String.valueOf(calculateThisAmount(each)) + "\n";
    }
    //add footer lines
    result += "Amount owed is " + String.valueOf(calculateTotalAmount()) + "\n";
    result += "You earned" + String.valueOf(calculateFrequentRenterPoints()) +
        " frequent renter points";
    return result;
  }
}
