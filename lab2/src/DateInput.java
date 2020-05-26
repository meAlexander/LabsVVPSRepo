package lab2;

import java.util.Scanner;

public class DateInput {
	private String day = "0", month = "0", year = "0";
	private String dateInput;
	private Scanner scan;
	
	public DateInput(Scanner scan) {
		System.out.println("Enter date.");
		this.scan = scan;
		setDay();
		setMonth();
		setYear();
		setDateInput();
	}

	public void setDay() {
		System.out.println("Enter day: ");
		while (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > 31) {
			this.day = scan.nextLine();
		}
	}

	public void setMonth() {
		System.out.println("Enter month: ");
		while (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > 12) {
			this.month = scan.nextLine();
		}
	}

	public void setYear() {
		System.out.println("Enter year: ");
		while (Integer.parseInt(year) <= 0) {
			this.year = scan.nextLine();
		}
	}

	public void setDateInput() {
		this.dateInput = day.concat("." + month + "." + year);
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