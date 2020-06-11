package Testng_demo.Testng_demo;

import org.testng.annotations.Test;

public class TC_Login_group {

	@Test(groups="Regression")
	public void TC_login_01() {
		System.out.println("TC_login_01 Executed");
	}
	
	@Test(groups="Sanity")
	public void TC_login_02() {
		System.out.println("TC_login_02 Executed");
	}
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}




}
