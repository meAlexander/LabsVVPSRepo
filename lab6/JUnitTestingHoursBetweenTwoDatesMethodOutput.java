package lab6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class JUnitTestingHoursBetweenTwoDatesMethodOutput {

	@Test
	void testResult() throws ParseException {
		OptionMenu menu = new OptionMenu();
		long hourDiff = menu.getHoursBetweenTwoDates("14-4-2020", "10-4-2020");
		assertEquals(96, hourDiff);
	}
}