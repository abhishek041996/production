package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin= {},features="src/test/resources/features/EmcUi.feature",
tags="@apitest1",
glue={"steps"},monochrome=true,publish = true)
public class emcUi {
	@BeforeClass
	public  static void  get() {
    

}
}
