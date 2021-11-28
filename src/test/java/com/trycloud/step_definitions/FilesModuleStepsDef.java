package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.Navigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.trycloud.utilities.BrowserUtil.waitFor;
import static com.trycloud.utilities.Driver.getDriver;
import static org.junit.Assert.assertTrue;

public class FilesModuleStepsDef {
    FilesPage files = new FilesPage();

    @And("user navigates to the {string} module")
    public void userNavigatesToTheModule(String nav) {
        Navigation.goToLink(nav);
    }

    @Then("user should be redirected to the files module page")
    public void userShouldBeAbleToAccessThePage() {
        assertTrue(getDriver().findElement(By.xpath("//a[.='All files']")).isDisplayed());
    }

    @When("user clicks on the select all files button")
    public void userClicksOnTheSelectAllFilesButton() {
        files.selectAllFiles();
    }

    @Then("all uploaded files should be selected")
    public void allUploadedFilesShouldBeSelected() {

        waitFor(30);

        List<WebElement> all_files = getDriver().findElements(By.xpath("//input[@class='selectCheckBox checkbox']"));

        for (WebElement file : all_files) {
            assertTrue(file.isSelected());
        }
    }
}
