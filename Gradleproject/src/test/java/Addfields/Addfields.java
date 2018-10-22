package Addfields;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.logindata;
public class Addfields extends Addfieldsdata {
public WebDriver driver=logindata.driver;
public ExtentReports extent=logindata.extent;
public ExtentTest test=logindata.test;

	public WebDriverWait wait;
	public Robot rb;
	public ArrayList<String> tab;

	public void addfield(String s) {
		test = extent.startTest(s);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfieldcontainer)));
		boolean fieldcontainer = driver.findElement(By.xpath(addfieldcontainer)).isDisplayed();
		if (fieldcontainer) {
			test.log(LogStatus.PASS, "Add field container is visible");
		} else {
			test.log(LogStatus.FAIL, "Add field container is not visible");
		}
	}

	public void gotofieldsettings(String s, String fields, String result) {
		test = extent.startTest(s);
		driver.findElement(By.xpath(fields)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldsettingscontainer)));
		boolean settingscontainervisible = driver.findElement(By.xpath(fieldsettingscontainer)).isDisplayed();
		if (settingscontainervisible) {
			test.log(LogStatus.PASS, "goto " + result + "field settings is successfully");
		} else {
			test.log(LogStatus.FAIL, "goto " + result + "field settings is failed");
		}
	}

	public void textlength(String s, String lengthdata, String result) {
		try {
			test = extent.startTest(s);
			driver.findElement(By.xpath(textlength)).clear();
			driver.findElement(By.xpath(textlength)).sendKeys(lengthdata);
			test.log(LogStatus.PASS, "Changing text length for " + result + "field is successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing text length for " + result + "field is failed");
		}
	}

	public void restrictspecialcharacter(String s, String restrictdata, String result) {
		try {
			test = extent.startTest(s);
			driver.findElement(By.xpath(restrictspecialcharacter)).sendKeys(restrictdata);
			test.log(LogStatus.PASS, "Changing restrict special character for " + result + "field is successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing restrict special character for " + result + "field is failed");
		}
	}

	public void agentverification(String s, String result) {
		test = extent.startTest(s);
		driver.findElement(By.xpath(agentverification)).click();
		String agenttext = driver.findElement(By.xpath(agentverification)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, agenttext);
		if (toggleverifyondata.equals(agenttext)) {
			test.log(LogStatus.PASS, "Enable agent verification for " + result + "field is successfully");
		} else {
			test.log(LogStatus.FAIL, "Enable agent verification for " + result + "field is failed");
		}
	}

	
	@Given("^when add form button is visible$")
	public void when_add_form_button_is_visible() {
		test = extent.startTest("when_add_form_button_is_visible");
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addformbutton)));
		boolean addform = driver.findElement(By.xpath(addformbutton)).isEnabled();
		if (addform) {
			test.log(LogStatus.PASS, "Add form button is visible");
		} else {
			test.log(LogStatus.FAIL, "Add form button is not visible");
		}
	}

	@When("^Click on add form button$")
	public void Click_on_add_form_button() throws InterruptedException {
		test = extent.startTest("Click_on_add_form_button");
		Thread.sleep(5000);
		driver.findElement(By.xpath(addformbutton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newform)));
		boolean newformvisible = driver.findElement(By.xpath(newform)).isDisplayed();
		if (newformvisible) {
			test.log(LogStatus.PASS, "New form is added is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "New form is adding is failed");
		}
	}

	@When("^Goto form settings$")
	public void Goto_form_settings() {
		test = extent.startTest("Goto_form_settings");

		driver.findElement(By.xpath(formsettings)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formname)));
		boolean formefieldvisible = driver.findElement(By.xpath(formname)).isDisplayed();
		if (formefieldvisible) {
			test.log(LogStatus.PASS, "goto form settings is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "goto form settings is failed");
		}
	}

	@When("^change form name$")
	public void change_form_name() {
		try {
			test = extent.startTest("change_form_name");

			driver.findElement(By.xpath(formname)).clear();
			driver.findElement(By.xpath(formname)).sendKeys(formnamedata);
			test.log(LogStatus.PASS, "Form name changed is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Form name changing is failed");
		}
	}

	@Then("^verifiy form name is changed$")
	public void verifiy_form_name_is_changed() {
		test = extent.startTest("verifiy_form_name_is_changed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyformname)));
		String formnametext = driver.findElement(By.xpath(verifyformname)).getText();
		if (verifyformnamedata.equals(formnametext)) {
			test.log(LogStatus.PASS, "Verify form name changed is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Verify form name changed is failed");
		}
	}

	@Given("^Click on add field for name field$")
	public void Click_on_add_field_for_name_field() {
		addfield("Click_on_add_field_for_name_field");
	}

	@When("^drag and drop the name field$")
	public void drag_and_drop_the_name_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_name_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 298);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(namefield)));
		boolean namefieldvisible = driver.findElement(By.xpath(namefield)).isDisplayed();
		Assert.assertTrue(namefieldvisible);
		if (namefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the name field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the name field is failed");
		}
	}

	@Then("^goto to name field settings$")
	public void goto_to_name_field_settings() {
		gotofieldsettings("goto_to_name_field_settings", namefield, "name");
	}

	@Then("^Change name field text length and restrict special character$")
	public void Change_name_field_text_length_and_restrict_special_character() {
		try {
			test = extent.startTest("Change_name_field_text_length_and_restrict_special_character");

			driver.findElement(By.xpath(textlength)).clear();
			driver.findElement(By.xpath(textlength)).sendKeys(textlengthdata);
			driver.findElement(By.xpath(restrictspecialcharacter)).sendKeys(restrictspecialcharacterdata);
			test.log(LogStatus.PASS,
					"Change name field text length and restrict special character for name field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL,
					"Change name field text length and restrict special character for name field is failed");
		}
	}

	@Then("^Change field script for name field$")
	public void Change_field_script_for_name_field() {
		try {
			test = extent.startTest("Change_field_script_for_name_field");

			driver.findElement(By.xpath(fieldscript)).clear();
			driver.findElement(By.xpath(fieldscript)).sendKeys(namefieldscriptdata);
			test.log(LogStatus.PASS, "Changing field scripting name for name field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing field scripting name for name field is failed");
		}
	}

	@Given("^Click on add field for phone field$")
	public void Click_on_add_field_for_phone_field() {
		addfield("Click_on_add_field_for_phone_field");
	}

	@When("^drag and drop the phone field$")
	public void drag_and_drop_the_phone_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_phone_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 338);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(phonefield)));
		boolean phonefieldvisible = driver.findElement(By.xpath(phonefield)).isDisplayed();
		if (phonefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the phone field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the phone field is failed");
		}
	}

	@Then("^goto to phone field settings$")
	public void goto_to_phone_field_settings() {
		gotofieldsettings("goto_to_phone_field_settings", phonefield, "phone");
	}

	@Then("^Change phone field text length$")
	public void Change_phone_field_text_length() {
		textlength("Change_phone_field_text_length", phonefieldtextlength, "phone");
	}

	@Then("^Disable phone field agent verification$")
	public void Disable_phone_field_agent_verification() {
		test = extent.startTest("Disable_phone_field_agent_verification");

		driver.findElement(By.xpath(agentverification)).click();
		String agenttext = driver.findElement(By.xpath(agentverification)).getAttribute("class");
		Assert.assertEquals(toggleverifyoffdata, agenttext);
		if (toggleverifyoffdata.equals(agenttext)) {
			test.log(LogStatus.PASS, "Disable the agent verification for phone field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Disable the agent verification for phone field is failed");
		}
	}

	@Then("^Disable phone field System verification$")
	public void Disable_phone_field_System_verification() {
		test = extent.startTest("Disable_phone_field_System_verification");

		driver.findElement(By.xpath(systemverification)).click();
		String agenttext = driver.findElement(By.xpath(systemverification)).getAttribute("class");
		Assert.assertEquals(toggleverifyoffdata, agenttext);
		if (toggleverifyoffdata.equals(agenttext)) {
			test.log(LogStatus.PASS, "Disable system verification for phone field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Disable system verification for phone field is failed");
		}
	}

	@Then("^Change field script for phone field$")
	public void Change_field_script_for_phone_field() {
		try {
			test = extent.startTest("Change_field_script_for_phone_field");

			driver.findElement(By.xpath(fieldscript)).clear();
			driver.findElement(By.xpath(fieldscript)).sendKeys(phonefieldscriptdata);
			test.log(LogStatus.PASS, "Changing the scripting name for phone field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing the scripting name for phone field is failed");
		}
	}

	@Given("^Click on add field for Email field$")
	public void Click_on_add_field_for_Email_field() {
		addfield("Click_on_add_field_for_Email_field");
	}

	@When("^drag and drop the Email field$")
	public void drag_and_drop_the_Email_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Email_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 379);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Emailfield)));
		boolean emailfieldvisible = driver.findElement(By.xpath(Emailfield)).isDisplayed();
		if (emailfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the email field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the email field is failed");
		}
	}

	@Then("^goto to Email field settings$")
	public void goto_to_Email_field_settings() {
		gotofieldsettings("goto_to_Email_field_settings", Emailfield, "email");
	}

	@Then("^Change Email field text length$")
	public void Change_Email_field_text_length() {
		textlength("Change_Email_field_text_length", emailfieldtextlength, "Email");
	}

	@Then("^Change Email field restrict special character$")
	public void Change_Email_field_restrict_special_character() {
		restrictspecialcharacter("Change_Email_field_restrict_special_character", emailfieldrestrictspecialcharacter,
				"email");
	}

	@Then("^Change field script for Email field$")
	public void Change_field_script_for_Email_field() {
		try {
			test = extent.startTest("Change_field_script_for_Email_field");

			driver.findElement(By.xpath(fieldscript)).clear();
			driver.findElement(By.xpath(fieldscript)).sendKeys(emailfieldscriptdata);
			test.log(LogStatus.PASS, "Changing field script name for email is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing field script name for email is failed");
		}
	}

	@Given("^Click on add field for message field$")
	public void Click_on_add_field_for_message_field() {
		addfield("Click_on_add_field_for_message_field");
	}

	@When("^drag and drop the message field$")
	public void drag_and_drop_the_message_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_message_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 460);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messagefield)));
		boolean messagefieldvisible = driver.findElement(By.xpath(messagefield)).isDisplayed();
		if (messagefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the message field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the message field is failed");
		}
	}

	@Then("^goto to message field settings$")
	public void goto_to_message_field_settings() {
		gotofieldsettings("goto_to_message_field_settings", messagefield, "message");
	}

	@Then("^Change message field restrict special character$")
	public void Change_message_field_restrict_special_character() {
		restrictspecialcharacter("Change_message_field_restrict_special_character",
				messagefieldrestrictspecialcharacter, "message");
	}

	@Given("^Click on add field for scripting field$")
	public void Click_on_add_field_for_scripting_field() {
		addfield("Click_on_add_field_for_scripting_field");
	}

	@When("^drag and drop the Scripting field$")
	public void drag_and_drop_the_Scripting_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Scripting_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 501);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(scriptingfield)));
		boolean scriptingfieldvisible = driver.findElement(By.xpath(scriptingfield)).isDisplayed();
		if (scriptingfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the scripting field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the Scripting field is failed");
		}
	}

	@Then("^goto to scripting field settings$")
	public void goto_to_scripting_field_settings() {
		gotofieldsettings("goto_to_scripting_field_settings", scriptingfield, "Scripting");
	}

	@Then("^Change scripting field label name$")
	public void Change_scripting_field_label_name() {
		try {
			test = extent.startTest("Change_scripting_field_label_name");

			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(scriptingfieldlabeldata);
			test.log(LogStatus.PASS, "Changing label name for scripting field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing label name for scripting field is failed");
		}
	}

	@Then("^Enable Scripting field verbatim$")
	public void Enable_Scripting_field_verbatim() {
		test = extent.startTest("Enable_Scripting_field_verbatim");

		driver.findElement(By.xpath(verbatim)).click();
		String verbatimtext = driver.findElement(By.xpath(verbatim)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, verbatimtext);
		if (toggleverifyondata.equals(verbatimtext)) {
			test.log(LogStatus.PASS, "Enable the verbatim for scripting field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Enable the verbatim for scripting field is failed");
		}
	}

	@Given("^Click on add field for instruction field$")
	public void Click_on_add_field_for_instruction_field() {
		addfield("Click_on_add_field_for_instruction_field");
	}

	@When("^drag and drop the Instruction field$")
	public void drag_and_drop_the_Instruction_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Instruction_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 541);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(instructionfield)));
		boolean instructionfieldvisible = driver.findElement(By.xpath(instructionfield)).isDisplayed();
		Assert.assertTrue(instructionfieldvisible);
		if (instructionfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the instruction field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the instruction field is failed");
		}
	}

	@Then("^goto to instruction field settings$")
	public void goto_to_instruction_field_settings() {
		gotofieldsettings("goto_to_instruction_field_settings", instructionfield, "instruction");
	}

	@Then("^Change instruction field label name$")
	public void Change_instruction_field_label_name() {
		try {
			test = extent.startTest("Change_instruction_field_label_name");

			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(instructionfieldlabeldata);
			test.log(LogStatus.PASS, "Changing label name for instruction field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing label name for instruction field is failed");
		}
	}

	@Given("^Click on add field for company field$")
	public void Click_on_add_field_for_company_field() {
		addfield("Click_on_add_field_for_company_field");
	}

	@When("^drag and drop the Company field$")
	public void drag_and_drop_the_Company_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Company_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 582);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(companyfield)));
		boolean companyfieldvisible = driver.findElement(By.xpath(companyfield)).isDisplayed();
		if (companyfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the company field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the company field is failed");
		}
	}

	@Then("^goto to company field settings$")
	public void goto_to_company_field_settings() {
		gotofieldsettings("goto_to_company_field_settings", companyfield, "company");
	}

	@Then("^Change company field text length$")
	public void Change_company_field_text_length() {
		textlength("Change_company_field_text_length", companyfieldtextlength, "company");
	}

	@Then("^Change company field Restrict special character$")
	public void Change_company_field_Restrict_special_character() {
		restrictspecialcharacter("Change_company_field_Restrict_special_character",
				companyfieldrestrictspecialcharacterdata, "company");
	}

	@Then("^Disable company field Agent verification$")
	public void Disable_company_field_Agent_verification() {
		driver.findElement(By.xpath(agentverification)).click();
		String agenttext = driver.findElement(By.xpath(agentverification)).getAttribute("class");
		Assert.assertEquals(toggleverifyoffdata, agenttext);
		if (toggleverifyoffdata.equals(agenttext)) {
			test.log(LogStatus.PASS, "Disable agent verification for company field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Disable agent verification for company field is failed");
		}
	}

	@Given("^Click on add field for URL field$")
	public void Click_on_add_field_for_URL_field() {
		addfield("Click_on_add_field_for_URL_field");
	}

	@When("^drag and drop the URL field$")
	public void drag_and_drop_the_URL_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_URL_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 624);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(urlfield)));
		boolean urlfieldvisible = driver.findElement(By.xpath(urlfield)).isDisplayed();
		Assert.assertTrue(urlfieldvisible);
		if (urlfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the URL field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the URL field is failed");
		}
	}

	@Then("^goto to Url field settings$")
	public void goto_to_Url_field_settings() {
		gotofieldsettings("goto_to_Url_field_settings", urlfield, "url");
	}

	@Then("^Change URL label name$")
	public void Change_URL_label_name() {
		try {
			test = extent.startTest("Change_URL_label_name");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(urlfieldlabeldata);
			test.log(LogStatus.PASS, "Changing label name for url field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing label name for url field is failed");
		}
	}

	@Then("^Enter URL$")
	public void Enter_URL() {
		try {
			test = extent.startTest("Enter_URL");
			driver.findElement(By.xpath(url)).clear();
			driver.findElement(By.xpath(url)).sendKeys(urldata);
			test.log(LogStatus.PASS, "Enter url for url field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Enter url for url field is failed");
		}
	}

	@Given("^Click on add field for finish call field$")
	public void Click_on_add_field_for_finish_call_field() {
		addfield("Click_on_add_field_for_finish_call_field");
	}

	@When("^drag and drop the finish call field$")
	public void drag_and_drop_the_finish_call_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_finish_call_field");

		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 664);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(finishcallfield)));
		boolean finishcallfieldvisible = driver.findElement(By.xpath(finishcallfield)).isDisplayed();
		if (finishcallfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the finish call field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the finish call field is failed");
		}
	}

	@Then("^goto to finish call field settings$")
	public void goto_to_finish_call_field_settings() {
		gotofieldsettings("goto_to_finish_call_field_settings", finishcallfield, "finish call");
	}

	@Then("^enable send option for finish call field$")
	public void enable_send_option_for_finish_call_field() {
		test = extent.startTest("enable_send_option_for_finish_call_field");
		driver.findElement(By.xpath(savebutton)).click();
		String savebuttontext = driver.findElement(By.xpath(savebutton)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, savebuttontext);
		if (toggleverifyondata.equals(savebuttontext)) {
			test.log(LogStatus.PASS, "Enable send option for finish cal field is successfully");
		} else {
			test.log(LogStatus.FAIL, "Enable send option for finish cal field is failed");
		}
	}

	@Given("^Click on add field for Single line text$")
	public void Click_on_add_field_for_Single_line_text() {
		addfield("Click_on_add_field_for_Single_line_text");
	}

	@When("^drag and drop the Single line text field$")
	public void drag_and_drop_the_Single_line_text_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Single_line_text_field");

		driver.findElement(By.xpath(singlelinetext)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(singlelinetextfield)));
		boolean singlelinetextfieldvisible = driver.findElement(By.xpath(singlelinetextfield)).isDisplayed();
		if (singlelinetextfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the single line text field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the single line text field is failed");
		}
	}

	@Then("^goto to Single line text settings$")
	public void goto_to_Single_line_text_settings() {
		gotofieldsettings("goto_to_Single_line_text_settings", singlelinetextfield, "single line text");
	}

	@Then("^Change Single line text length$")
	public void Change_Single_line_text_length() {
		textlength("Change_Single_line_text_length", singlelinetextlength, "single line text");
	}

	@Then("^change single line text restrict special character$")
	public void change_single_line_text_restrict_special_character() {
		restrictspecialcharacter("change_single_line_text_restrict_special_character",
				singlrlinerestrictspecialcharacter, "singleline text");
	}

	@Then("^Enable single line text agent verification$")
	public void Enable_single_line_text_agent_verification() {
		agentverification("Enable_single_line_text_agent_verification", "single line text");
	}

	@Then("^enable single line text numbers only$")
	public void enable_single_line_text_numbers_only() {
		test = extent.startTest("enable_single_line_text_numbers_only");

		driver.findElement(By.xpath(SLTnumberonly)).click();
		String numberonlytext = driver.findElement(By.xpath(SLTnumberonly)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, numberonlytext);
		if (toggleverifyondata.equals(numberonlytext)) {
			test.log(LogStatus.PASS, "Enable number only for single line text field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Enable number only for single line text field is failed");
		}
	}

	@Given("^Click on add field for first name field$")
	public void Click_on_add_field_for_first_name_field() {
		addfield("Click_on_add_field_for_first_name_field");
	}

	@When("^drag and drop the first name field$")
	public void drag_and_drop_the_first_name_field() throws InterruptedException, AWTException {
		test = extent.startTest("drag_and_drop_the_first_name_field");

		driver.findElement(By.xpath(firstname)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstnamefield)));
		boolean firstnamefieldvisible = driver.findElement(By.xpath(firstnamefield)).isDisplayed();
		if (firstnamefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the first name field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the first name field is failed");
		}
	}

	@Then("^goto first name field settings$")
	public void goto_first_name_field_settings() {
		gotofieldsettings("goto_first_name_field_settings", firstnamefield, "first name");
	}

	@Then("^Enable agent verification for first name field$")
	public void Enable_agent_verification_for_first_name_field() {
		agentverification("Enable_agent_verification_for_first_name_field", "first name");
	}

	@Then("^Change first name text length$")
	public void Change_first_name_text_length() {
		textlength("Change_first_name_text_length", firstnamefieldtextlength, "first name");
	}

	@Then("^Change first name restrict special character$")
	public void Change_first_name_restrict_special_character() {
		restrictspecialcharacter("Change_first_name_restrict_special_character", firstnamefieldrestrictspecialcharacter,
				"first name");
	}

	@Given("^Click on add field for last name field$")
	public void Click_on_add_field_for_last_name_field() {
		addfield("Click_on_add_field_for_last_name_field");
	}

	@When("^drag and drop the last name field$")
	public void drag_and_drop_the_last_name_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_last_name_field");

		driver.findElement(By.xpath(lastname)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(3000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lastnamefield)));
		boolean lastnamefieldvisible = driver.findElement(By.xpath(lastnamefield)).isDisplayed();
		if (lastnamefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the last name field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the last name field is failed");
		}
	}

	@Then("^goto last name field settings$")
	public void goto_last_name_field_settings() {
		gotofieldsettings("goto_last_name_field_settings", lastnamefield, "last name");
	}

	@Then("^Enable agent verification for last name field$")
	public void Enable_agent_verification_for_last_name_field() {
		agentverification("Enable_agent_verification_for_last_name_field", "last name");
	}

	@Then("^Change last name field text length$")
	public void Change_last_name_field_text_length() {
		textlength("Change_last_name_field_text_length", lastnamefieldtext, "last name");
	}

	@Then("^Change last name field restrict special character$")
	public void Change_last_name_field_restrict_special_character() {
		restrictspecialcharacter("Change_last_name_field_restrict_special_character",
				lastnamefieldrestrictspecialcharacter, "last name");
	}

	@Given("^click on add field for date field$")
	public void click_on_add_field_for_date_field() {
		addfield("click_on_add_field_for_date_field");
	}

	@When("^drag and drop the Date field$")
	public void drag_and_drop_the_Date_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Date_field");
		driver.findElement(By.xpath(date)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(datefield)));
		boolean datefieldvisible = driver.findElement(By.xpath(datefield)).isDisplayed();
		if (datefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the date field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the date field is failed");
		}
	}

	@Then("^goto date field settings$")
	public void goto_date_field_settings() {
		gotofieldsettings("goto_date_field_settings", datefield, "date");
	}

	@Then("^Enable required for date field$")
	public void Enable_required_for_date_field() {
		test = extent.startTest("Enable_required_for_date_field");
		driver.findElement(By.xpath(required)).click();
		String requiredtext = driver.findElement(By.xpath(required)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, requiredtext);
		if (toggleverifyondata.equals(requiredtext)) {
			test.log(LogStatus.PASS, "Enable required for date field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Enable required for date field is failed");
		}
	}

	@Then("^Change date field format$")
	public void Change_date_field_format() {
		try {
			test = extent.startTest("Change_date_field_format");
			driver.findElement(By.xpath(dateformat)).click();
			driver.findElement(By.xpath(selectdateformat)).click();
			test.log(LogStatus.PASS, "Change date format for date field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Change date format for date field is failed");
		}
	}

	@Given("^Click on add field for city field$")
	public void Click_on_add_field_for_city_field() {
		addfield("Click_on_add_field_for_city_field");
	}

	@When("^drag and drop the City field$")
	public void drag_and_drop_the_City_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_City_field");
		driver.findElement(By.xpath(city)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityfield)));
		boolean cityfieldvisible = driver.findElement(By.xpath(cityfield)).isDisplayed();
		if (cityfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the city field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the city field is failed");
		}
	}

	@Then("^goto City field settings$")
	public void goto_City_field_settings() {
		gotofieldsettings("goto_City_field_settings", cityfield, "city");
	}

	@Then("^Enable Agent verification for city$")
	public void Enable_Agent_verification_for_city() {
		agentverification("Enable_Agent_verification_for_city", "city");
	}

	@Then("^Change city field text length$")
	public void Change_city_field_text_length() {
		textlength("Change_city_field_text_length", cityfieldtext, "city");
	}

	@Then("^Change city field restrict special character$")
	public void Change_city_field_restrict_special_character() {
		restrictspecialcharacter("Change_city_field_restrict_special_character", cityfieldrestrictspecialcharacter,
				"city");
	}

	@Given("^Click on add field for state field$")
	public void Click_on_add_field_for_state_field() {
		addfield("Click_on_add_field_for_state_field");
	}

	@When("^drag and drop the State field$")
	public void drag_and_drop_the_State_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_State_field");
		driver.findElement(By.xpath(state)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(statefield)));
		boolean statefieldvisible = driver.findElement(By.xpath(statefield)).isDisplayed();
		if (statefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the state field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the state field is failed");
		}
	}

	@Then("^goto state field settings$")
	public void goto_state_field_settings() {
		gotofieldsettings("goto_state_field_settings", statefield, "state");
	}

	@Then("^Enable state field is required$")
	public void Enable_state_field_is_required() {
		test = extent.startTest("Enable_state_field_is_required");
		driver.findElement(By.xpath(required)).click();
		String requiredtext = driver.findElement(By.xpath(required)).getAttribute("class");
		Assert.assertEquals(toggleverifyondata, requiredtext);
		if (toggleverifyondata.equals(requiredtext)) {
			test.log(LogStatus.PASS, "Enable required for state field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Enable required for state field is failed");
		}
	}

	@Given("^Click on add field for zip code$")
	public void Click_on_add_field_for_zip_code() {
		addfield("Click_on_add_field_for_zip_code");
	}

	@When("^drag and drop the Zipcode field$")
	public void drag_and_drop_the_Zipcode_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Zipcode_field");
		driver.findElement(By.xpath(zipcode)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(zipcodefield)));
		boolean statefieldvisible = driver.findElement(By.xpath(zipcodefield)).isDisplayed();
		if (statefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the state field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the state field is failed");
		}
	}

	@Then("^goto to Zipcode field settings$")
	public void goto_to_Zipcode_field_settings() {
		gotofieldsettings("goto_to_Zipcode_field_settings", zipcodefield, "zip code");
	}

	@Then("^Change zipcode text length$")
	public void Change_zipcode_text_length() {
		textlength("Change_zipcode_text_length", zipcodetext, "zip code");
	}

	@Then("^Change zipcode restrict special character$")
	public void Change_zipcode_restrict_special_character() {
		restrictspecialcharacter("Change_zipcode_restrict_special_character", zipcoderestrictspecialcharacter,
				"Zip code");
	}

	@Given("^Click on add field for Address one field$")
	public void Click_on_add_field_for_Address_one_field() {
		addfield("Click_on_add_field_for_Address_one_field");
	}

	@When("^drag and drop the Address one field$")
	public void drag_and_drop_the_Address_one_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_Address_one_field");
		driver.findElement(By.xpath(address1)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(address1field)));
		boolean address1fieldvisible = driver.findElement(By.xpath(address1field)).isDisplayed();
		if (address1fieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the address1 field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the address1 field is failed");
		}
	}

	@Then("^goto to Address one field settings$")
	public void goto_to_Address_one_field_settings() {
		gotofieldsettings("goto_to_Address_one_field_settings", address1field, "address1");
	}

	@Then("^Change Address one field text length$")
	public void Change_Address_one_field_text_length() {
		textlength("Change_Address_one_field_text_length", address1fieldtext, "address1");
	}

	@Then("^Change Address one field Restrict special character$")
	public void Change_Address_one_field_Restrict_special_character() {
		restrictspecialcharacter("Change_Address_one_field_Restrict_special_character",
				address1restrictspecialcharacter, "address1");
	}

	@Given("^Click on add field for iframe field$")
	public void Click_on_add_field_for_iframe_field() {
		addfield("Click_on_add_field_for_iframe_field");
	}

	@When("^drag and drop the iframe field$")
	public void drag_and_drop_the_iframe_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_iframe_field");
		driver.findElement(By.xpath(iframe)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframefield)));
		boolean iframefieldvisible = driver.findElement(By.xpath(iframefield)).isDisplayed();
		if (iframefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the iframe field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the iframe field is failed");
		}
	}

	@Then("^goto to iframe field settings$")
	public void goto_to_iframe_field_settings() {
		gotofieldsettings("goto_to_iframe_field_settings", iframefield, "iframe");
	}

	@Then("^Enter iframe URL$")
	public void Enter_iframe_URL() {
		try {
			test = extent.startTest("Enter_iframe_URL");
			driver.findElement(By.xpath(iframeurl)).clear();
			driver.findElement(By.xpath(iframeurl)).sendKeys(iframeurldata);
			test.log(LogStatus.PASS, "Enter url for iframe field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Enter url for iframe field is failed");
		}
	}

	@Then("^Change width of iframe window$")
	public void Change_width_of_iframe_window() {
		try {
			test = extent.startTest("Change_width_of_iframe_window");
			driver.findElement(By.xpath(widthofiframe)).clear();
			driver.findElement(By.xpath(widthofiframe)).sendKeys(widthofiframedata);
			test.log(LogStatus.PASS, "Change width of the iframe window for iframe field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Change width of the iframe window for iframe field is failed");
		}
	}

	@Then("^Change heigth of iframe window$")
	public void Change_heigth_of_iframe_window() {
		try {
			test = extent.startTest("Change_heigth_of_iframe_window");
			driver.findElement(By.xpath(heigthofiframe)).clear();
			driver.findElement(By.xpath(heigthofiframe)).sendKeys(heigthofiframedata);
			test.log(LogStatus.PASS, "Change heigth of the iframe window for iframe field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Change heigth of the iframe window for iframe field is failed");
		}
	}

	@Given("^Click on add field for dropdown field$")
	public void Click_on_add_field_for_dropdown_field() {
		addfield("Click_on_add_field_for_dropdown_field");
	}

	@When("^drag and drop the dropdown field$")
	public void drag_and_drop_the_dropdown_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_dropdown_field");
		driver.findElement(By.xpath(dropdown)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownfield)));
		boolean dropdwonfieldvisible = driver.findElement(By.xpath(dropdownfield)).isDisplayed();
		if (dropdwonfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the dropdown field is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the dropdown field is failed");
		}
	}

	@Then("^goto to dropdown field settings$")
	public void goto_to_dropdown_field_settings() {
		gotofieldsettings("goto_to_dropdown_field_settings", dropdownfield, "dropdown");
	}

	@Then("^change dropdown field label name$")
	public void change_dropdown_field_label_name() {
		try {
			test = extent.startTest("change_dropdown_field_label_name");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(dropdownfieldlabeldata);
			test.log(LogStatus.PASS, "Changing label name for dropdown field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing label name for dropdown field is failed");
		}
	}

	@Then("^change option name for dropdown field$")
	public void change_option_name_for_dropdown_field() {
		try {
			test = extent.startTest("change_option_name_for_dropdown_field");
			driver.findElement(By.xpath(adddropdownoptions)).click();
			driver.findElement(By.xpath(renameoptions1name)).clear();
			driver.findElement(By.xpath(renameoptions1name)).sendKeys(renameoptions1namedata);
			driver.findElement(By.xpath(renameoptions2name)).clear();
			driver.findElement(By.xpath(renameoptions2name)).sendKeys(renameoptions2namedata);
			test.log(LogStatus.PASS, "Rename all option in dropdown field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Rename all option in dropdown field is failed");
		}
	}

	@Then("^Enable else option$")
	public void Enable_else_option() {
		try {
			test = extent.startTest("Enable_else_option");
			driver.findElement(By.xpath(dropdownelseoption)).click();
			test.log(LogStatus.PASS, "Enable else option for dropdown field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Enable else option for dropdown field is failed");
		}
	}

	@Then("^Change else option name$")
	public void Change_else_option_name() {
		try {
			test = extent.startTest("Change_else_option_name");
			driver.findElement(By.xpath(dropdownelseoptionname)).sendKeys(dropdownelseoptionnamedata);
			test.log(LogStatus.PASS, "Rename else option name for dropdown field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Rename else option name for dropdown field is failed");
		}
	}

	@Given("^Click on add field for decision tree$")
	public void Click_on_add_field_for_decision_tree() {
		addfield("Click_on_add_field_for_decision_tree");
	}

	@When("^Drag and drop the decision tree field$")
	public void Drag_and_drop_the_decision_tree_field() throws AWTException, InterruptedException {
		try {
			test = extent.startTest("Drag_and_drop_the_decision_tree_field");
			driver.findElement(By.xpath(decisiontree)).click();
			rb = new Robot();
			Thread.sleep(3000);
			rb.mouseMove(160, 244);
			rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(2000);
			rb.mouseMove(545, 400);
			Thread.sleep(2000);
			rb.mouseMove(923, 638);
			Thread.sleep(3000);
			rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Drag and drop the decision tree field is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Drag and drop the decision tree field is failed");
		}
	}

	@Then("^enter number of branchs and click ok$")
	public void enter_number_of_branchs_and_click_ok() {
		test = extent.startTest("enter_number_of_branchs_and_click_ok");
		driver.findElement(By.xpath(numberofbranch)).clear();
		driver.findElement(By.xpath(numberofbranch)).sendKeys(numberofbranchdata);
		driver.findElement(By.xpath(submitbutton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(decisiontreefield)));
		boolean decisiontreefieldvisible = driver.findElement(By.xpath(decisiontreefield)).isDisplayed();
		if (decisiontreefieldvisible) {
			test.log(LogStatus.PASS, "enter number fo braches and click ok is sucessfully");
		} else {
			test.log(LogStatus.FAIL, "enter number fo braches and click ok is failed");
		}
	}

	@Then("^Goto decision tree field settings$")
	public void Goto_decision_tree_field_settings() {
		gotofieldsettings("Goto_decision_tree_field_settings", decisiontreefield, "decisiontree");
	}

	@Then("^rename all branches in decision tree$")
	public void rename_all_branches_in_decision_tree() {
		try {
			test = extent.startTest("rename_all_branches_in_decision_tree");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(decisiontreelabeldata);
			driver.findElement(By.xpath(decisiontreeoption1)).clear();
			driver.findElement(By.xpath(decisiontreeoption1)).sendKeys(decisiontreeoption1data);
			driver.findElement(By.xpath(decisiontreeoption2)).clear();
			driver.findElement(By.xpath(decisiontreeoption2)).sendKeys(decisiontreeoption2data);
			driver.findElement(By.xpath(decisiontreeoption3)).clear();
			driver.findElement(By.xpath(decisiontreeoption3)).sendKeys(decisiontreeoption3data);
			driver.findElement(By.xpath(decisiontreeoption4)).clear();
			driver.findElement(By.xpath(decisiontreeoption4)).sendKeys(decisiontreeoption4data);
			test.log(LogStatus.PASS, "Rename all branches in decision tree is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Rename all branches in decision tree is failed");
		}
	}

	@Then("^add another branch$")
	public void add_another_branch() {
		try {
			test = extent.startTest("add_another_branch");
			driver.findElement(By.xpath(addanotherbranch)).click();
			// driver.findElement(By.xpath(decisiontreeoption5)).clear();
			// driver.findElement(By.xpath(decisiontreeoption5)).sendKeys(decisiontreeoption5data);
			test.log(LogStatus.PASS, "Adding another branch is sucessfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Adding another branch is failed");
		}
	}

	@Given("^Click on add field for time field$")
	public void Click_on_add_field_for_time_field() {
		addfield("Click_on_add_field_for_time_field");
	}

	@When("^Drag and drop the time field$")
	public void Drag_and_drop_the_time_field() throws AWTException, InterruptedException {
		test=extent.startTest("Drag_and_drop_the_time_field");
		driver.findElement(By.xpath(time)).click();
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 674);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timefield)));
		boolean timefieldvisible = driver.findElement(By.xpath(timefield)).isDisplayed();
		Assert.assertTrue(timefieldvisible);
		if (timefieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the time field is successfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the time field tree is failed");
		}
	}

	@Then("^Goto time field settings$")
	public void Goto_time_field_settings() {
		gotofieldsettings("Goto_time_field_settings", timefield, "time");
	}

	@Then("^Change time field label name$")
	public void Change_time_field_label_name() {
		try {
		test=extent.startTest("Change_time_field_label_name");
		driver.findElement(By.xpath(fieldlabel)).clear();
		driver.findElement(By.xpath(fieldlabel)).sendKeys(timefieldlabeldata);
		test.log(LogStatus.PASS, "Changing label name for time field is sucessfully");
	}catch(Exception ex) {
		test.log(LogStatus.FAIL, "Changing label name for time field is failed");
		}
	}

	@Then("^Change time field format$")
	public void Change_time_field_format() {
		try {
		test=extent.startTest("Change_time_field_format");
		driver.findElement(By.xpath(timefieldformat)).click();
		driver.findElement(By.xpath(timefieldselectformat)).click();
		test.log(LogStatus.PASS, "Changing time format for time field is sucessfully");
	}catch(Exception ex) {
		test.log(LogStatus.FAIL, "Changing time format for time field is failed");
		}
	}

	@Given("^Cilck on add field for set repeat field$")
	public void Cilck_on_add_field_for_set_repeat_field() {
		addfield("Cilck_on_add_field_for_set_repeat_field");
	}

	@When("^Drag and drop the set repeat field to decision tree$")
	public void Drag_and_drop_the_set_repeat_field_to_decision_tree() throws AWTException, InterruptedException {
		test=extent.startTest("Drag_and_drop_the_set_repeat_field_to_decision_tree");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 470);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(518, 485);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(setrepeatfield)));
		boolean setrepeatfieldvisible = driver.findElement(By.xpath(setrepeatfield)).isDisplayed();
		if (setrepeatfieldvisible) {
			test.log(LogStatus.PASS, "Drag and drop the set repeat field to decision tree is successfully");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the set repeat field to decision tree is failed");
		}
	}

	@Then("^goto set repeat field settings$")
	public void goto_set_repeat_field_settings() {
		gotofieldsettings("goto_set_repeat_field_settings", setrepeatfield, "set repeat");
	}

	@Then("^Change set field repeat with duration$")
	public void Change_set_field_repeat_with_duration() {
		try {
			test = extent.startTest("Change_set_field_repeat_with_duration");
			driver.findElement(By.xpath(Setrepeatduration)).click();
			driver.findElement(By.xpath(setrepeatselectduration)).click();
			driver.findElement(By.xpath(setrepeatminmizetree)).click();
			test.log(LogStatus.PASS, "Changing duration for set repeat field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing duration for set repeat field is failed");
		}
	}

	@Given("^Click on add field for call transfer field$")
	public void Click_on_add_field_for_call_transfer_field() {
		addfield("Click_on_add_field_for_call_transfer_field");
	}

	@When("^Drag and drop the call transfer field to decision tree$")
	public void Drag_and_drop_the_call_transfer_field_to_decision_tree() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_call_transfer_field_to_decision_tree");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 589);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(518, 509);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(calltransferfield)));
		boolean calltransferfieldvisible = driver.findElement(By.xpath(calltransferfield)).isDisplayed();
		if (calltransferfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the call transfer field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the call transfer field is failed");
		}
	}

	@Then("^goto call transfer field settings$")
	public void goto_call_transfer_field_settings() {
		gotofieldsettings("goto_call_transfer_field_settings", calltransferfield, "call transfer");
	}

	@Then("^Select contact for call transfer$")
	public void Select_contact_for_call_transfer() {
		try {
			test = extent.startTest("Select_contact_for_call_transfer");
			driver.findElement(By.xpath(calltransferselectcontact)).click();
			driver.findElement(By.xpath(calltransferminmizetree)).click();
			test.log(LogStatus.PASS, "Select contact for call transfer field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Select contact for call transfer field is failed");
		}
	}

	@Given("^Click on add field for on call schedule$")
	public void Click_on_add_field_for_on_call_schedule() {
		addfield("Click_on_add_field_for_on_call_schedule");
	}

	@When("^Drap and drop the on call schedule field to decision tree$")
	public void Drap_and_drop_the_on_call_schedule_field_to_decision_tree() throws AWTException, InterruptedException {
		try {
			test = extent.startTest("Drap_and_drop_the_on_call_schedule_field_to_decision_tree");
			rb = new Robot();
			Thread.sleep(3000);
			rb.mouseMove(160, 549);
			rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(2000);
			rb.mouseMove(545, 400);
			Thread.sleep(2000);
			rb.mouseMove(518, 535);
			Thread.sleep(3000);
			rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Drag and drop the on call Schedule field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Drag and drop the on call schedule field is failed");
		}
	}

	@Then("^Change settings to Select new calender$")
	public void Change_settings_to_Select_new_calender() {
		try {
			test = extent.startTest("Change_settings_to_Select_new_calender");
			Thread.sleep(9000);
			driver.findElement(By.xpath(oncallschedulecalender)).click();
			String oncalltext = driver.findElement(By.xpath(oncallscheduleaccount)).getAttribute("class");
			if (oncallscheduleaccountdata.equals(oncalltext)) {
				driver.findElement(By.xpath(oncallschedulesubmit)).click();
				System.out.println("on call schedule field account selected");
			} else {
				driver.findElement(By.xpath(oncallscheduleaccount)).click();
				driver.findElement(By.xpath(oncallschedulesubmit)).click();
			}
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(oncallschedulefield)));
			boolean oncallfieldvisible = driver.findElement(By.xpath(oncallschedulefield)).isDisplayed();
			if (oncallfieldvisible == true) {
				driver.findElement(By.xpath(oncallscheduleminmizetree)).click();
				test.log(LogStatus.PASS, "on call schedule field added is successfully done");
			} else {
				test.log(LogStatus.FAIL, "on call schedule field added is failed");
			}

		} catch (Exception ex) {

		}
	}

	@Given("^Cilck on add field for Appointment$")
	public void Cilck_on_add_field_for_Appointment() {
		addfield("Cilck_on_add_field_for_Appointment");
	}

	@When("^Drag and drop the appointment to decision tree$")
	public void Drag_and_drop_the_appointment_to_decision_tree() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_appointment_to_decision_tree");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 630);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(518, 558);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentfield)));
		boolean appointmentfieldvisible = driver.findElement(By.xpath(appointmentfield)).isDisplayed();
		if (appointmentfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the appointment field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the appointment field is failed");
		}
	}

	@Then("^goto Appointment field settings$")
	public void goto_Appointment_field_settings() {
		gotofieldsettings("goto_Appointment_field_settings", appointmentfield, "appointment");
	}

	@Then("^Change Appointment provider to setmore$")
	public void Change_Appointment_provider_to_setmore() {
		try {
			test = extent.startTest("Change_Appointment_provider_to_setmore");
			driver.findElement(By.xpath(appointmentprovider)).click();
			driver.findElement(By.xpath(appointmentproviderselect)).click();
			driver.findElement(By.xpath(appointmenttree)).click();
			test.log(LogStatus.PASS, "Select appointment for appointment field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Select appointment for appointment field is failed");
		}
	}

	@Given("^click on group two and Click on add field for country field$")
	public void click_on_group_two_and_Click_on_add_field_for_country_field() {
		test = extent.startTest("click_on_group_two_and_Click_on_add_field_for_country_field");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		driver.findElement(By.xpath(group2)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^Drag and drop the country field$")
	public void Drag_and_drop_the_country_field() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_country_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 313);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryfield)));
		boolean countryfieldvisible = driver.findElement(By.xpath(countryfield)).isDisplayed();
		if (countryfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the country field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the country field is failed");
		}
	}

	@Then("^Goto country field settings$")
	public void Goto_country_field_settings() {
		gotofieldsettings("Goto_country_field_settings", countryfield, "country");
	}

	@Then("^Change Country field text length and restrict Special character$")
	public void Change_Country_field_text_length_and_restrict_Special_character() {
		try {
			test = extent.startTest("Change_name_field_text_length_and_restrict_special_character");
			driver.findElement(By.xpath(textlength)).clear();
			driver.findElement(By.xpath(textlength)).sendKeys(countrytextlengthdata);
			driver.findElement(By.xpath(restrictspecialcharacter)).sendKeys(countryrestrictspecialcharacterdata);
			test.log(LogStatus.PASS,
					"Changing text length and restrict special character for country field is successfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing text length and restrict special character for country field is failed");
		}
	}

	@Then("^Enable Agent verification and required$")
	public void Enable_Agent_verification_and_required() {
		agentverification("Enable_Agent_verification_and_required", "country");
	}

	@Given("^Cilck on add field for Customer status$")
	public void Cilck_on_add_field_for_Customer_status() {
		test = extent.startTest("Cilck_on_add_field_for_Customer_status");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^Drag and drop the customer status field$")
	public void Drag_and_drop_the_customer_status_field() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_country_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(297, 332);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(5000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerstatusfield)));
		boolean customerstatusfieldvisible = driver.findElement(By.xpath(customerstatusfield)).isDisplayed();
		if (customerstatusfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the customer status field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the customer status field is failed");
		}
	}

	@Then("^goto custumer field settings$")
	public void goto_custumer_field_settings() {
		gotofieldsettings("goto_custumer_field_settings", customerstatusfield, "customer status");
	}

	@Then("^Change client status$")
	public void Change_client_status() {
		try {
			test = extent.startTest("Change_client_status");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(customerstatusfieldlabeldata);
			test.log(LogStatus.PASS, "Changing customer status for customer status field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing customer status for customer status field is failed");
		}
	}

	@Then("^Set Customer Status Expiration$")
	public void Set_Customer_Status_Expiration() {
		try {
			test = extent.startTest("Set_Customer_Status_Expiration");
			driver.findElement(By.xpath(customerstatusexper)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(customerstatusexperdata)).click();
			test.log(LogStatus.PASS, "Select Expiration for customer status field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Select Expiration for customer status field is failed");
		}
	}

	@Given("^Click on add field for multiselect field$")
	public void Click_on_add_field_for_multiselect_field() {
		test = extent.startTest("Click_on_add_field_for_multiselect_field");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^Drag and drop the multiselect field$")
	public void Drag_and_drop_the_multiselect_field() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_multiselect_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 371);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(multiselectfield)));
		boolean multiselectfieldvisible = driver.findElement(By.xpath(multiselectfield)).isDisplayed();
		if (multiselectfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the multiselect field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the multiselect field is failed");
		}
	}

	@Then("^goto multiselect field settings$")
	public void goto_multiselect_field_settings() {
		gotofieldsettings("goto_multiselect_field_settings", multiselectfield, "multiselect");
	}

	@Then("^Add options and change options name$")
	public void Add_options_and_change_options_name() {
		try {
			test = extent.startTest("Add_options_and_change_options_name");
			driver.findElement(By.xpath(multiselectadd)).click();
			driver.findElement(By.xpath(multiselectoption1)).clear();
			driver.findElement(By.xpath(multiselectoption1)).sendKeys(multiselectoption1data);
			driver.findElement(By.xpath(multiselectoption2)).clear();
			driver.findElement(By.xpath(multiselectoption2)).sendKeys(multiselectoption2data);
			test.log(LogStatus.PASS, "Changing options name for multiselect field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing options name for multiselect field is failed");
		}
	}

	@Then("^Change label name and enable else option and rename$")
	public void Change_label_name_and_enable_else_option_and_rename() {
		try {
			test = extent.startTest("Change_label_name_and_enable_else_option_and_rename");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(preferedlocation);
			driver.findElement(By.xpath(multiselectelse)).click();
			driver.findElement(By.xpath(multiselectelsename)).clear();
			driver.findElement(By.xpath(multiselectelsename)).sendKeys(multiselectelsenamedata);
			test.log(LogStatus.PASS,
					"Changing label name ,else option enable and  else option rename for mutiselect field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL,
					"Changing label name,else option enable and  else option rename for multiselect field is failed");
		}
	}

	@Given("^Click on add field for Hidden field$")
	public void Click_on_add_field_for_Hidden_field() {
		test = extent.startTest("Click_on_add_field_for_Hidden_field");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^Drag and drop the hidden field$")
	public void Drag_and_drop_the_hidden_field() throws AWTException, InterruptedException {
		test = extent.startTest("Drag_and_drop_the_hidden_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(294, 371);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hiddenfield)));
		boolean hiddenfieldvisible = driver.findElement(By.xpath(hiddenfield)).isDisplayed();
		if (hiddenfieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the hidden field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the hidden field is failed");
		}
	}

	@Then("^goto Hidden field setting$")
	public void goto_Hidden_field_setting() {
		gotofieldsettings("goto_Hidden_field_setting", hiddenfield, "hidden");
	}

	@Then("^Change field label and field value for hidden field$")
	public void Change_field_label_and_field_value_for_hidden_field() {
		try {
			test = extent.startTest("Change_field_label_and_field_value_for_hidden_field");
			driver.findElement(By.xpath(fieldlabel)).clear();
			driver.findElement(By.xpath(fieldlabel)).sendKeys(hiddenfieldlabeldata);
			driver.findElement(By.xpath(hiddenfieldvalue)).clear();
			driver.findElement(By.xpath(hiddenfieldvalue)).sendKeys(hiddenfieldvaluedata);
			test.log(LogStatus.PASS, "Changing field label and field value name for hidden field is successfully done");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Changing field label and field value name for hidden field is failed");
		}
	}

	@Given("^Click on add field for custom phone field$")
	public void Click_on_add_field_for_custom_phone_field() {
		test = extent.startTest("Click_on_add_field_for_custom_phone_field");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^drag and drop the custom phone field$")
	public void drag_and_drop_the_custom_phone_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_custom_phone_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(160, 412);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customphonefield)));
		boolean customphonefieldvisible = driver.findElement(By.xpath(customphonefield)).isDisplayed();
		if (customphonefieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the custom phone field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the custom phone field is failed");
		}
	}

	@Then("^goto custom phone field settings$")
	public void goto_custom_phone_field_settings() {
		gotofieldsettings("goto_custom_phone_field_settings", customphonefield, "custom phone");
	}

	@Then("^Change custom phone field text length$")
	public void Change_custom_phone_field_text_length() {
		textlength("Change_custom_phone_field_text_length", customphonefieldtext, "custom phone");
	}

	@Then("^Disable custom phone field agent verification and required verification$")
	public void Disable_custom_phone_field_agent_verification_and_required_verification() {
		try {
			test = extent.startTest("Disable_custom_phone_field_agent_verification_and_required_verification");
			driver.findElement(By.xpath(agentverification)).click();
			driver.findElement(By.xpath(required)).click();
			String agenttext = driver.findElement(By.xpath(agentverification)).getAttribute("class");
			String requiredtext = driver.findElement(By.xpath(required)).getAttribute("class");
			if ((toggleverifyoffdata.equals(agenttext)) && (toggleverifyoffdata.equals(requiredtext))) {
				test.log(LogStatus.PASS,
						"Disabled phone field agent verification and required verification is successfull");
			} else {
				test.log(LogStatus.FAIL, "Disable phone field agent verification and required verification is failed");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Given("^Click on add field for Address two field$")
	public void Click_on_add_field_for_Address_two_field() {
		test = extent.startTest("Click_on_add_field_for_Address_two_field");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addfield)));
		driver.findElement(By.xpath(addfield)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(group2container)));
		boolean fieldcontainer2 = driver.findElement(By.xpath(group2container)).isDisplayed();
		if (fieldcontainer2 == true) {
			test.log(LogStatus.PASS, "add field container is displayed");
		} else {
			test.log(LogStatus.FAIL, "add field container is not displayed");
		}
	}

	@When("^drag and drop the Address two field$")
	public void drag_and_drop_the_Address_two_field() throws AWTException, InterruptedException {
		test = extent.startTest("drag_and_drop_the_custom_phone_field");
		rb = new Robot();
		Thread.sleep(3000);
		rb.mouseMove(293, 412);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(545, 400);
		Thread.sleep(2000);
		rb.mouseMove(923, 638);
		Thread.sleep(3000);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(address2field)));
		boolean address2fieldvisible = driver.findElement(By.xpath(address2field)).isDisplayed();
		if (address2fieldvisible == true) {
			test.log(LogStatus.PASS, "Drag and drop the address two field is successfully done");
		} else {
			test.log(LogStatus.FAIL, "Drag and drop the address two field is failed");
		}
	}

	@Then("^goto Address two field settings$")
	public void goto_Address_two_field_settings() {
		gotofieldsettings("goto_Address_two_field_settings", address2field, "address two");
	}

	@Then("^Change Address two field text length and Restrict special character$")
	public void Change_Address_two_field_text_length_and_Restrict_special_character() {
		try {
			test = extent.startTest("Change_Address_two_field_text_length_and_Restrict_special_character");
			driver.findElement(By.xpath(textlength)).clear();
			driver.findElement(By.xpath(textlength)).sendKeys(address2textlengthdata);
			driver.findElement(By.xpath(restrictspecialcharacter)).sendKeys(address2restrictspecialcharacterdata);
			test.log(LogStatus.PASS,
					"Changing text length and restrict special character for address two field is successfull");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL,
					"Changing text length and restrict special character for address two field is failed");
		}
	}

	@Then("^save form and publish and verify$")
	public void save_form_and_publish_and_verify() {
		try {
			test = extent.startTest("save_form_and_publish_and_verify");
			driver.findElement(By.xpath(saveform)).click();
			driver.findElement(By.xpath(saveformyes)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationsaveform)));
			String saveformtext = driver.findElement(By.xpath(notificationsaveform)).getText();
			driver.findElement(By.xpath(publishform)).click();
			driver.findElement(By.xpath(publishformyes)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationpublishform)));
			String publishformtext = driver.findElement(By.xpath(notificationpublishform)).getText();
			if ((notificationsaveformdata.equals(saveformtext))
					&& (notificationpublishformdata.equals(publishformtext))) {
				test.log(LogStatus.PASS, "Save and publish form is successfully done");
			} else {
				test.log(LogStatus.FAIL, "Save and publish form is failed");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Then("^Veiw in switch board$")
	public void Veiw_in_switch_board() {
		try {
			test = extent.startTest("Veiw_in_switch_board");
			driver.findElement(By.xpath(closenotification)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(viewindropdown)).click();
			driver.findElement(By.xpath(viewinsb)).click();
			test.log(LogStatus.PASS, "view in switch board successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "view in switch board Unsuccessfull");
		}
	}

	@Given("^when switch board is opened$")
	public void when_switch_board_is_opened() {
		try {
			test = extent.startTest("when_switch_board_is_opened");
			tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup)));
			driver.findElement(By.xpath(closepopup)).click();
			test.log(LogStatus.PASS, "Switch board opened and close notification successfully");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Switch board open and close notification id failed");
		}
	}

	@When("^verify name phone email and script field added to switch board$")
	public void verify_name_phone_email_and_script_field_added_to_switch_board() throws InterruptedException {
		test = extent.startTest("verify_name_phone_email_and_script_field_added_to_switch_board");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifynamefield)));
		String namefieldtext = driver.findElement(By.xpath(verifynamefield)).getText();
		Assert.assertEquals("name field is added to Switch board", verifynamefielddata, namefieldtext);
		String phonefieldtext = driver.findElement(By.xpath(verifyphonefield)).getText();
		Assert.assertEquals("Phone field is added to Switch board", verifyphonefielddata, phonefieldtext);
		String emailfieldtext = driver.findElement(By.xpath(verifyemailfield)).getText();
		Assert.assertEquals("Email field is added to Switch board", verifyemailfielddata, emailfieldtext);
		String scriptingverbatimtext = driver.findElement(By.xpath(verifyscriptingfieldverbatim)).getText();
		Assert.assertEquals("Scripting field verbatim is added to Switch board", verifyscriptingfieldverbatimdata,
				scriptingverbatimtext);
		String scriptingfieldtext = driver.findElement(By.xpath(verifyscriptingfield)).getText();
		System.out.println(scriptingfieldtext);
		Assert.assertEquals("Scripting field is added to Switch board", verifyscriptingfielddata, scriptingfieldtext);
		if ((verifynamefielddata.equals(namefieldtext)) && (verifyphonefielddata.equals(phonefieldtext))
				&& (verifyemailfielddata.equals(emailfieldtext))
				&& (verifyscriptingfieldverbatimdata.equals(scriptingverbatimtext))
				&& (verifyscriptingfielddata.equals(scriptingfieldtext))) {
			test.log(LogStatus.PASS, "verified name, phone email and script field added to switch board successfully");
		} else {
			test.log(LogStatus.FAIL, "verified name, phone email and script field added to switch board is failed");
		}
	}

	@When("^verify all field are visible in switch board$")
	public void verify_all_field_are_visible_in_switch_board() {
		try {
			test = extent.startTest("verify_all_field_are_visible_in_switch_board");
			boolean nameinput = driver.findElement(By.xpath(verifynameinput)).isEnabled();
			Assert.assertTrue(nameinput);
			boolean phoneinput = driver.findElement(By.xpath(verifyphoneinput)).isEnabled();
			Assert.assertTrue(phoneinput);
			boolean emailinput = driver.findElement(By.xpath(verifyemailinput)).isEnabled();
			Assert.assertTrue(emailinput);
			boolean messageinput = driver.findElement(By.xpath(verifymessageinput)).isEnabled();
			Assert.assertTrue(messageinput);
			boolean companyinput = driver.findElement(By.xpath(verifycompanyinput)).isEnabled();
			Assert.assertTrue(companyinput);
			boolean singlelinetextinput = driver.findElement(By.xpath(verifysinglelinetextinput)).isEnabled();
			Assert.assertTrue(singlelinetextinput);
			boolean firstnameinput = driver.findElement(By.xpath(verifyfirstnameinput)).isEnabled();
			Assert.assertTrue(firstnameinput);
			boolean lastnameinput = driver.findElement(By.xpath(verifylastnameinput)).isEnabled();
			Assert.assertTrue(lastnameinput);
			boolean dateinput = driver.findElement(By.xpath(verifydateinput)).isEnabled();
			Assert.assertTrue(dateinput);
			boolean cityinput = driver.findElement(By.xpath(verifycityinput)).isEnabled();
			Assert.assertTrue(cityinput);
			boolean stateinput = driver.findElement(By.xpath(verifystateinput)).isEnabled();
			Assert.assertTrue(stateinput);
			boolean zipcodeinput = driver.findElement(By.xpath(verifyzipcodeinput)).isEnabled();
			Assert.assertTrue(zipcodeinput);
			boolean address1input = driver.findElement(By.xpath(verifyaddress1input)).isEnabled();
			Assert.assertTrue(address1input);
			boolean dropdowninput = driver.findElement(By.xpath(verifydropdowninput)).isEnabled();
			Assert.assertTrue(dropdowninput);
			boolean countryinput = driver.findElement(By.xpath(verifycountryinput)).isEnabled();
			Assert.assertTrue(countryinput);
			boolean preferedinput = driver.findElement(By.xpath(verifyprefered)).isDisplayed();
			Assert.assertTrue(preferedinput);
			boolean customphoneinput = driver.findElement(By.xpath(verifycustomphoneinput)).isEnabled();
			Assert.assertTrue(customphoneinput);
			boolean address2input = driver.findElement(By.xpath(verifyaddress2input)).isEnabled();
			Assert.assertTrue(address2input);
			driver.findElement(By.xpath(calltransferselect)).click();
			driver.findElement(By.xpath(calltransferyesselect)).click();
			boolean finishcallbutton = driver.findElement(By.xpath(verifyfinishcall)).isEnabled();
			Assert.assertTrue(finishcallbutton);
			test.log(LogStatus.PASS, "Verifying all field are visible in switch board is sucessfully");
		} catch (Exception ex) {
			System.out.println(ex);
			test.log(LogStatus.FAIL, "Verifying all field are visible in switch board is failed");
		}
	}

	@Then("^close switch board back to form creator$")
	public void close_switch_board_back_to_form_creator() {
		try {
			test = extent.startTest("close_switch_board_back_to_form_creator");
			driver.close();
			driver.switchTo().window(tab.get(0));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fetch)));
			driver.findElement(By.xpath(fetch)).click();
			driver.findElement(By.xpath(account)).clear();
			driver.findElement(By.xpath(account)).sendKeys(accountdata);
			driver.findElement(By.xpath(load)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(alertok)));
			driver.findElement(By.xpath(alertok)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(selectemptybtranch)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(deletebranch)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(alertok)));
			driver.findElement(By.xpath(alertok)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(saveform)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationsaveform)));
			String saveformtext = driver.findElement(By.xpath(notificationsaveform)).getText();
			if (notificationsaveformdata.equals(saveformtext)) {
				test.log(LogStatus.PASS, "close switch board back to form creator and deleted empty branch is sucessfully done");
			} else {
				test.log(LogStatus.FAIL, "close switch board back to form creator and deleted empty branch is failed");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
