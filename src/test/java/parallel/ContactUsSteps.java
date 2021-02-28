package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ContactUsPage;
import com.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	private ContactUsPage contactUsSteps = new ContactUsPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");

	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {

		ExcelReader reader = new ExcelReader();
		try {
			List<Map<String, String>> testData = reader.getData("D:\\TestDataFiles\\Automation.xlsx", sheetName);
			String heading = testData.get(rowNumber).get("Subject Heading");
			String email = testData.get(rowNumber).get("Email address");
			String message = testData.get(rowNumber).get("Message");

			contactUsSteps.fillContactUsForm(heading, email, message);

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsSteps.clickSend();

	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expectedSucessMessage) {
		String actualSuccessMessg = contactUsSteps.getSuccessMessg();
		Assert.assertEquals(actualSuccessMessg, expectedSucessMessage);

	}

}
