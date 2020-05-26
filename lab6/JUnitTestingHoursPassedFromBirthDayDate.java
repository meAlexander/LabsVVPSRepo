package lab6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

class JUnitTestingHoursPassedFromBirthDayDate {

	@Test
	void testInputCauses195072Hours() throws NumberFormatException, ParseException {
		OptionMenu menu = new OptionMenu();
		long hourDiff = menu.getHoursPassedFromBirthdayDate("19-01-1998", new Date());
		assertEquals(195071, hourDiff);
	}
}