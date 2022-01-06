package com.rkoyanagui.rest_assured_demo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"classpath:features"},
    plugin = {
        "pretty",
        "json:target/cucumber-report/DemoTest.json"
    },
    strict = true
)
public class DemoTest extends AbstractTestNGCucumberTests
{
  @DataProvider(parallel = true)
  @Override
  public Object[][] scenarios()
  {
    return super.scenarios();
  }
}
