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
		addRental(customer, "regular movie", Movie.REGULAR, 3);
		addRental(customer, "new movie", Movie.NEW_RELEASE, 2);
		addRental(customer, "children movie", Movie.CHILDRENS, 5);
		//when
		String result = customer.statement();
		//then
		assertThat(result).isEqualTo(baseline);
	}

	private void addRental(Customer customer, String movieTitle, int movieType, int dayRented) {
		Movie movie = new Movie(movieTitle, movieType);
		Rental rental = new Rental(movie, dayRented);
		customer.addRental(rental);
	}
}