package lab7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyClass {
	public static void main(String[] args) {
		//comment the above 2 lines and uncomment below 2 lines to use Edge
		System.setProperty("webdriver.edge.driver","D:\\LabsVVPS\\lab7\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
    	
		 String baseUrl = "http://demo.guru99.com/test/newtours/";
	        String expectedTitle = "Welcome: Mercury Tours";
	        String actualTitle = "";

	        // launch Edge and direct it to the Base URL
	        driver.get(baseUrl);

	        // get the actual value of the title
	        actualTitle = driver.getTitle();

	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	        //close Edge 
	        driver.close();
    }
}