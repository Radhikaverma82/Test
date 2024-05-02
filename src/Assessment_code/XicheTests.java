package Assessment_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class XicheTests {

    private XicheTestHelper helper;
    private static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(","); // Split the line by comma
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    @Before
    public void setUp() {
        helper = new XicheTestHelper("Webdriver\\chromedriver.exe");
    }




    @Test
    public void testTotalJobCount() {
        // Navigate to the homepage
        helper.navigateTo("https://www.seek.co.nz");
            
        String filePath = "TestData\\data.txt"; // Path to your CSV file
        List<String[]> csvData = readCSV(filePath);
        for (String[] row : csvData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
                
                helper.enterTextByName("keywords-input", cell);
                // Click on search button
                helper.clickElementByCSSId("button[data-automation='searchButton']");
                // Wait for search results to load
                try {
                    Thread.sleep(5000); // Adjust sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Get total jobs count
                String totalJobsCount = helper.getText("//span[@data-automation='totalJobsCount']");
                System.out.println("Total Jobs Count: " + totalJobsCount);
                
                
            }
            System.out.println();

        }
        

    }


	@Test
    public void testHomePageTitle() {
        // Navigate to the homepage
        helper.navigateTo("https://www.seek.co.nz");
        String actualTitle = helper.getPageTitle();
        String expectedTitle = "Jobs on SEEK - New Zealand's no. 1 Employment, Career and Recruitment site";
        Assert.assertEquals("Home Page Title Test Failed!", expectedTitle, actualTitle);
    }

    @Test
    public void testSuccessfulLogin() {
        // Navigate to login page
        helper.navigateTo("https://www.seek.co.nz/oauth/login/?returnUrl=%2F");
        // Enter email and password
        helper.enterTextByName("emailAddress", "Test1234@email.com");
        helper.enterTextByName("password", "ABCD4321");
        // Click on login button
        helper.clickElementByXpath("//button[@data-cy='login']");
        // Wait for page to load
        try {
            Thread.sleep(5000); // Adjust sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmployerSite() {
        // Navigate to Site
        helper.navigateTo("https://www.seek.co.nz");

        // Click on Employer site
        helper.clickElementByXpath("//a[@data-automation='employers_link']");
        // Wait for page to load
        try {
            Thread.sleep(5000); // Adjust sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = helper.getPageTitle();
        String expectedTitle = "SEEK Employer: Login & Find Talent";
        Assert.assertEquals("Employer Page Title Test Failed!", expectedTitle, actualTitle);
    }
    
    @After
    public void tearDown() {
        // Close the browser
        helper.closeBrowser();
    }
}