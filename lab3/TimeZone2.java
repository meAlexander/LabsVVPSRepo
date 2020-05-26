package lab3;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class TimeZone2 {
	public static void main(String[] args) {
		Instant instant = Instant.now(); // Capture current moment in UTC.
		Scanner scan = new Scanner(System.in);

		menu(instant, scan);
	}

	public static void getZoneValue(Instant instant, String zone) {
		ZoneId z = ZoneId.of(zone);
		ZonedDateTime zdt = instant.atZone(z);
		System.out.println(zdt.getHour() + ":" + zdt.getMinute() + ":" + zdt.getSecond() + " " + zdt.getDayOfMonth()
				+ " " + zdt.getMonth() + " " + zdt.getYear() + " " + zdt.getZone());
	}

	private static void menu(Instant instant, Scanner scan) {
		String option;
		for (;;) {
			System.out.println("---------------View TIME ZONES-----------------");
			System.out.println("Option 1: Europe/Paris");
			System.out.println("Option 2: Asia/Tokyo");
			System.out.println("Option 3: Europe/Moscow");
			System.out.println("Option 4: Europe/London");
			System.out.println("Option 5: Asia/Shanghai");
			System.out.println("Option 6: Africa/Cairo");
			System.out.println("Option 7: America/Chicago");
			System.out.println("Option 8: Australia/Sydney");
			System.out.println("Option 9: America/Los_Angeles");
			System.out.println("Option 10: View time difference between two zones");
			System.out.println("Option 0: Exit");
			System.out.println("Choose an option: ");
			option = scan.nextLine();

			try {
				if (Integer.parseInt(option) == 1) {
					getZoneValue(instant, "Europe/Paris");
				} else if (Integer.parseInt(option) == 2) {
					getZoneValue(instant, "Asia/Tokyo");
				} else if (Integer.parseInt(option) == 3) {
					getZoneValue(instant, "Europe/Moscow");
				} else if (Integer.parseInt(option) == 4) {
					getZoneValue(instant, "Europe/London");
				} else if (Integer.parseInt(option) == 5) {
					getZoneValue(instant, "Asia/Shanghai");
				} else if (Integer.parseInt(option) == 6) {
					getZoneValue(instant, "Africa/Cairo");
				} else if (Integer.parseInt(option) == 7) {
					getZoneValue(instant, "America/Chicago");
				} else if (Integer.parseInt(option) == 8) {
					getZoneValue(instant, "Australia/Sydney");
				} else if (Integer.parseInt(option) == 9) {
					getZoneValue(instant, "America/Los_Angeles");
				} else if (Integer.parseInt(option) == 10) {
					chooseZone(instant, scan);
				} else if (Integer.parseInt(option) == 0) {
					System.out.println("Bye!");
					break;
				} else {
					System.out.println("No such option!");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input!");
			} catch (OptionException oe) {
				System.out.println(oe.getMessage());
			}
		}
		scan.close();
	}

	private static void chooseZone(Instant instant, Scanner scan) throws OptionException {
		String zone1 = null;
		String zone2 = null;

		System.out.println("Enter first zone: ");
		zone1 = scan.nextLine();
		if (Integer.parseInt(zone1) == 1) {
			zone1 = "Europe/Paris";
		} else if (Integer.parseInt(zone1) == 2) {
			zone1 = "Asia/Tokyo";
		} else if (Integer.parseInt(zone1) == 3) {
			zone1 = "Europe/Moscow";
		} else if (Integer.parseInt(zone1) == 4) {
			zone1 = "Europe/London";
		} else if (Integer.parseInt(zone1) == 5) {
			zone1 = "Asia/Shanghai";
		} else if (Integer.parseInt(zone1) == 6) {
			zone1 = "Africa/Cairo";
		} else if (Integer.parseInt(zone1) == 7) {
			zone1 = "America/Chicago";
		} else if (Integer.parseInt(zone1) == 8) {
			zone1 = "Australia/Sydney";
		} else if (Integer.parseInt(zone1) == 9) {
			zone1 = "America/Los_Angeles";
		} else {
			throw new OptionException();
		}

		System.out.println("Enter second zone: ");
		zone2 = scan.nextLine();
		if (Integer.parseInt(zone2) == 1) {
			zone2 = "Europe/Paris";
		} else if (Integer.parseInt(zone2) == 2) {
			zone2 = "Asia/Tokyo";
		} else if (Integer.parseInt(zone2) == 3) {
			zone2 = "Europe/Moscow";
		} else if (Integer.parseInt(zone2) == 4) {
			zone2 = "Europe/London";
		} else if (Integer.parseInt(zone2) == 5) {
			zone2 = "Asia/Shanghai";
		} else if (Integer.parseInt(zone2) == 6) {
			zone2 = "Africa/Cairo";
		} else if (Integer.parseInt(zone2) == 7) {
			zone2 = "America/Chicago";
		} else if (Integer.parseInt(zone2) == 8) {
			zone2 = "Australia/Sydney";
		} else if (Integer.parseInt(zone2) == 9) {
			zone2 = "America/Los_Angeles";
		} else {
			throw new OptionException();
		}

		getZoneInformation(instant, zone1, zone2);
	}

	public static void getZoneInformation(Instant instant, String zone1, String zone2) {
		ZoneId z1 = ZoneId.of(zone1);
		ZonedDateTime zdt1 = instant.atZone(z1);

		ZoneId z2 = ZoneId.of(zone2);
		ZonedDateTime zdt2 = instant.atZone(z2);

		checkHoursBetweenTwoZones(zdt1, zdt2);
	}

	public static void checkHoursBetweenTwoZones(ZonedDateTime zdt1, ZonedDateTime zdt2) {
		int difference = Math.abs(zdt1.getHour() - zdt2.getHour());

		System.out.println(
				"Difference between " + zdt1.getZone() + " and " + zdt2.getZone() + " is " + difference + " hours");
	}
}