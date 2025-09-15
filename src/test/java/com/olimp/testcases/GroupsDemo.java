package com.olimp.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupsDemo {

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Creating a report...");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("Saving the report...");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("Opening the browser");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("Closing the browser");
	}

	@Test(priority = 1, groups = { "group1", "group2" }, dependsOnMethods = "test2")
	public void test1() {
		System.out.println("Adding an Employee in Groups Demo!!!");
	}

	@Test(priority = 3, groups = { "group1" })
	public void test2() {
		System.out.println("Deleting an Employee in Groups Demo!!!");
	}

}
