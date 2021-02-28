package parallel;


import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the Page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title : " + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title : " + title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotLinkPwdLinkExist());
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("User Clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}
	
	

}
