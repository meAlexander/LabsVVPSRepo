package lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JUnitTestingHoursBetweenTwoDatesMethodOutput {

	@Test
	void testResult() {
		OptionMenu menu = new OptionMenu();
		long hourDiff = menu.getHoursBetweenTwoDates("14-4-2020", "10-4-2020");
		assertEquals(96, hourDiff);
	}
}