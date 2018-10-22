package Contentsearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.logindata;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Contentsearch extends Contentsearchdata {
	public WebDriver driver=logindata.driver;
	public ExtentReports extent=logindata.extent;
	public ExtentTest test=logindata.test;
	public WebDriverWait wait;
	public ArrayList<String> tab;

	@Given("^Check whether the search is visible$")
	public void Check_whether_the_search_is_visible() {
		test = extent.startTest("Check_whether_the_search_is_visible");
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchbar)));
		boolean searchbarstatus = driver.findElement(By.xpath(searchbar)).isEnabled();
		Assert.assertTrue(searchbarstatus);
		if (searchbarstatus) {
			test.log(LogStatus.PASS, "Search bar is visible");
		} else {
			test.log(LogStatus.FAIL, "Search bar is not visible");
		}
	}

	@When("^search for content$")
	public void search_for_content() {
		try {
			test = extent.startTest("search_for_content");
			driver.findElement(By.xpath(searchbar)).sendKeys(searchbardata);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Search for content is visible");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Search for content is visible");
		}
	}

	@When("^Change the content$")
	public void Change_the_content() {
		try {
			test = extent.startTest("Change_the_content");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(fieldlabeldata);
			test.log(LogStatus.PASS, "Change content is sucessfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Change content is failed");
		}
	}

	@Then("^save the form$")
	public void save_the_form() throws InterruptedException {
		test = extent.startTest("save_the_form");
		Thread.sleep(3000);
		driver.findElement(By.xpath(saveform)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationsaveform)));
		String saveformtext = driver.findElement(By.xpath(notificationsaveform)).getText();
		Assert.assertEquals(notificationsaveformdata, saveformtext);
		if (notificationsaveformdata.equals(saveformtext)) {
			test.log(LogStatus.PASS, "Save the form is sucessfull");
		} else {
			test.log(LogStatus.FAIL, "Save the form is failed");
		}
	}

	@Given("^Goto to Scenario tab$")
	public void Goto_to_Scenario_tab() {
		try {
			test = extent.startTest("Goto_to_Scenario_tab");
			wait = new WebDriverWait(driver, 20);
			Thread.sleep(3000);
			driver.findElement(By.xpath(scenariotab)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addScenario)));
			boolean scenariotabvisible = driver.findElement(By.xpath(addScenario)).isDisplayed();
			if (scenariotabvisible) {
				test.log(LogStatus.PASS, "Scenario tab is visible");
			} else {
				test.log(LogStatus.FAIL, "Scenario tab is not visible");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@When("^Add new scenario and scenario steps$")
	public void Add_new_scenario_and_scenario_steps() {
		try {
			test = extent.startTest("Add_new_scenario_and_scenario_steps");
			String roletext = driver.findElement(By.xpath(roledropdown)).getAttribute("class");
			if (roledropdownclosed.equals(roletext)) {
				driver.findElement(By.xpath(roledropdown)).click();
			}
			driver.findElement(By.xpath(role)).click();
			String roleenabled = driver.findElement(By.xpath(role)).getAttribute("class");
			Assert.assertEquals(roleclass, roleenabled);
			driver.findElement(By.xpath(accountdescription)).clear();
			driver.findElement(By.xpath(accountdescription)).sendKeys(accountdescriptiondata);
			String afterhourstext = driver.findElement(By.xpath(addafterhoursrole)).getAttribute("class");
			if (addafterhourcheck.equals(afterhourstext)) {
				driver.findElement(By.xpath(addafterhoursrole)).click();
			}
			driver.findElement(By.xpath(afterhoursrole)).click();
			String afterhour = driver.findElement(By.xpath(afterhoursrole)).getAttribute("class");
			Assert.assertEquals(roleclass, afterhour);
			driver.findElement(By.xpath(saveRole)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rolesavenotification)));
			String rolesavetext = driver.findElement(By.xpath(rolesavenotification)).getText();
			Assert.assertEquals(rolesavenotificationdata, rolesavetext);
			driver.findElement(By.xpath(addScenario)).click();
			driver.findElement(By.xpath(renameScenario)).click();
			driver.findElement(By.xpath(renameScenario)).clear();
			driver.findElement(By.xpath(renameScenario)).sendKeys(electricalScenario);
			driver.findElement(By.xpath(scenariostep1)).click();
			driver.findElement(By.xpath(scenariostep1)).clear();
			driver.findElement(By.xpath(scenariostep1)).sendKeys(scenariostep1data);
			ArrayList<String> stepfield = new ArrayList<String>();
			stepfield.add(scenariostep2);
			stepfield.add(scenariostep3);
			stepfield.add(scenariostep4);
			stepfield.add(scenariostep5);
			ArrayList<String> stepfielddata = new ArrayList<String>();
			stepfielddata.add(scenariostep2data);
			stepfielddata.add(scenariostep3data);
			stepfielddata.add(scenariostep4data);
			stepfielddata.add(scenariostep5data);
			for (int i = 0; i <= 3; i++) {
				driver.findElement(By.xpath(addStep)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(stepfield.get(i))));
				driver.findElement(By.xpath(stepfield.get(i))).click();
				driver.findElement(By.xpath(stepfield.get(i))).clear();
				driver.findElement(By.xpath(stepfield.get(i))).sendKeys(stepfielddata.get(i));
			}
			test.log(LogStatus.PASS, "Scenario steps added successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Scenario steps adding is failed");
		}
	}

	@Then("^Verify new scenario is added$")
	public void Verify_new_scenario_is_added() {
		test = extent.startTest("Verify_new_scenario_is_added");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveScenario)));
		driver.findElement(By.xpath(saveScenario)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmSaveScenario)));
		driver.findElement(By.xpath(confirmSaveScenario)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(scenariosavenotification)));
		String scenariosavetext = driver.findElement(By.xpath(scenariosavenotification)).getText();
		Assert.assertEquals(scenariosavenotificationdata, scenariosavetext);
		if (scenariosavenotificationdata.equals(scenariosavetext)) {
			test.log(LogStatus.PASS, "Scenario Saved successfully");
		} else {
			test.log(LogStatus.FAIL, "Scenario not Saved");
		}
	}

	@Given("^Goto contacts tab and verify contact tab is opened$")
	public void Goto_contacts_tab_and_verify_contact_tab_is_opened() {
		try {
			test = extent.startTest("Goto_contacts_tab_and_verify_contact_tab_is_opened");
			driver.findElement(By.xpath(contactdetails)).click();
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(frame1)));
			boolean frame = driver.findElement(By.xpath(frame1)).isDisplayed();
			Assert.assertTrue(frame);
			driver.switchTo().frame(driver.findElement(By.xpath(frame1)));
			test.log(LogStatus.PASS, "Goto to contact tab and verified contact tab is opened successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Goto to contact tab and verify contact tab is open is failed");
		}
	}

	@When("^Add new contact$")
	public void Add_new_contact() {
		try {
			test = extent.startTest("Add_new_contact");
			driver.findElement(By.xpath(addcontacts)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(singlecontact)));
			driver.findElement(By.xpath(singlecontact)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contactname)));
			driver.findElement(By.xpath(contactname)).sendKeys(contactnamedata);
			ArrayList<String> fieldxpath = new ArrayList<String>();
			fieldxpath.add(addphonefield);
			fieldxpath.add(addemailfield);
			fieldxpath.add(addwebfield);
			fieldxpath.add(addfaxfield);
			fieldxpath.add(addtextfield);
			fieldxpath.add(addmailtext);
			fieldxpath.add(addmailatt);
			fieldxpath.add(addmailcsv);
			for (int i = 0; i < fieldxpath.size(); i++) {
				driver.findElement(By.xpath(addfield)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(fieldxpath.get(i))).click();
			}
			driver.findElement(By.xpath(countrycode)).click();
			driver.findElement(By.xpath(countryinput)).sendKeys(countrycodedata);
			driver.findElement(By.xpath(selectcode)).click();
			driver.findElement(By.xpath(addphonefieldinput)).click();
			driver.findElement(By.xpath(addphonefieldinput)).sendKeys(addphonefieldinputdata);
			driver.findElement(By.xpath(addphoneextension)).click();
			driver.findElement(By.xpath(addphoneextension)).sendKeys(addphoneextensiondata);
			ArrayList<String> fieldinput = new ArrayList<String>();
			fieldinput.add(addemailfieldinput);
			fieldinput.add(addwebfieldinput);
			fieldinput.add(addfaxfieldinput);
			fieldinput.add(addtextfieldinput);
			fieldinput.add(addmailtextinput);
			fieldinput.add(addmailattinput);
			fieldinput.add(addmailcsvinput);
			ArrayList<String> fielddata = new ArrayList<String>();
			fielddata.add(addemailfieldinputdata);
			fielddata.add(addwebfieldinputdata);
			fielddata.add(addfaxfieldinputdata);
			fielddata.add(addtextfieldinputdata);
			fielddata.add(addmailtextinputdata);
			fielddata.add(addmailattinputdata);
			fielddata.add(addmailcsvinputdata);
			for (int j = 0; j < fieldinput.size(); j++) {
				driver.findElement(By.xpath(fieldinput.get(j))).click();
				driver.findElement(By.xpath(fieldinput.get(j))).sendKeys(fielddata.get(j));
			}
			driver.switchTo().parentFrame();
			WebElement notificationcapture = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notification)));
			String notificationtext = notificationcapture.getText();
			if (notificationdata.equals(notificationtext)) {
				test.log(LogStatus.PASS, "Add new contact and saved successfully");
			} else {
				test.log(LogStatus.FAIL, "Add new contact and not saved");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Then("^add new delivery method$")
	public void add_new_delivery_method() throws InterruptedException {
		test = extent.startTest("add_new_delivery_method");
		driver.findElement(By.xpath(addgroup)).click();
		driver.switchTo().frame(driver.findElement(By.xpath(frame1)));
		driver.findElement(By.xpath(contacticon)).click();
		driver.findElement(By.xpath(emailmethod)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(phonemethod)).click();
		driver.findElement(By.xpath(addtogroup)).click();
		driver.findElement(By.xpath(addgroupname)).sendKeys(addgroupnamedata);
		driver.findElement(By.xpath(addgroupname)).sendKeys(Keys.ENTER);
		driver.switchTo().parentFrame();
		WebElement notificationcapture = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notification)));
		String notificationtext = notificationcapture.getText();
		if (notificationdata.equals(notificationtext)) {
			test.log(LogStatus.PASS, "Adding new Delivery method and saved successfully");
		} else {
			test.log(LogStatus.FAIL, "Adding new Delivery method and not saved");
		}
	}

	@Given("^Goto Detalis Tab$")
	public void Goto_Detalis_Tab() {
		try {
			test = extent.startTest("Goto_Detalis_Tab");
			wait = new WebDriverWait(driver, 20);
			Thread.sleep(3000);
			driver.findElement(By.xpath(details)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(detailstab)));
			boolean details = driver.findElement(By.xpath(detailstab)).isDisplayed();
			if (details) {
				test.log(LogStatus.PASS, "Details tab opened successfully");
			} else {
				test.log(LogStatus.FAIL, "Details tab not opened");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@When("^Add custom business hour$")
	public void Add_custom_business_hour() throws InterruptedException {
		try {
			test = extent.startTest("Add_custom_business_hour");
			Thread.sleep(3000);
			driver.findElement(By.xpath(businesshours)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timezone)));
			driver.findElement(By.xpath(timezone)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectzone)));
			driver.findElement(By.xpath(selectzone)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hours24)));
			String classattribute = driver.findElement(By.xpath(hours24)).getAttribute("class");
			String classattributecustom = driver.findElement(By.xpath(custom)).getAttribute("class");
			if (attribute.equals(classattributecustom)) {
				driver.findElement(By.xpath(hours24)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(custom)));
				driver.findElement(By.xpath(custom)).click();
			} else if (attribute.equals(classattribute)) {
				driver.findElement(By.xpath(custom)).click();
			}
			driver.findElement(By.xpath(monday)).click();
			driver.findElement(By.xpath(tuesday)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(tohours)).clear();
			driver.findElement(By.xpath(tohours)).sendKeys(tohoursdata);
			Thread.sleep(3000);
			driver.findElement(By.xpath(addhours)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(fromtime)).clear();
			driver.findElement(By.xpath(fromtime)).sendKeys(fromtimedata);
			driver.findElement(By.xpath(totime)).clear();
			driver.findElement(By.xpath(totime)).sendKeys(totimedata);
			driver.findElement(By.xpath(wednesday)).click();
			driver.findElement(By.xpath(thursday)).click();
			driver.findElement(By.xpath(friday)).click();
			WebElement notificationcapture = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contactnotifications)));
			String notificationtext = notificationcapture.getText();
			if (contactnotificationdata.equals(notificationtext)) {
				System.out.println("Saved successfully");
			} else {
				System.out.println("Not saved");

			}
			driver.findElement(By.xpath(noteforhours)).clear();
			driver.findElement(By.xpath(noteforhours)).sendKeys(noteforhoursdata);
			test.log(LogStatus.PASS, "Adding custom Business hour is successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Adding custom Business hour is failed");
		}
	}

	@When("^add new holiday$")
	public void add_new_holiday() {
		try {
			test = extent.startTest("add_new_holiday");
			String todaydate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
			System.out.println(todaydate);
			driver.findElement(By.xpath(closuresholidays)).click();
			driver.findElement(By.xpath(addholiday)).click();
			Thread.sleep(3000);
			String adddefaultholiday=driver.findElement(By.xpath(adddefault)).getAttribute("class");
			if(adddefaultoff.equals(adddefaultholiday)) {
				driver.findElement(By.xpath(adddefault)).click();
			}
			driver.findElement(By.xpath(addcustomholiday)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(datecalender)).click();
			driver.findElement(By.xpath(selectdate)).click();
			driver.findElement(By.xpath(datecalender)).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(holidaytitle)).sendKeys(holidaytitledata);
			Thread.sleep(3000);
			driver.findElement(By.xpath(addnote)).click();
			driver.findElement(By.xpath(addnotefield)).sendKeys(addnotedata);
			driver.findElement(By.xpath(repeatityearly)).click();
			driver.findElement(By.xpath(saveholiday)).click();
			WebElement lesserdatenotificationcapture = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(holidaynotadded)));
			String lesserdatenotificationtext = lesserdatenotificationcapture.getText();
			if (holidaynotaddeddata.equals(lesserdatenotificationtext)) {
				driver.findElement(By.xpath(datecalender)).click();
				driver.findElement(By.xpath(datecalender)).clear();
				driver.findElement(By.xpath(datecalender)).sendKeys(todaydate);
				driver.findElement(By.xpath(datecalender)).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath(holidaytitle)).clear();
				driver.findElement(By.xpath(holidaytitle)).sendKeys(holidaycurrentdata);
				driver.findElement(By.xpath(addnotefield)).clear();
				driver.findElement(By.xpath(addnotefield)).sendKeys(addnotecurrentdata);
				driver.findElement(By.xpath(saveholiday)).click();
				WebElement holidaynotificationcapture = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(holidaynotification)));
				String holidaynotificationtext = holidaynotificationcapture.getText();
				System.out.println(holidaynotificationtext);
				if (holidaynotificationdata.equals(holidaynotificationtext)) {
					System.out.println("Holiday added successfully");
				} else {
					System.out.println("Holiday Not added");
				}
			} else {
				System.out.println("Holiday added successfully");
			}
			test.log(LogStatus.PASS, "Adding new holiday is successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Adding new holiday is failed");
		}
	}

	@Given("^when search bar is visible$")
	public void when_search_bar_is_visible() {
		test = extent.startTest("when_search_bar_is_visible");
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchbar)));
		boolean searchbarstatus = driver.findElement(By.xpath(searchbar)).isEnabled();
		Assert.assertTrue(searchbarstatus);
		if (searchbarstatus) {
			test.log(LogStatus.PASS, "Search bar is visible");
		} else {
			test.log(LogStatus.FAIL, "Search bar is not visible");
		}
	}

	@When("^search for business hours and holiday and account details$")
	public void search_for_business_hours_and_holiday_and_account_details() throws InterruptedException {
		test = extent.startTest("search_for_business_hours_and_holiday_and_account_details");
		driver.findElement(By.xpath(searchbar)).sendKeys(searchbusinesshours);
		driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchbusinessvisible)));
		boolean businesshours = driver.findElement(By.xpath(searchbusinessvisible)).isDisplayed();
		Assert.assertTrue(businesshours);
		Thread.sleep(3000);
		driver.findElement(By.xpath(searchbar)).sendKeys(searchholidays);
		driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchholidaysvisible)));
		boolean holidays = driver.findElement(By.xpath(searchholidaysvisible)).isDisplayed();
		Assert.assertTrue(holidays);
		Thread.sleep(3000);
		driver.findElement(By.xpath(searchbar)).sendKeys(searchaccountdetails);
		driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchaccountdetailsvisible)));
		boolean accountdetails = driver.findElement(By.xpath(searchaccountdetailsvisible)).isDisplayed();
		Assert.assertTrue(accountdetails);
		Thread.sleep(3000);
		if (businesshours && holidays && accountdetails) {
			test.log(LogStatus.PASS,
					"business hours, holiday and account details are searched and it is displayed sucessfully");
		} else {
			test.log(LogStatus.FAIL,
					"business hours, holiday and account details are searched and it is not display");
		}
	}

	@Then("^search for contact and delivery method$")
	public void search_for_contact_and_delivery_method() throws InterruptedException {
		test = extent.startTest("search_for_contact_and_delivery_method");
		driver.findElement(By.xpath(searchbar)).sendKeys(searchcontact);
		driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
		driver.switchTo().frame(driver.findElement(By.xpath(frame1)));
		String contact = driver.findElement(By.xpath(searchcontactvisible)).getAttribute("class");
		Assert.assertEquals(searchcontactvisibledata, contact);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath(searchbar)).sendKeys(searchdeliverymethod);
		driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
		driver.switchTo().frame(driver.findElement(By.xpath(frame1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchdeliverymethodvisible)));
		String deliverymethod = driver.findElement(By.xpath(searchdeliverymethodvisible)).getAttribute("class");
		Assert.assertEquals(searchdeliverymethodvisibledata, deliverymethod);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		if ((searchcontactvisibledata.equals(contact)) && (searchdeliverymethodvisibledata.equals(deliverymethod))) {
			test.log(LogStatus.PASS, "Contact and delivery method Searched and it is diplayed successfully");
		} else {
			test.log(LogStatus.FAIL, "Contact and delivery method Searched and it is not diplayed");
		}
	}

	@Then("^search for add field and field settings and form settings and form$")
	public void search_for_add_field_and_field_settings_and_form_settings_and_form() {
		try {
			test = extent
					.startTest("search_for_add_field_and_field_settings_and_form_settings_and_form");
			driver.findElement(By.xpath(searchbar)).sendKeys(searchaddfield);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchaddfieldvisible)));
			boolean addfield = driver.findElement(By.xpath(searchaddfieldvisible)).isDisplayed();
			Assert.assertTrue(addfield);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchfieldsettings);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchfieldsettingsvisible)));
			boolean fieldsettings = driver.findElement(By.xpath(searchfieldsettingsvisible)).isDisplayed();
			Assert.assertTrue(fieldsettings);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchformsettings);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchformsettingsvisible)));
			boolean formsettings = driver.findElement(By.xpath(searchformsettingsvisible)).isDisplayed();
			Assert.assertTrue(formsettings);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchform);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchformvisible)));
			String formtext = driver.findElement(By.xpath(searchformvisible)).getAttribute("class");
			Assert.assertEquals(searchformvisibledata, formtext);
			Thread.sleep(3000);
			test.log(LogStatus.PASS,
					"Form, Add field, fieldsettings and form settings Searched and it is diplayed successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL,
					"Form, Add field, fieldsettings and form settings Searched and it is not diplayed");
		}
	}

	@Then("^search for form tab and scenario tab and contact tab and details tab$")
	public void search_for_form_tab_and_scenario_tab_and_contact_tab_and_details_tab() {
		try {
			test = extent.startTest("search_for_form_tab_and_scenario_tab_and_contact_tab_and_details_tab");
			driver.findElement(By.xpath(searchbar)).sendKeys(searchquailtyscore);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchqualityscorevisible)));
			boolean quailtyscore = driver.findElement(By.xpath(searchqualityscorevisible)).isDisplayed();
			Assert.assertTrue(quailtyscore);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchformtab);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchformtabvisible)));
			boolean formtab = driver.findElement(By.xpath(searchformtabvisible)).isDisplayed();
			Assert.assertTrue(formtab);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchscenariotab);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchscenariotabvisible)));
			boolean scenariotab = driver.findElement(By.xpath(searchscenariotabvisible)).isDisplayed();
			Assert.assertTrue(scenariotab);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchcontacttab);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchcontacttabvisible)));
			boolean contacttab = driver.findElement(By.xpath(searchcontacttabvisible)).isDisplayed();
			Assert.assertTrue(contacttab);
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchbar)).sendKeys(searchdetailstab);
			driver.findElement(By.xpath(searchbar)).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchdetailstabvisible)));
			boolean detailstab = driver.findElement(By.xpath(searchdetailstabvisible)).isDisplayed();
			Assert.assertTrue(detailstab);
			Thread.sleep(3000);
			test.log(LogStatus.PASS,
					"Quailty score and form tab, scenario tab, contacts tab, and details tab Searched and it is diplayed successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL,
					"Quailty score and form tab, scenario tab, contacts tab, and details tab Searched and it is not diplayed");
		}
	}

	@Given("^veiwin switch board$")
	public void veiwin_switch_board() throws InterruptedException {
		try {
			test = extent.startTest("veiwin_switch_board");
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewindropdown)));
			driver.findElement(By.xpath(viewindropdown)).click();
			driver.findElement(By.xpath(viewinsb)).click();
			test.log(LogStatus.PASS, "Veiwin switch board is sucessfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Veiwin switch board is failed");
		}
	}

	@Given("^when switch board opened$")
	public void when_switch_board_opened() {
		try {
			test = extent.startTest("when_switch_board_opened");
			tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup)));
			driver.findElement(By.xpath(closepopup)).click();
			test.log(LogStatus.PASS, "Verify switch board is opened sucessfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Verify switch board is opened is failed");
		}
	}

	@When("^verify content changed$")
	public void verify_content_changed() {
		test = extent.startTest("verify_content_changed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyscriptingfield)));
		String scriptingfieldtext = driver.findElement(By.xpath(verifyscriptingfield)).getText();
		System.out.println(scriptingfieldtext);
		Assert.assertEquals(verifyscriptingfielddata, scriptingfieldtext);
		if (verifyscriptingfielddata.equals(scriptingfieldtext)) {
			test.log(LogStatus.PASS, "Verify content changed in switch board is sucessfull");
		} else {
			test.log(LogStatus.FAIL, "Verify content changed in switch board is failed");
		}
	}

	@Then("^close switch board$")
	public void close_switch_board() {
		try {
			test = extent.startTest("close_switch_board");
			driver.close();
			test.log(LogStatus.PASS, "Close switch board is sucessfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Close switch board is failed");
		}
	}

	@Then("^back to form creator$")
	public void back_to_form_creator() {
		test = extent.startTest("back_to_form_creator");
		driver.switchTo().window(tab.get(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fetch)));
		boolean enabled = driver.findElement(By.xpath(fetch)).isEnabled();
		if (enabled) {
			test.log(LogStatus.PASS, "Verify back to form creator is sucessfull");
		} else {
			test.log(LogStatus.FAIL, "Verify back to form creator is failed");
		}
		extent.flush();
	}
}
