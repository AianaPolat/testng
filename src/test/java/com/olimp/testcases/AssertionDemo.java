package com.olimp.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	@Test
	public void test1() {
		String expected = "Adem";
		String actual = "Adam";

		Assert.assertEquals(actual, expected);

		// Will this line be executed?
		// If the assertion fails, this line will NOT be executed
		System.out.println("End of code!");
	}

	@Test
	public void test2() {
		int expected = 61;
		int actual = 26;

		Assert.assertEquals(actual, expected, "Numbers did NOT match!");
	}

	@Test
	public void test3() {

		// When I logging I am expecting this list in the menu
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("Admin");
		expectedList.add("PIM");
		expectedList.add("My Info");
		expectedList.add("Discipline");

		// When I logging I am reading this list in the menu
		ArrayList<String> actualList = new ArrayList<>();
		actualList.add("Admin");
		actualList.add("PIM");
		actualList.add("My Info");
		actualList.add("Discipline");

		Assert.assertEquals(actualList, expectedList);
	}

	@Test
	public void test4() {
		boolean result = true;

		Assert.assertTrue(result);
	}

	@Test
	public void test5() {

		// With SoftAssert, we can run multiple independent assertions in the same
		// @Test.
		SoftAssert softAssert = new SoftAssert();

		String expected = "break";
		String actual = "task";

		softAssert.assertEquals(actual, expected);

		// Will this line be executed? YES
		System.out.println("End of code!");

		boolean result = true;
		softAssert.assertFalse(result);

		int age1 = 25;
		int age2 = 25;
		softAssert.assertEquals(age1, age2);

		// This is the REAL checkpoint. This is the MAN part of softAssert :)
		softAssert.assertAll();
	}

}
