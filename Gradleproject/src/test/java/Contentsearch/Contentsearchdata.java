package Contentsearch;

public class Contentsearchdata {

	// fetch
	String fetch = "//div[@class='fetch btn_cst hint--left']";

	// content search
	String searchbar = "//div[@class='searchInput']/input[1]";
	String searchbardata = "Can you please tell your company name";

	// change content
	String fieldlabel = "//li[@id='field_label_li']/textarea";
	String fieldlabeldata = "Can you please tell your company details";

	// view in switch board
	String viewindropdown = "//div[@class='view-in']//i[@class='fa fa-angle-up']";
	String viewinsb = "//ul[@style='display: block;']//a[@class='viewSb'][@onclick='loadAccountInSb()']";

	// Save form
	String saveform = "//div[@class='save_fields']/div[1]";
	String notificationsaveform = "//div[@id='notification' and text()='Saved Successfully.....']";
	String notificationsaveformdata = "Saved Successfully.....";

	// scenario tab
	String scenariotab = "//ul[@class='sidebar_tab_nav']/li[2]/a[text()='Scenarios']";
	String scenariovisible = "//div[@class='role_holder']";
	String roledropdown = "//div[@class='role_detail']/h3/i[1]"; // get class attribute
	String roledropdownopen = "fa fa-angle-up";
	String roledropdownclosed = "fa fa-angle-down";
	String role = "//ul[@class='choose_role role_list agent-role']/li[5]/span[1]";  //get class attribute 
	String roleclass="checked";
	String accountdescription = "//ul[@class='role_descreption']/li[1]/textarea[1]";
	String accountdescriptiondata = "Ask about their queries and try to report it to concern person.";
	String addafterhoursrole = "//ul[@class='role_descreption']/li[1]/i[1]"; // get class attribute
	String addafterhourcheck = "fa fa-square-o";
	String afterhourdropdown = "//div[@class='after_hour_role']/h3[1]/i[1]"; // get class attribute
	String afterhoursrole = "//ul[@class='choose_role hours_role_list']/li[6]/span[1]";
	String saveRole = "//div[@style='display: inline-block; margin: 15px 0px; cursor: pointer;']";
	String rolesavenotification="//div[@id='notification'][text()='Saved.']";
	String rolesavenotificationdata="Saved.";

	// create Scenario
	String addScenario = "//div[@onclick='addNewScenario();']";
	String renameScenario = "//div[@onclick='editScenarioTitle(event)']";
	String electricalScenario = "Electrical Issues";
	String scenariostep1 = "//div[@id='scenarios_content']/ul[1]/li[1]/div[2]";
	String scenariostep1data = "Issues?";
	String dragScenario1 = "//li[@class='email']//span";
	String dragScenario2 = "//span[text()='1231231234(phone)']";
	String addStep = "//button[@class='btn pull-right tooltip_t']";
	String scenariostep2 = "//div[@id='scenarios_content']/ul[1]/li[2]/div[2]";
	String scenariostep2data = "Home Appliances or Any Motor Problems?";
	String scenariostep3 = "//div[@id='scenarios_content']/ul[1]/li[3]/div[2]";
	String scenariostep3data = "Details regrading issues";
	String scenariostep4 = "//div[@id='scenarios_content']/ul[1]/li[4]/div[2]";
	String scenariostep4data = "Urgent work or can step some time?";
	String scenariostep5 = "//div[@id='scenarios_content']/ul[1]/li[5]/div[2]";
	String scenariostep5data = "Address and conclusion";
	String saveScenario = "//div[@class='btn_cst save_edit tooltip_t']";
	String confirmSaveScenario = "//a[@onclick='saveScenario()']";
	String scenariosavenotification="//div[@id='notification'][text()='Saved Successfully.']";
	String scenariosavenotificationdata="Saved Successfully.";

	// contact details
	String contactdetails = "//li[@id='manageContact_tab']//a[text()='Contacts']";
	String frame1 = "//iframe[@id='cmsIframe']";
	String addcontacts = "//button[@id='addNewContact']";
	String singlecontact="//div[@class='span4 gp_header']/div[1]/div[3]/ul[1]/li[1]";
	String contactname = "//input[@id='contactName']";
	String contactnamedata = "Test_2018_$";
	String addfield = "//div[@class='btn-group add-contact-methods']//button[@class='btn dropdown-toggle btn-small']";
	String addphonefield = "//ul[@class='dropdown-menu']//a[text()='Phone']";
	String addemailfield = "//ul[@class='dropdown-menu']//a[text()='Email']";
	String addwebfield = "//ul[@class='dropdown-menu']//a[text()='Web']";
	String addfaxfield = "//ul[@class='dropdown-menu']//a[text()='Fax']";
	String addtextfield = "//ul[@class='dropdown-menu']//a[text()='Text']";
	String addmailtext = "//ul[@class='dropdown-menu']//a[text()='MailText']";
	String addmailatt = "//ul[@class='dropdown-menu']//a[text()='EmailAtt.']";
	String addmailcsv = "//ul[@class='dropdown-menu']//a[text()='EmailCSV.']";
	String countrycode = "//span[@class='countryCodeSpan']";
	String countryinput = "//div[@class='phoneCodeDown']/div[1]/input";
	String countrycodedata = "India (+91)";
	String selectcode = "//ul[@class='phoneCountryCode']//li[@class='IN']";
	String addphonefieldinput = "//div[1]/div[5]//li[1]/input[1]";
	String addphonefieldinputdata = "9985350804";
	String addphoneextension = "//div[1]/div[5]//li[1]/input[2]";
	String addphoneextensiondata = "05";
	String addemailfieldinput = "//div[1]/div[5]//li[2]/input[1]";
	String addemailfieldinputdata = "ponnuswamy@gmail.com";
	String addwebfieldinput = "//div[1]/div[5]//li[3]/input[1]";
	String addwebfieldinputdata = "www.google.com";
	String addfaxfieldinput = "//div[1]/div[5]//li[4]/input[1]";
	String addfaxfieldinputdata = "1234567890";
	String addtextfieldinput = "//div[1]/div[5]//li[5]/input[1]";
	String addtextfieldinputdata = "@_Test_2018_!";
	String addmailtextinput = "//div[1]/div[5]//li[6]/input[1]";
	String addmailtextinputdata = "ponnuswamytext@gmail.com";
	String addmailattinput = "//div[1]/div[5]//li[7]/input[1]";
	String addmailattinputdata = "ponnuswamyatt@gmail.com";
	String addmailcsvinput = "//div[1]/div[5]//li[8]/input[1]";
	String addmailcsvinputdata = "ponnuswamycsv@gmail.com";
	String addgroup = "//button[@id='addGroupInstructions']";
	String contacticon = "//div[@class='contacts-list-holder']/ul[1]/li[1]/div[1]/img";
	String emailmethod = "//ul[@class='unstyled contact-info-type']/li[1]/label[text()='Email']";
	String phonemethod = "//ul[@class='unstyled contact-info-type']/li[2]/label[text()='Phone']";
	String addtogroup = "//div[@id='dropdown_addgroup']";
	String addgroupname = "//div[@id='dropdown_addgroup']/ul[1]/div/input";
	String addgroupnamedata = "Test_2018";
	String notification = "//div[text()='Saved Successfully...']";
	String notificationdata = "Saved Successfully...";

	// details business hours and holiday
	String details = "//a[text()='Details']";
	String detailstab = "//div[@class='accountDetailsHeader']";
	String businesshours = "//li[@id='businesshour_info_tab']";
	String hours24 = "//i[@id='round_clock']";
	String attribute = "checked";
	String timezone = "//i[@class='fa fa-pencil editIcon']";
	String selectzone = "//span[text()='America/Los_Angeles - (GMT -7:00) Pacific Time (PST)'][@class='active']";
	String custom = "//i[@id='custom_clock']";
	String monday = "//tr[@id='monday']//i[@class='activateBusinessHour']";
	String tuesday = "//tr[@id='tuesday']//i[@class='activateBusinessHour']";
	String tohours = "/html[1]/body[1]/div[21]/div[2]/ul[1]/li[4]/span[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[3]/input";
	String tohoursdata = "12:00 PM";
	String addhours = "//tbody[1]/tr[2]/td[2]/div[1]/i[2]";
	String fromtime = "/html[1]/body[1]/div[21]/div[2]/ul[1]/li[4]/span[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/div[1]/input";
	String fromtimedata = "02:00 PM";
	String totime = "/html[1]/body[1]/div[21]/div[2]/ul[1]/li[4]/span[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/div[3]/input";
	String totimedata = "05:00 PM";
	String wednesday = "//tr[@id='wednesday']//i[@class='activateBusinessHour']";
	String thursday = "//tr[@id='thursday']//i[@class='activateBusinessHour']";
	String friday = "//tr[@id='friday']//i[@class='activateBusinessHour']";
	String noteforhours = "//textarea[@id='hours_notes']";
	String noteforhoursdata = "Our working hours";
	String dummyclick = "//ul[@class='sidebar_tab_nav']";
	String contactnotifications = "//div[text()='Saved']";
	String contactnotificationdata = "Saved";
	String closuresholidays = "//li[@id='colosures_info_tab']";
	String addholiday = "//i[@class='fa fa-plus-circle addHolidayButton']";
	String addcustomholiday = "//button[@id='addCustomHolidayButton']";
	String datecalender = "//input[@id='fromdate_input'][@placeholder='DD-MM-YY']";
	String selectdate = "/html/body[1]/div[45]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[1]";
	String holidaytitle = "//div[@class='title']//input[@id='custom_holiday_title']";
	String holidaytitledata = "@Festival_day_2018";
	String holidaycurrentdata = "@holiday_2018";
	String addnote = "//span[text()='Add Notes']";
	String addnotefield = "//div[@id='addNotesContainer']//input[@id='custom_holiday_note']";
	String addnotedata = "@national holiday_2018";
	String addnotecurrentdata = "@official holiday_2018";
	String repeatityearly = "//span[@class='repeatYearToggle']";
	String saveholiday = "//button[@id='customHolidaySaveButton']";
	String holidaynotadded = "//div[text()='From Date cannot be lesser than Current Date.']";
	String holidaynotaddeddata = "From Date cannot be lesser than Current Date.";
	String holidaynotification = "//div[text()='Holiday Added.']";
	String holidaynotificationdata = "Holiday Added.";
	String adddefault = "//div[@class='addDefaultHolidays']/h6[2]/span[1]";   //get class attribute
	String adddefaultoff="selectAllCheckBox";
	String adddefaulton="selectAllCheckBox checked";
	
	//search for content
	String searchbusinesshours="Business Hours";
	String searchbusinessvisible="//div[@class='businessHours']";
	String searchholidays="holidays";
	String searchholidaysvisible="//div[@class='closuresHolidays']";
	String searchaccountdetails="account details";
	String searchaccountdetailsvisible="//div[@class='accountDetails']";
	String searchform="new message form";
	String searchformvisible="//ul[@id='formList_tab']/li[2]";    //get class attribute
	String searchformvisibledata="sub_tab_select";
	String searchscenario="Electrical Issues";
	String searchscenariovisible="//div[text()='Electrical Issues']";
	String searchcontact="Test_2018_$";
	String searchcontactvisible="//div[@class='contacts-list-holder']/ul[1]/li[4]";   //get class attribute
	String searchcontactvisibledata="selected";
	String searchdeliverymethod="Test_2018";
	String searchdeliverymethodvisible="//div[@class='contacts-list-holder']/ul[1]/li[1]/cite[1]"; //get class attribute
	String searchdeliverymethodvisibledata="checked";
	String searchformsettings="form settings";
	String searchformsettingsvisible="//div[@class='content_inner_container']/div[1]/ul[1]/li[1]/div[1]/ul[1]/ul[1]/li[1]";
	String searchforformtab="form";
	String searchfieldsettings="field settings";
	String searchfieldsettingsvisible="//div[@class='content_inner_container']/div[1]/div[1]/ul[1]";
	String searchaddfield="add field";
	String searchaddfieldvisible="//div[@class='content_container']/div[1]/div[5]/div[2]/div[1]/ul[1]/li[1]";
	String searchformtab="form";
	String searchformtabvisible="//div[@id='form_setting']//div[@class='sub_tab_bar']";
	String searchscenariotab="scenario";
	String searchscenariotabvisible="//div[@onclick='addNewScenario();']";
	String searchcontacttab="contact";
	String searchcontacttabvisible="//ul[@id='deliverymethod']//li[text()='All Contacts']";
	String searchdetailstab="details";
	String searchdetailstabvisible="//div[@class='accountDetailsHeader']";
	String searchquailtyscore="Quality score";
	String searchqualityscorevisible="//div[@class='formComponents']";
	
	// switch board
	String popup = "//div[@class='greeting']";
	String closepopup = "//div[@class='greeting-wrap open-modal']/div[1]/i[1]";
	String verifyscriptingfield = "//div[@class='component-field']/div[8]/p[1]";
	String verifyscriptingfielddata = "Verbatim\nCan you please tell your company details";

}
