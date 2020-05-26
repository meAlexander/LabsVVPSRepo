package lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
	private Scanner scan;
	private SimpleDateFormat dateFormat;
	private String option;

	public Menu(Scanner scan, SimpleDateFormat dateFormat) {
		this.scan = scan;
		this.dateFormat = dateFormat;
	}

	public void chooseOpiton() {
		System.out.println("Welcome!");
		for (;;) {
			System.out.println("---------------------------------");
			System.out.println("Option 1: Calculate days difference from past date to NOW.");
			System.out.println("Option 2: Get the year I am born.");
			System.out.println("Option 3: Get the day of week I am born.");
			System.out.println("Option 0: Exit");
			System.out.println("Choose an option: ");
			option = scan.nextLine();
			try {
				if (Integer.parseInt(option) == 1) {
					InputData date1 = new InputData(scan);
					checkDaysBetweenTwoDates(dateFormat, date1.getDateInput());
				} else if (Integer.parseInt(option) == 2) {
					InputData2 date2 = new InputData2(scan);
					getBirthDayYear(date2.getDay(), date2.getMonth(), dateFormat);
				}else if (Integer.parseInt(option) == 3) {
					InputData2 date3 = new InputData2(scan);
					getBirthDayOfWeek(date3.getDay(), date3.getMonth());
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

	public static void getBirthDayOfWeek(String day, String month) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date()); 
		
		calendar.add(Calendar.MONTH, -Integer.parseInt(month));
		calendar.add(Calendar.DATE, -Integer.parseInt(day));
		
		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US));
	}

	public static void checkDaysBetweenTwoDates(SimpleDateFormat dateFormat, String date)
			throws NumberFormatException, ParseException {
		Date firstDate = null, secondDate = null;

		String dateInput = date;

		firstDate = dateFormat.parse(dateFormat.format(new Date()));
		secondDate = dateFormat.parse(dateInput);

		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		System.out.println("From " + dateInput + " year to now are: " + diff + " days.");
	}
	
	public static void getBirthDayYear(String day, String month, SimpleDateFormat dateFormat) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date()); 
		
		calendar.add(Calendar.MONTH, -Integer.parseInt(month));
		calendar.add(Calendar.DATE, -Integer.parseInt(day));
		
		Date date = calendar.getTime();
		System.out.println(dateFormat.format(date));
	}
}