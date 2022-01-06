package com.rkoyanagui.rest_assured_demo.steps;

import com.rkoyanagui.rest_assured_demo.core.config.BasicConfig;
import com.rkoyanagui.rest_assured_demo.utils.Keys;
import com.rkoyanagui.rest_assured_demo.utils.World;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
    BasicConfig.class
})
@Slf4j
public class Hooks
{
  @Autowired
  private World world;

  @After
  public void teardown(Scenario scenario)
  {
    if (scenario.isFailed())
    {
      world.<Response>getOpt(Keys.RESPONSE)
          .ifPresent(response -> scenario.embed(
              response.asByteArray(),
              "text/json;charset=utf-8",
              "response"
          ));
    }

    // Discards all test context data.
    try
    {
      world.close();
    }
    catch (Exception x)
    {
      LOG.error("Could not close 'World' (test context)!", x);
    }
  }
}
