package cricbuzzrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.ObjectBuffer;

@CucumberOptions(
		features="src/main/java/cricbuz",
		glue= {"stepdefination"},
		tags= {"~@Ignore"},
		format= {"pretty",
				  "html:target/cucumber-reports/cucumber-pretty",
				  "json:target/cucumber-reports/cucumberTestReport.json",
				  "rerun:target/cucumber-reports/rerun.txt"
				  },plugin = "json:target/cucumber-reports/CucumberTestReport.json"
				
		)


public class Runner {
	private static final boolean ture = false;
	private TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass(alwaysRun=true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
	}

	
   @Test(groups="cucmber",description="Run cucumber Feature",dataProvider="feature")
   public void feature(CucumberFeatureWrapper cucumberfeature) {
	  testNGCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature()); 
   }
   @DataProvider
   public ObjectBuffer[][]features(){
	   return (ObjectBuffer[][]) testNGCucumberRunner.provideFeatures();
	   
   }
   @AfterClass(alwaysRun= ture)
   public void tearDownClass() throws Exception{
	   testNGCucumberRunner.finish();
	   
   }
}
