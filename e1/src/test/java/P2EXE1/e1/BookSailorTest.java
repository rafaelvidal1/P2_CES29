package P2EXE1.e1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = { "pretty", "html:target/cucumber" },
    features = "classpath:cucumber/calculator.feature"
)


public class BookSailorTest {

}
