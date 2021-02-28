package parallel;


import io.cucumber.testng.CucumberOptions;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/parallel" }, glue = { "parallel" }, plugin = {
		"pretty" }, monochrome = true)
public class MySerenityTestRunner {

}
