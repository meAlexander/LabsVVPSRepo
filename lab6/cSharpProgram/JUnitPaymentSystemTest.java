package lab6.cSharpProgram;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class JUnitPaymentSystemTest {

	@Test
	void testInputCausesSaturday() throws ParseException {
		PaymentDate payment = new PaymentDate();
		Date day = payment.calculateFuturePaymentDate("16/04/2020");
		SimpleDateFormat format = new SimpleDateFormat("EEEE", java.util.Locale.ENGLISH);
		String dayOfWeek = format.format(day);
		
		assertEquals("Monday", dayOfWeek);
	}
	
	@Test
	void testInputCausesSunday() throws ParseException {
		PaymentDate payment = new PaymentDate();
		Date day = payment.calculateFuturePaymentDate("17/04/2020");
		
		SimpleDateFormat format = new SimpleDateFormat("EEEE", java.util.Locale.ENGLISH);
		String dayOfWeek = format.format(day);
		
		assertEquals("Monday", dayOfWeek);
	}
}