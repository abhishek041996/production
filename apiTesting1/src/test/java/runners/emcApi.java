package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import Apis.firebaseDelete;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin=   {"pretty"},
features="src/test/resources/features/EmcApi.feature",
tags="@EmcTest",
glue={"steps"},
monochrome=true, 
publish = true)
public class emcApi {
	@BeforeClass 
    public static void test1() {
    	firebaseDelete delete=new firebaseDelete();
    	delete.test();
}
}