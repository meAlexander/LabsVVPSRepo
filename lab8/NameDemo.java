package lab8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NameDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","D:\\JavaProjects\\LabsVVPS\\lab8\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/ajax.html");

//		// Find the radio button for “No” using its ID and click on it
//		driver.findElement(By.id("no")).click();
//
//		//Click on Check Button
//		driver.findElement(By.id("buttoncheck")).click();
		
		List<WebElement> elements = driver.findElements(By.name("name"));
	    System.out.println("Number of elements:" + elements.size());

	    for (int i = 0; i < elements.size(); i++){
	      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
	    }
	}
}