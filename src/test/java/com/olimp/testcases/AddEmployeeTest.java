package com.olimp.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olimp.pages.AddEmployeePageElements;
import com.olimp.pages.DashboardPageElements;
import com.olimp.pages.LoginPageElements;
import com.olimp.pages.PersonalDetailsPageElements;
import com.olimp.utils.CommonMethods;
import com.olimp.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{

	@Test(dataProvider = "excelData", groups= {"addEmployee", "regression"})
	public void addEmployee(String firstName, String lastName, String username, String password, String location)
	{
		/*
		 * 
		 * Definitely not needed after we added PageInitializer
		
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboardPage = new DashboardPageElements();
		AddEmployeePageElements addEmployeePage = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetailsPage = new PersonalDetailsPageElements();
		
		*/
		//log information about the test
		test.info("Testing employee data: " + firstName + " " + lastName);
		
		//The test object depends on the Listener onTestStart() method. If you do not use the Listener
		//the test object will not be instantiated  (you will get NullPointerException
		test.info("Logging in....");
		//Login
		loginPage.adminLogin();
		
		click(dashboardPage.PIM);
		click(dashboardPage.addEmployeeLink);
		
		test.info("Adding employee...");
		//send new employee info
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
		
		//get emp Id for verification
		String employeeId = addEmployeePage.employeeId.getAttribute("value");
		
		//select a location 
		selectDropdown(addEmployeePage.location, location);
		
		//click on toggle button to add emp login details
		jsClick(addEmployeePage.loginDetailsToggle);
		
		//send credentials
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);

		wait(3);
		
		click(addEmployeePage.saveButton);
		
		
		waitForVisibility(personalDetailsPage.firstName);
		
		String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
		
		test.info("Validating employee...");
		Assert.assertEquals(actualEmployeeId, employeeId, "Employee ID did NOT match!!!");
		
	}
	
	/*
	 Will give mutliple entries for employees in this format:
	 FirstName 			LastName			UserName		Password		Location
	 
	 */
	@DataProvider(name="excelData")
	public Object[][] createData()
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		return ExcelUtility.excelIntoArray(path, "Employee");
		
	}
	
	
}
