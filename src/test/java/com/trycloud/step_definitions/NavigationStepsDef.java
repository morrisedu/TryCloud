package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.Navigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.trycloud.pages.Navigation.linkIsDisplayed;
import static com.trycloud.utilities.ConfigReader.readProperty;
import static com.trycloud.utilities.Driver.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationStepsDef {
    @And("user clicks on {string}")
    public void userClicksOn(String str) {
        Navigation.goToLink(str);
    }

    @Then("user should be on the {string} page")
    public void userShouldBeOnThePage(String nav) {
        String expected_page = nav + " - Trycloud QA";
        System.out.println(expected_page);
        assertEquals(expected_page, getDriver().getTitle());
    }

    @Then("the following links should be displayed")
    public void shouldBeDisplayed(List<String> navs) {
        for (String nav : navs) {
            assertTrue(linkIsDisplayed(nav));
        }
    }
}
