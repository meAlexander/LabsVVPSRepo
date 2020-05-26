package lab5;

import java.util.Scanner;

public class InputDataForOptionTwoAndThree {
	private String day = "-1", month = "-1";
	private Scanner scan;

	public InputDataForOptionTwoAndThree(Scanner scan) {
		System.out.println("Enter date.");
		this.scan = scan;
		setMonth();
		setDay();
	}

	public void setDay() {
		System.out.println("Enter days: ");
		while (Integer.parseInt(day) < 0 || Integer.parseInt(day) > 31) {
			this.day = scan.nextLine();
		}
	}

	public void setMonth() {
		System.out.println("Enter how months gone from your birthday: ");
		while (Integer.parseInt(month) < 0) {
			this.month = scan.nextLine();
		}
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}
}