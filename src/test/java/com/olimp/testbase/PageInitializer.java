package com.olimp.testbase;

import com.olimp.pages.AddEmployeePageElements;
import com.olimp.pages.DashboardPageElements;
import com.olimp.pages.LoginPageElements;
import com.olimp.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {
	public static LoginPageElements loginPage;
	public static DashboardPageElements dashboardPage;
	public static AddEmployeePageElements addEmployeePage;
	public static PersonalDetailsPageElements personalDetailsPage;
	
	
	public static void initialize()
	{
		
		 loginPage = new LoginPageElements();
		 dashboardPage = new DashboardPageElements();
		 addEmployeePage = new AddEmployeePageElements();
		 personalDetailsPage = new PersonalDetailsPageElements();

		
	}
	
	
}
