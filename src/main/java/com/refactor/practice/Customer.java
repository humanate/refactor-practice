package com.refactor.practice;

import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Customer {

  private String name;
  private Vector<Rental> rentals;

  public Customer(String name, Vector<Rental> rentals) {
    this.name = name;
    this.rentals = rentals;
  }

  private String getName() {
    return name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  private Rental getRental(MovieType movieType) {
    return rentals.stream()
        .filter(it -> Objects.equals(it.getMovie().triggerType(), movieType))
        .findAny()
        .orElseThrow(() -> new RuntimeException("Movie is not found"));
  }

  private double calculateThisAmount(Rental rental) {
    return getRental(rental.getMovie().triggerType()).getMovie().doCalculate(rental);
  }

  public double calculateTotalAmount() {
    AtomicReference<Double> totalAmount = new AtomicReference<>((double) 0);
    rentals.forEach(it -> totalAmount.updateAndGet(v -> v + calculateThisAmount(it)));
    return totalAmount.get();
  }

  public int calculateFrequentRenterPoints() {
    AtomicInteger frequentRenterPoints = new AtomicInteger(0);
    rentals.forEach(it -> {
      frequentRenterPoints.getAndIncrement();
      if ((it.getMovie().triggerType() == MovieType.NEW_RELEASE) &&
          it.getDayRented() > 1) {
        frequentRenterPoints.getAndIncrement();
      }
    });

    return frequentRenterPoints.get();
  }

  public String getStatement() {
    StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

    rentals.forEach(it -> result.append("\t").append(it.getMovie().getTitle()).append("\t")
        .append(calculateThisAmount(it)).append("\n"));
    result.append("Amount owed is ").append(calculateTotalAmount()).append("\n");
    result.append("You earned").append(calculateFrequentRenterPoints())
        .append(" frequent renter points");
    return result.toString();
  }

  public String getStatementHtml() {

    return null;
  }
}
