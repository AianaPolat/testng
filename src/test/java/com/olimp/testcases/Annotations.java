package com.olimp.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

//	public static void main(String[] args) {
//		System.out.println("Moe is very funny!!!");
//	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Creating a report...");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Saving the report...");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Opening the browser");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser");
	}

	@Test
	public void test1() {
		System.out.println("Adding an Employee!!!");
	}

	@Test
	public void test2() {
		System.out.println("Deleting an Employee!!!");
	}

}
