package Testng_demo.Testng_demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_testng {

	@Test
	public void e1() {
	System.out.println("this is my first code");	
	}
	@BeforeSuite
	public void e2() {
		System.out.println("this is my e2 code:@BeforeSuite");	
		}
	@AfterSuite
	public void e3() {
		System.out.println("this is my e3 code:@AfterSuite");	
		}
	@BeforeTest
	public void e4() {
			System.out.println("this is my e4 code:@BeforeTest");	
			}
	@AfterTest
	public void e5() {
			System.out.println("this is my e5 code:@AfterTest");	
			}

	@BeforeClass
	public void e6() {
			System.out.println("this is my e6 code:@BeforeClass");	
			}
	@AfterClass
	public void e7() {
			System.out.println("this is my e7 code:@AfterClass");	
			}

	@BeforeMethod
	public void e8() {
			System.out.println("this is my e8 code:@BeforeMethod");	
			}
	@AfterMethod
	public void e9() {
			System.out.println("this is my e9 code:@AfterMethod");	
			}
	@BeforeGroups
	public void e10() {
			System.out.println("this is my e10 code:@@BeforeGroups");	
			}
	@AfterGroups
	public void e11() {
			System.out.println("this is my e11 code:@Afetrgroups");	
			}




}
