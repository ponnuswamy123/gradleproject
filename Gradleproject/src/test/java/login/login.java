package login;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login extends logindata {

	public WebDriverWait wait;

	@Given("^Verify the browser is opened$")
	public void Verify_the_browser_is_opened() {
		String title = driver.getTitle();
		String titledata = "";
		if (titledata.equals(title)) {
			System.out.println("Browser is opened successfully");
		} else {
			System.out.println("Browser is open is failed");
		}
	}

	@When("^Fetch FC URL$")
	public void Fetch_FC_URL() {
		driver.get(URL);
	}

	@Then("^verify FC text is visible$")
	public void verify_FC_text_is_visible() {
		String brandname = driver.findElement(By.xpath(pagetitle)).getText();
		Assert.assertEquals(pagetitledata, brandname);
	}

	@Then("^verify email password text box and signin button is enabled$")
	public void verify_email_password_text_box_and_signin_button_is_enabled() {
		boolean emailvisible = driver.findElement(By.xpath(email)).isEnabled();
		Assert.assertTrue(emailvisible);
		boolean passwordvisible = driver.findElement(By.xpath(password)).isEnabled();
		Assert.assertTrue(passwordvisible);
		boolean signinbuttonvisible = driver.findElement(By.xpath(signinbutton)).isEnabled();
		Assert.assertTrue(signinbuttonvisible);
	}

	@Then("^verify show and hide option in password text box and or text is visible$")
	public void verify_show_and_hide_option_in_password_text_box_and_or_text_is_visible() throws InterruptedException {
		String emailplaceholder = driver.findElement(By.xpath(email)).getAttribute("placeholder");
		Assert.assertEquals(emailbox, emailplaceholder);
		String passwordplaceholder = driver.findElement(By.xpath(password)).getAttribute("placeholder");
		Assert.assertEquals(passwordbox, passwordplaceholder);
		boolean passwordshowbutton = driver.findElement(By.xpath(showorhide)).isEnabled();
		Assert.assertTrue(passwordshowbutton);
		String passwordtype = driver.findElement(By.xpath(password)).getAttribute("type");
		if (passwordhide.equals(passwordtype)) {
			driver.findElement(By.xpath(showorhide)).click();
		} else {
			driver.findElement(By.xpath(showorhide)).click();
		}
		String passwordhidetype = driver.findElement(By.xpath(password)).getAttribute("type");
		if (passwordshow.equals(passwordhidetype)) {
			driver.findElement(By.xpath(showorhide)).click();
		} else {
			driver.findElement(By.xpath(showorhide)).click();
		}
		String ortext = driver.findElement(By.xpath(ortextvisible)).getText();
		Assert.assertEquals(ortextdata, ortext);
	}

	@Then("^verify signin text email and facebook button is enabled$")
	public void verify_signin_text_email_and_facebook_button_is_enabled() {
		String signintitlevisible = driver.findElement(By.xpath(signintitle)).getText();
		Assert.assertEquals(signintitledata, signintitlevisible);
		boolean gmailiconvisible = driver.findElement(By.xpath(gmailicon)).isDisplayed();
		Assert.assertTrue(gmailiconvisible);
		boolean facebookiconvisible = driver.findElement(By.xpath(facebookicon)).isDisplayed();
		Assert.assertTrue(facebookiconvisible);
	}

	@Given("^when email and passwrod text box is enabled$")
	public void when_email_and_passwrod_text_box_is_enabled() {
		wait = new WebDriverWait(driver, 20);
		boolean emailvisible = driver.findElement(By.xpath(email)).isEnabled();
		Assert.assertTrue(emailvisible);
		boolean passwordvisible = driver.findElement(By.xpath(password)).isEnabled();
		Assert.assertTrue(passwordvisible);
		boolean signinbuttonvisible = driver.findElement(By.xpath(signinbutton)).isEnabled();
		Assert.assertTrue(signinbuttonvisible);
	}

	@When("^Enter email id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void Enter_email_id_and_password(String username, String userpassword) {
		driver.findElement(By.xpath(email)).clear();
		driver.findElement(By.xpath(email)).sendKeys(username);
		driver.findElement(By.xpath(password)).clear();
		driver.findElement(By.xpath(password)).sendKeys(userpassword);
		driver.findElement(By.xpath(signinbutton)).click();
	}

	@Then("^Verify login is sucessfully done with \"([^\"]*)\"$")
	public void Verify_login_is_sucessfully_done_with(String status) {
		if (status.equalsIgnoreCase("fail")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invalidemail)));
			Assert.assertTrue(driver.findElement(By.xpath(invalidemail)).isDisplayed());
		} else if (status.equalsIgnoreCase("pass")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fetch)));
			Assert.assertTrue(driver.findElement(By.xpath(fetch)).isEnabled());
		}
	}

}
