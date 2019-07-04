package cricbuzzrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;

import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions (
       features = {"D:\\kalaimani workspace\\cricbuzz\\Cricbuzz\\src\\main\\java\\cricbuz\\crickbuzz.feature"}
       ,glue = {" stepdefination"},
plugin= { "pretty",
               "html:target/site/cucumber-pretty",
       "json:target/cucumber.json" },	
       monochrome = true) 
/*,plugin= { "pretty",
               "html:target/site/cucumber-pretty",
       "json:target/cucumber.json" },
       monochrome = true)*/	
       public class Runner {
   private TestNGCucumberRunner testNGCucumberRunner;
   
   @BeforeClass(alwaysRun = true)
   public void setUpClass() throws Exception {    	
       testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
   }

   @Test(dataProvider = "features")    
   public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
   	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
   	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
   }
   
   @DataProvider//(parallel=true)
   public Object[][] features() {
      // return testNGCucumberRunner.provideFeatures();    	
   	return testNGCucumberRunner.provideFeatures();
   }
   
   @AfterClass(alwaysRun = true)
   public void tearDownClass() throws Exception {    	
       testNGCucumberRunner.finish();        
   }
}


