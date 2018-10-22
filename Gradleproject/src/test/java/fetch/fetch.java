package fetch;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.logindata;

public class fetch extends fetchdata {
	public WebDriverWait wait;
	public WebDriver driver = logindata.driver;

	@Given("^verify fetch account page is displayed$")
	public void verify_fetch_account_page_is_displayed() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fetch)));
		Assert.assertTrue(driver.findElement(By.xpath(fetch)).isDisplayed());
	}

	@When("^verify fetch button and notificationbell icon is visible$")
	public void verify_fetch_button_and_notificationbell_icon_is_visible() {
		Assert.assertTrue(driver.findElement(By.xpath(fetch)).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath(bellnotification)).isEnabled());
		String accounttitletext = driver.findElement(By.xpath(accounttitle)).getText();
		Assert.assertEquals(accounttitledata, accounttitletext);
	}

	@Then("^verify all other elements are visible and click fetch button$")
	public void verify_all_other_elements_are_visible_and_click_fetch_button() {
		Assert.assertTrue(driver.findElement(By.xpath(formsettings)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(fieldsettings)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(addfield)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(form)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(scenario)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(contacts)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(details)).isDisplayed());
		String veiwintext = driver.findElement(By.xpath(viewin)).getText();
		System.out.println(veiwintext);
		Assert.assertEquals(viewindata, veiwintext);
		driver.findElement(By.xpath(viewindropdown)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewinsb)));
		Assert.assertTrue(driver.findElement(By.xpath(viewinsb)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(viewinsblinksymbol)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(viewincwa)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(viewincwasymbol)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(viewinds)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(viewindssymbol)).isDisplayed());
		driver.findElement(By.xpath(viewindropdown)).click();
		Assert.assertTrue(driver.findElement(By.xpath(qualityscorenotification)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(accountsettings)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(addform)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(fullscreenformbutton)).isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fetch)));
		driver.findElement(By.xpath(fetch)).click();
	}

	@Given("^Verify fetch popup is visible$")
	public void Verify_fetch_popup_is_visible() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fetchpopup)));
		String fetchpoptext = driver.findElement(By.xpath(fetchpopup)).getText();
		Assert.assertEquals(fetchpopupdata, fetchpoptext);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(account)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(load)));
		String loadtext = driver.findElement(By.xpath(load)).getText();
		Assert.assertEquals(loaddata, loadtext);
	}

	@When("^fetch account \"([^\"]*)\"$")
	public void fetch_account(String accountnumber) {
		driver.findElement(By.xpath(account)).clear();
		driver.findElement(By.xpath(account)).sendKeys(accountnumber);
		driver.findElement(By.xpath(load)).click();
	}

	@Then("^verify \"([^\"]*)\" account is fetched successfully$")
	public void verify_account_is_fetched_successfully(String status) throws InterruptedException {
		if (status.equalsIgnoreCase("fail")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invalidaccountnotification)));
			String invaliddata = driver.findElement(By.xpath(invalidaccountnotification)).getText();
			Assert.assertEquals(invalidaccountnotificationdata, invaliddata);
		} else if (status.equalsIgnoreCase("pass")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(validaccount)));
			String validaccounttext = driver.findElement(By.xpath(validaccount)).getText();
			Assert.assertEquals(validaccountdata, validaccounttext);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bellnotification)));
			driver.findElement(By.xpath(bellnotification)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(bellnotification2)).click();
		}
	}
}
