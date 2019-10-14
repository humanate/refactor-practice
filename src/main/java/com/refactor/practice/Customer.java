package com.refactor.practice;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals;

	public Customer(String _name, Vector _rentals) {
		this._name = _name;
		this._rentals = _rentals;
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0D;
			Rental each = (Rental) rentals.nextElement();

			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (each.getDayRented() > 2) {
						thisAmount += (each.getDayRented() - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDayRented() * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (each.getDayRented() > 3) {
						thisAmount += (each.getDayRented() - 3) * 1.5;
					}
					break;
			}
			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					each.getDayRented() > 1) {
				frequentRenterPoints++;
			}

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() +
					"\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned" + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}

	private double calculateThisAmount(Rental each){
		double thisAmount = 0D;

			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (each.getDayRented() > 2) {
						thisAmount += (each.getDayRented() - 2) * 1.5;
					}
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDayRented() * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (each.getDayRented() > 3) {
						thisAmount += (each.getDayRented() - 3) * 1.5;
					}
					break;
			}
			return thisAmount;
	}

	public double calculateTotalAmount(){
		double totalAmount = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			totalAmount += calculateThisAmount((Rental) rentals.nextElement());
		}
		return totalAmount;
	}

	public int calculateFrequentRenterPoints(){
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					each.getDayRented() > 1) {
				frequentRenterPoints++;
			}
		}

		return frequentRenterPoints;
	}

	public String getStatement(){
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() +
					"\t" + String.valueOf(calculateThisAmount(each)) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(calculateTotalAmount()) + "\n";
		result += "You earned" + String.valueOf(calculateFrequentRenterPoints()) +
				" frequent renter points";
		return result;
	}
}
