package runners;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import appApi.token;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
	

	

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(plugin= {},features="C://Users//Abhishek//eclipse-workspace//apiTesting1//src//test//java//feature//test.feature",
	tags="@profileUpdate",
	glue={"steps"},monochrome=true,publish = true)
	public class appApi  {
		@BeforeClass
		public  static void  get() {
        token y=new token();
		
		y.test();
	}
	}
