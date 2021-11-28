package com.trycloud.step_definitions;

import io.cucumber.java.en.Then;

import static com.trycloud.utilities.BrowserUtil.waitFor;

public class UnitTestStepsDef {
    @Then("wait for {int} seconds then close")
    public void waitForSecondsThenClose(int secs) {
        waitFor(secs);
    }
}
