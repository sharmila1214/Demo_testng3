package Testng_demo.Testng_demo;

import org.testng.annotations.Test;

public class TC_LOGIN_DOM {

	@Test
	public void TC_Login_01() {
		System.out.println("TC_Login_01 Executed");
	}
	
	@Test(dependsOnMethods="TC_Login_01")
	public void TC_Login_02() {
		System.out.println("TC_Login_02 Executed");
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
