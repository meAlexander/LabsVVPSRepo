package lab2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
	private Scanner scan;
	private SimpleDateFormat dateFormat;
	private String dateNow, option;

	public Menu(Scanner scan, SimpleDateFormat dateFormat) {
		this.scan = scan;
		this.dateFormat = dateFormat;
		setDateNow();
	}

	public void chooseOpiton() {
		System.out.println("Welcome! Date now: " + dateNow);
		for (;;) {
			System.out.println("---------------------------------");
			System.out.println("Option 1: Calculate days difference from now.");
			System.out.println("Option 2: Get name day of week by date.");
			System.out.println("Option 0: Exit");
			System.out.println("Choose an option: ");
			option = scan.nextLine();
			try {
				if (Integer.parseInt(option) == 1) {
					DateInput date1 = new DateInput(scan);
					checkDaysBetweenTwoDates(dateNow, dateFormat, scan, date1.getDateInput());
				} else if (Integer.parseInt(option) == 2) {
					DateInput date2 = new DateInput(scan);
					getDayOfWeekByDate(dateFormat, scan, date2.getDateInput());
				} else if (Integer.parseInt(option) == 0) {
					System.out.println("Bye!");
					break;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input!");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
	
	public void setDateNow() {
		this.dateNow = dateFormat.format(new Date());
	}

	public static void checkDaysBetweenTwoDates(String dateNow, SimpleDateFormat dateFormat, Scanner scan, String date)
			throws NumberFormatException, ParseException {
		Date firstDate = null, secondDate = null;

		String dateInput = date;

		firstDate = dateFormat.parse(dateNow);
		secondDate = dateFormat.parse(dateInput);

		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		System.out.println("From now to " + dateInput + " year are: " + diff + " days.");
	}

	public static void getDayOfWeekByDate(SimpleDateFormat dateFormat, Scanner scan, String date)
			throws ParseException {
		String dateInput = date;
		Date dayOfWeek = dateFormat.parse(dateInput);
		DateFormat dateFormat2 = new SimpleDateFormat("EEEEE");
		System.out.println(dateFormat2.format(dayOfWeek));
	}
}