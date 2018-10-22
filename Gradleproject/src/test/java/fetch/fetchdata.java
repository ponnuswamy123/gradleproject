package fetch;

public class fetchdata {
	// verify web element is visible
	String switchboard = "//div[@class='view-in']/ul[1]/li[1]/a[1]";
	String cwa = "//div[@class='view-in']/ul[1]/li[2]/a[1]";
	String distributedsource = "//div[@class='view-in']/ul[1]/li[3]/a[1]";
	String accounttitle = "//div[@class='accountInfo']/label[@for='account']";
	String accounttitledata = "Account:";
	String addfield = "//div[@id='form_setting']/div[1]/ul[1]/li[1]";
	String fieldsettings = "//div[@id='form_setting']/div[1]/ul[1]/li[2]";
	String formsettings = "//div[@id='form_setting']/div[1]/ul[1]/li[3]";
	String form = "//div[@id='side_bar']/ul[1]/li[1]";
	String scenario = "//div[@id='side_bar']/ul[1]/li[2]";
	String contacts = "//div[@id='side_bar']/ul[1]/li[3]";
	String details = "//div[@id='side_bar']/ul[1]/li[4]";
	String qualityscorenotification = "//div[@class='componentsForm']/img[1]";
	String accountsettings = "//div[@class='sidedropdownContainer']/div[1]/i[1]";
	String addform = "//ul[@id='formList_tab']/em[1]";
	String fullscreenformbutton = "//div[@id='content_wrapper']/div[1]/div[1]/div[1]/div[1]/div[1]";

	// fetch account
	String fetch = "//div[@class='fetch btn_cst hint--left']";
	String fetchdata = "fetch btn_cst hint--left";
	String fetchpopup = "//div[@class='popupFetch']/div[1]/h3[1]";
	String fetchpopupdata = "Fetch Account";
	String bellnotification = "//a[@class='fa fa-bell notificationIcon unreadNotification']";
	String bellnotification2 = "//a[@class='fa fa-bell notificationIcon']";
	String bellnotificationdata = "fa fa-bell notificationIcon unreadNotifications";
	String account = "//input[@id='accountNumber']";
	String accountdata = "8005000076";
	String invalidaccountnotification = "//div[@id='notification'][text()='Invalid Account Number. ....']";
	String invalidaccountnotificationdata = "Invalid Account Number. ....";
	String load = "//a[@class='btn_cst']";
	String loaddata = "Load";
	String validaccount = "//b[contains(text(),'Fetching Integrations...')]";
	String validaccountdata = "Fetching Integrations...";

	// view in switch board
	String viewin = "//label[@class='view-in-label']";
	String viewindata = "View in :";
	String viewindropdown = "//div[@class='view-in']/span[1]/i[1]";
	String viewinsb = "//ul[@style='display: block;']//a[@class='viewSb'][@onclick='loadAccountInSb()']";
	String viewinsblinksymbol = "//div[@class='view-in']/ul[1]/li[1]/a[1]/i[1]";
	String viewincwa = "//div[@class='view-in']/ul[1]/li[2]/a[1]";
	String viewincwasymbol = "//div[@class='view-in']/ul[1]/li[2]/a[1]/i[1]";
	String viewinds = "//div[@class='view-in']/ul[1]/li[3]/a[1]";
	String viewindssymbol = "//div[@class='view-in']/ul[1]/li[3]/a[1]/i[1]";

}
