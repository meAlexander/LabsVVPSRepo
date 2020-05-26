package lab6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OptionMenu {
	private static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	private String option;

	public OptionMenu() {

	}

	public void chooseOpiton() {
		System.out.println("Welcome!");
		for (;;) {
			System.out.println("---------------------------------");
			System.out.println("Option 1: Calculate how days gone from past date to NOW.");
			System.out.println("Option 2: Get the year I am born by entering month and days.");
			System.out.println("Option 3: Get the day of week I am born by entering month and days.");
			System.out.println("Option 4: Calculate how hours difference between two past dates.");
			System.out.println("Option 5: Calculate how hours have passed from birthday date.");
			System.out.println("Option 0: Exit");
			System.out.println("Choose an option: ");
			option = scan.nextLine();
			try {
				if (Integer.parseInt(option) == 1) {
					InputDataForOptionOneAndFourAndFive date1 = new InputDataForOptionOneAndFourAndFive(scan);
					getDaysBetweenTwoDates(date1.getDateInput());
				} else if (Integer.parseInt(option) == 2) {
					InputDataForOptionTwoAndThree date2 = new InputDataForOptionTwoAndThree(scan);
					getBirthDayYear(date2.getDay(), date2.getMonth(), dateFormat);
				} else if (Integer.parseInt(option) == 3) {
					InputDataForOptionTwoAndThree date3 = new InputDataForOptionTwoAndThree(scan);
					getBirthDayOfWeek(date3.getDay(), date3.getMonth());
				} else if (Integer.parseInt(option) == 4) {
					InputDataForOptionOneAndFourAndFive date4 = new InputDataForOptionOneAndFourAndFive(scan);
					System.out.println("Enter second date:");
					InputDataForOptionOneAndFourAndFive date5 = new InputDataForOptionOneAndFourAndFive(scan);

					long diffHours = getHoursBetweenTwoDates(date4.getDateInput(), date5.getDateInput());
					System.out.println("Time in hours: " + diffHours + " hours.");
				} else if (Integer.parseInt(option) == 5) {
					InputDataForOptionOneAndFourAndFive date6 = new InputDataForOptionOneAndFourAndFive(scan);
					long hoursFromBirthday = getHoursPassedFromBirthdayDate(date6.getDateInput(), new Date());
					System.out.println(hoursFromBirthday + " have passed since birthday date");
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

	public long getHoursPassedFromBirthdayDate(String birthdayDate, Date now) throws NumberFormatException, ParseException {
		Date firstDate = null, secondDate = null;

		firstDate = dateFormat.parse(dateFormat.format(now));
		secondDate = dateFormat.parse(birthdayDate);

		long diff = Math.abs(firstDate.getTime() - secondDate.getTime());
		long diffHours = diff / (60 * 60 * 1000);

		return diffHours;
	}

	public long getHoursBetweenTwoDates(String dateInput1, String dateInput2) throws ParseException {
		Date date1 = null;
		Date date2 = null;

		date1 = dateFormat.parse(dateInput1);
		date2 = dateFormat.parse(dateInput2);

		long diff = Math.abs(date1.getTime() - date2.getTime());
		long diffHours = diff / (60 * 60 * 1000);
		return diffHours;

	}

	public void getBirthDayOfWeek(String day, String month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -Integer.parseInt(month));
		calendar.add(Calendar.DATE, -Integer.parseInt(day));

		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US));
	}

	public void getDaysBetweenTwoDates(String date) throws NumberFormatException, ParseException {
		Date firstDate = null, secondDate = null;

		String dateInput = date;

		firstDate = dateFormat.parse(dateFormat.format(new Date()));
		secondDate = dateFormat.parse(dateInput);

		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		System.out.println("From " + dateInput + " year to now are: " + diff + " days.");
	}

	public void getBirthDayYear(String day, String month, SimpleDateFormat dateFormat) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -Integer.parseInt(month));
		calendar.add(Calendar.DATE, -Integer.parseInt(day));

		Date date = calendar.getTime();
		System.out.println(dateFormat.format(date));
	}
}