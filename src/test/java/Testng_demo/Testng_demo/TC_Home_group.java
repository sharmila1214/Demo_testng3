package Testng_demo.Testng_demo;

import org.testng.annotations.Test;

public class TC_Home_group {

	@Test(groups="Regression")
	public void TC_Home_01() {
		System.out.println("TC_Home_01 Executed");
	}
	
	@Test(groups="Sanity")
	public void TC_Home_02() {
		System.out.println("TC_Home_02 Executed");
	}
}
