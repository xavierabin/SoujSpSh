package StepDefinitions;

import org.junit.runner.RunWith;

/*import java.sql.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import org.junit.*;*/

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"}, monochrome=true,plugin = { "pretty", "html:target/SpeedShieldTestReports/report.html"})
//@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"}, monochrome=true,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class TestRunner {

	
}
