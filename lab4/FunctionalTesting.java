package lab4;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FunctionalTesting {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Menu menu = new Menu(scan, dateFormat);
		menu.chooseOpiton();
	}
}