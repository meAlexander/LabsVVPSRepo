package lab6.cSharpProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PaymentDate {
	public static void main(String[] args) {

	}

	public Date calculateFuturePaymentDate(String startingDate) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();

		c.setTime(formatDate.parse(startingDate));
		c.add(Calendar.DAY_OF_MONTH, 30);

		SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("EEEE", java.util.Locale.ENGLISH);
		String dayOfWeek = formatDayOfWeek.format(c.getTime());

		switch (dayOfWeek) {
			case "Saturday":
				c.add(Calendar.DAY_OF_MONTH, 2);
				break;
			case "Sunday":
				c.add(Calendar.DAY_OF_MONTH, 1);
				break;
		}
		return c.getTime();
	}
}