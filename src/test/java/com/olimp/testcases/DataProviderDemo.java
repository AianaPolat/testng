package com.olimp.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olimp.utils.ExcelUtility;

public class DataProviderDemo {

	@Test(dataProvider = "ExcelData")
	public void printInformation(String name, String lastName, String age) {
		System.out.println("Full Name and Age -> " + name + " " + lastName + " " + age);
	}

	@DataProvider(name = "hardCoded")
	public Object[][] createData() {
		Object[][] data = { 
				{ "Zarina", "Dustova", "18" }, 
				{ "Asli", "Ozel", "22" }, 
				{ "Nidaa", "Al Jebur", "24" } 
		};
		return data;
	}

	@DataProvider(name = "ExcelData")
	public Object[][] getExcelData() {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/DataProviderDemo.xlsx";
		String sheet = "Data";
		return ExcelUtility.excelIntoArray(path, sheet);
	}

}
