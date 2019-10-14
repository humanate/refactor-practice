package com.refactor.practice;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
	private Customer customer;
	private String baseline;

	@Before
	public void setUp() throws IOException {
		customer = new Customer("user1", new Vector());
		File file = new File("src/test/java/com/refactor/practice/baseline");
		baseline = FileUtils.readFileToString(file);
	}

	@Test
	public void should_get_statement_of_rentals() {
		//given
		addRental(customer, new RegularMovie("regular movie"), 3);
		addRental(customer, new NewReleaseMovie("new movie"), 2);
		addRental(customer, new ChildrenMovie("children movie"), 5);
		//when
		String result = customer.getStatement();
		//then
		assertThat(result).isEqualTo(baseline);
	}

	@Test
	public void calculate_amount_frequent_points_of_rentals() {
		//given
		addRental(customer, new RegularMovie("regular movie"), 3);
		addRental(customer, new NewReleaseMovie("new movie"), 2);
		addRental(customer, new ChildrenMovie("children movie"), 5);
		//when
		double amount = customer.calculateTotalAmount();
		double frequentRenterPoints = customer.calculateFrequentRenterPoints();
		//then
		assertThat(amount).isEqualTo(14.0d);
		assertThat(frequentRenterPoints).isEqualTo(4.0d);
	}

	private void addRental(Customer customer, AbstractMovie movie, int dayRented) {
		Rental rental = new Rental(movie, dayRented);
		customer.addRental(rental);
	}
}
