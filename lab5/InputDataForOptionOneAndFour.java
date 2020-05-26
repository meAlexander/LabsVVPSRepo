package lab5;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InputDataForOptionOneAndFour {
	private String day = "0", month = "0", year = "0";
	private String dateInput;
	private Scanner scan;
	Calendar calendar = Calendar.getInstance();

	public InputDataForOptionOneAndFour(Scanner scan) {
		System.out.println("Enter date.");
		this.scan = scan;
		calendar.setTime(new Date());
		setYear();
		setMonth();
		setDay();
		setDateInput();
	}

	public void setDay() {
		System.out.println("Enter day: ");
		if (getYear().equals(Integer.toString(calendar.get(Calendar.YEAR))) && getMonth().equals(Integer.toString(calendar.get(Calendar.MONTH) + 1))) {
			while (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > calendar.get(Calendar.DAY_OF_MONTH)) {
				this.day = scan.nextLine();
			}
		}else {
			while (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > 31) {
				this.day = scan.nextLine();
			}
		}
	}

	public void setMonth() {
		System.out.println("Enter month: ");
		if (getYear().equals(Integer.toString(calendar.get(Calendar.YEAR)))) {
			while (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > calendar.get(Calendar.MONTH) + 1) {
				this.month = scan.nextLine();
			}
		}else {
			while (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > 12) {
				this.month = scan.nextLine();
			}
		}
	}

	public void setYear() {
		System.out.println("Enter year: ");
		while (Integer.parseInt(year) <= 0 || Integer.parseInt(year) > calendar.get(Calendar.YEAR)) {
			this.year = scan.nextLine();
		}
	}

	public void setDateInput() {
		this.dateInput = day.concat("-" + month + "-" + year);
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getDateInput() {
		return dateInput;
	}
}