package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trycloud.utilities.Driver.getDriver;

public class FilesPage {
    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement select_all_files;

    public FilesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void selectAllFiles() {
        if (!select_all_files.isSelected()) {
            select_all_files.click();
        }
    }
}
