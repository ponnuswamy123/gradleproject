package Addfields;

public class Addfieldsdata {

	// web page URL
	String URL = "https://staging.formcreator.full.io/";

	// login page
	String email = "//input[@class='input-default']";
	String emaildata = "pavithran.sunder@anywhere.co";
	String password = "//input[@class='input-default input-pwd']";
	String passworddata = "pavithran";
	String signinbutton = "//button[@class='btn btn-blue login-btn']";

	// fetch account
	String fetch = "//div[@class='fetch btn_cst hint--left']";
	String fetchdata="fetch btn_cst hint--left";
	String bellnotification="//a[@class='fa fa-bell notificationIcon unreadNotification']";
	String bellnotification2="//a[@class='fa fa-bell notificationIcon']";
	String bellnotificationdata="fa fa-bell notificationIcon unreadNotifications";
	String account = "//input[@id='accountNumber']";
	String accountdata = "8005000076";
	String load = "//a[@class='btn_cst']";
	
	// add form and change name
	String addformbutton="//em[@id='add_new_form']";
	String newform="//div[@class='content_container']/div[1]/div[1]/ul[1]/li[2]";
	String formsettings="//div[@id='form_setting']/div[1]/ul[1]/li[3]/div[1]";
	String formname="//div[@class='content_inner_container']/div[1]/ul[1]/li[1]/div[1]/ul[1]/ul[1]/li[1]/input[1]";
	String formnamedata="Newly_added_form_Test_2018_@";
	String verifyformname="//div[@class='content_container']/div[1]/div[1]/ul[1]/li[2]/div[1]/span";
	String verifyformnamedata="Newly_added_form_Test_2018_@";
	
	//add field
	String addfield="//div[@id='form_setting']/div[1]/ul[1]/li[1]/div[1]";
	String addfieldcontainer="//div[@class='content_container']/div[1]/div[5]/div[2]/div[1]/ul[1]/li[1]//div[@class='field_list_content']";
	
	// field settings container
	String fieldsettingscontainer="//div[@class='content_container']/div[1]/div[6]";
	
	// Add name field 
	String name="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[1]";
	String namefield="//div[@id='formcontent']/ul[1]/li[1]";
	String namefieldscriptdata="Your good name please";
	
	// text length and restrict special character
	String restrictspecialcharacter="//li[@id='specialCharacter_li']/input[1]";
	String restrictspecialcharacterdata="@";
	String textlength="//li[@id='text_length_li']/input[1]";
	String textlengthdata="10";
	
	// Add phone field
	String phone="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[2]";
	String phonefield="//div[@id='formcontent']/ul[1]/li[2]";
	String phonefieldtextlength="10";
	String phonefieldscriptdata="Your phone number please";
	
	// Agent verification and system verification
	String agentverification="//li[@id='spellCheck_li']/div[2]";//get class attribute
	String toggleverifyoffdata="switch fr off";
	String toggleverifyondata="switch fr on";
	String systemverification="//li[@id='system_verification_required_li']/div[2]";// get class attribute
	
	// Add Email
	String Emailfield="//div[@id='formcontent']/ul[1]/li[3]";
	String emailfieldtextlength="20";
	String emailfieldrestrictspecialcharacter="#";
	String emailfieldscriptdata="Your email id please";
	
	// Add decision tree
	String numberofbranch="//div[@class='fields']/input[1]";
	String numberofbranchdata="4";
	String submitbutton="//div[@class='submit_btn']/button[1]";
	String decisiontree="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[4]";
	String decisiontreefield="//div[@class='verticalBarPadding']";
	String fieldlabel="//li[@id='field_label_li']/textarea";
	String decisiontreelabeldata="Call transfer and other features";
	String addanotherbranch="//div[@class='choice']/ul[1]/li[4]/div[1]";
	String decisiontreeoption1="//div[@class='choice']/ul[1]/li[1]/input[1]";
	String decisiontreeoption1data="Set repeat";
	String decisiontreeoption2="//div[@class='choice']/ul[1]/li[2]/input[1]";
	String decisiontreeoption2data="Call transfer";
	String decisiontreeoption3="//div[@class='choice']/ul[1]/li[3]/input[1]";
	String decisiontreeoption3data="on call schedule";
	String decisiontreeoption4="//div[@class='choice']/ul[1]/li[4]/input[1]";
	String decisiontreeoption4data="Appointment";
	String decisiontreeoption5="//div[@class='choice']/ul[1]/li[5]/input[1]";
	String decisiontreeoption5data="dropdown";
	
	// Add message field
	String messagefield="//div[@id='formcontent']/ul[1]/li[4]";
	String fieldscript="//li[@id='field_script_li']/textarea";
	String messagefieldrestrictspecialcharacter="@";
	
	// Add scripting field
	String scriptingfield="//div[@id='formcontent']/ul[1]/li[5]";
	String scriptingfieldlabeldata="Can you please tell your company name";
	String verbatim="//li[@id='verbatim_li']/div[2]";
	
	// Instruction field
	String instructionfield="//div[@id='formcontent']/ul[1]/li[6]";
	String instructionfieldlabeldata="company details";
	
	// Company field
	String companyfield="//div[@id='formcontent']/ul[1]/li[7]";
	String companyfieldtextlength="30";
	String companyfieldrestrictspecialcharacterdata="%";
	
	// URL field
	String urlfield="//div[@id='formcontent']/ul[1]/li[8]";
	String urlfieldlabeldata="weblink";
	String url="//li[@id='field_value_li']/textarea";
	String urldata="www.google.com";
	
	// finish call field
	String finishcallfield="//div[@id='formcontent']/ul[1]/li[9]";
	String savebutton="//li[@id='sendBatchSendField']/ul[1]/li[1]/div[3]";//get class attribute
	String savebuttononverify="switch fr on";
	
	// Single line text field
	String singlelinetext="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[11]";
	String singlelinetextfield="//div[@id='formcontent']/ul[1]/li[10]";
	String SLTnumberonly="//li[@id='numbers_only_li']/div[2]";
	String singlelinetextlength="30";
	String singlrlinerestrictspecialcharacter="$";
	
	// first name field
	String firstname="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[12]";
	String firstnamefield="//div[@id='formcontent']/ul[1]/li[11]";
	String firstnamefieldtextlength="15";
	String firstnamefieldrestrictspecialcharacter="&";
	
	// last name field
	String lastname="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[13]";
	String lastnamefield="//div[@id='formcontent']/ul[1]/li[12]";
	String lastnamefieldtext="5";
	String lastnamefieldrestrictspecialcharacter="!";
	
	// date field
	String date="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[14]";
	String datefield="//div[@id='formcontent']/ul[1]/li[13]";
	String required="//li[@id='required_li']/div[2]";
	String dateformat="//li[@id='dateFormat_li']/div[1]";
	String selectdateformat="//li[@id='dateFormat_li']/div[1]/ul[1]/li[2]";
	
	//city field
	String city="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[15]";
	String cityfield="//div[@id='formcontent']/ul[1]/li[14]";
	String cityfieldtext="9";
	String cityfieldrestrictspecialcharacter="#";
	
	// state field
	String state="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[16]";
	String statefield="//div[@id='formcontent']/ul[1]/li[15]";
	
	// zip code
	String zipcode="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[17]";
	String zipcodefield="//div[@id='formcontent']/ul[1]/li[16]";
	String zipcodetext="7";
	String zipcoderestrictspecialcharacter="%";
	
	// address1 field
	String address1="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[18]";
	String address1field="//div[@id='formcontent']/ul[1]/li[17]";
	String address1fieldtext="15";
	String address1restrictspecialcharacter="$";
	
	// iframe field
	String iframe="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[19]";
	String iframefield="//div[@id='formcontent']/ul[1]/li[18]";
	String iframeurl="//li[@id='field_label_li']/textarea";
	String iframeurldata="www.google.com";
	String widthofiframe="//span[@id='width_li']/input[1]";
	String widthofiframedata="500";
	String heigthofiframe="//span[@id='height_li']/input[1]";
	String heigthofiframedata="600";
	
	// Set repeat
	String setrepeat="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[20]";
	String setrepeatfield="//ul[@class='level2']/li[1]/ul[1]/li[1]";
	String setrepeatminmizetree="//ul[@class='level2']/li[1]/code[1]";
	String Setrepeatduration="//li[@id='repeateTypeConfigurationli']/span[1]";
	String setrepeatselectduration="//li[@id='repeateDuration']/span[3]";
	
	// drop down field
	String dropdown="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[21]";
	String dropdownfield="//div[@id='formcontent']/ul[1]/li[19]";
	String dropdownfieldlabeldata="Ex employee";
	String adddropdownoptions="//div[@id='drop_down_options']/ul[1]/li[1]/div[2]";
	String renameoptions1name="//div[@id='drop_down_options']/ul[1]/li[1]/input[1]";
	String renameoptions1namedata="Yes";
	String renameoptions2name="//div[@id='drop_down_options']/ul[1]/li[2]/input[1]";
	String renameoptions2namedata="No";
	String dropdownelseoption="//div[@class='otheroption']/div[1]/i[1]";
	String dropdownelseoptionname="//div[@class='otheroption']/input[1]";
	String dropdownelseoptionnamedata="Others";
	
	// on call schedule
	String oncallschedule="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[22]";
	String oncallschedulecalender="//div[@class='oncall_popup_select_calendar']/ul[1]/li[2]/span[1]";
	String oncallscheduleaccount="//div[@class='oncall_popup_select']/div[1]/div[1]/h4[1]/span[1]";//get class attribute
	String oncallscheduleaccountdata="radio_btn checked";
	String oncallschedulesubmit="//div[@class='oncall_popup_footer']/button[1]";
	String oncallscheduleminmizetree="//ul[@class='level1']/li[1]/ul[1]/li[3]/code[1]";
	String oncallschedulefield="//ul[@class='level1']/li[1]/ul[1]/li[3]/ul[1]/li[1]/div[1]";
	
	// call transfer
	String calltransfer="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[23]";
	String calltransferfield="//ul[@class='level2']/li[2]/div[1]";
	String calltransferselectcontact="//li[@id='callTransferContainerLi']/ul[1]/li[1]/h3/span[1]";
	String calltransferminmizetree="//ul[@class='level1']/li[1]/ul[1]/li[2]/code[1]";
	
	// Appointment
	String appointment="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[24]";
	String appointmentfield="//ul[@class='level1']/li[1]/ul[1]/li[4]/ul[1]/li[1]/div[1]";
	String appointmentprovider="//li[@id='appointmentConfiguration_li']/div[1]/span[1]";
	String appointmentproviderselect="//li[@id='appointmentConfiguration_li']/div[1]/ul[1]/li[1]";
	String appointmenttree="//ul[@class='level1']/li[1]/ul[1]/li[4]/code[1]";
	
	// time field
	String time="//div[@class='form_field_holder']/ul[1]/li[1]/div[1]/ul[1]/li[25]";
	String timefield="//div[@id='formcontent']/ul[1]/li[20]";
	String timefieldlabeldata="Available time";
	String timefieldformat="//li[@id='timeFormat_li']/div[1]/span[1]";
	String timefieldselectformat="//li[@id='timeFormat_li']/div[1]/ul[1]/li[2]";
	
	//group2
	String group2="//div[@class='form_field_holder']/ul[1]/li[2]/h2[@class='list_header_selected']";
	String group2container="//div[@class='content_container']/div[1]/div[5]/div[2]/div[1]/ul[1]/li[2]//div[@class='field_list_content']";
	
	//country field
	String countryfield="//div[@id='formcontent']/ul[1]/li[21]";
	String countrytextlengthdata="9";
	String countryrestrictspecialcharacterdata="@";
	
	//customer status field
	String customerstatusfield="//div[@id='formcontent']/ul[1]/li[1]";
	String customerstatusfieldlabeldata="Available at";
	String customerstatusexper="//li[@id='customer_status_expiration']/input[1]";
	String customerstatusexperdata="/html/body[1]/div[48]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[2]";
	
	//multi select field
	String multiselectfield="//div[@id='formcontent']/ul[1]/li[23]";
	String preferedlocation="prefered location";
	String multiselectadd="//div[@id='drop_down_options']/ul[1]/li[1]/div[1]";
	String multiselectoption1="//ul[@class='choices_field_list ui-sortable']/li[1]/input[1]";
	String multiselectoption1data="Chennai";
	String multiselectoption2="//ul[@class='choices_field_list ui-sortable']/li[2]/input[1]";
	String multiselectoption2data="New Delhi";
	String multiselectelse="//div[@class='otheroption']/div[1]/i[1]";
	String multiselectelsename="//div[@class='otheroption']/input[1]";
	String multiselectelsenamedata="Others";
	
	//hidden field
	String hiddenfield="//div[@id='formcontent']/ul[1]/li[24]";
	String hiddenfieldlabeldata="Hidden details";
	String hiddenfieldvalue="//li[@id='field_value_li']/textarea[1]";
	String hiddenfieldvaluedata="Information";
	
	//custom phone field
	String customphonefield="//div[@id='formcontent']/ul[1]/li[25]";
	String customphonefieldtext="10";
	
	//Address2 field
	String address2field="//div[@id='formcontent']/ul[1]/li[26]";
	String address2textlengthdata="20";
	String address2restrictspecialcharacterdata="&";
	
	// Save form
	String saveform="//div[@class='save_fields']/div[1]";
	String saveformyes="//div[@class='popupFooter']/button[1]";
	String notificationsaveform="//div[@id='notification' and text()='Saved Successfully.....']";
	String notificationsaveformdata="Saved Successfully.....";
	
	//publish form
	String publishform="//div[@class='publish_fields']/div[1]";
	String publishformyes="//div[@class='popupFooter']/button[1]";
	String notificationpublishform="//div[@class='editAfford']/p[1]";
	String notificationpublishformdata="This form will be currently active in Switchboard";
	String closenotification="//div[@class='popupAfford']/i[1]";
	
	//view in switch board
    String viewindropdown="//div[@class='view-in']//i[@class='fa fa-angle-up']";
    String viewinsb="//ul[@style='display: block;']//a[@class='viewSb'][@onclick='loadAccountInSb()']";
    
    // switch board 
    String popup="//div[@class='greeting']";
    String closepopup="//div[@class='greeting-wrap open-modal']/div[1]/i[1]";
    String verifynamefield="//div[@class='component-field']/div[1]/p[1]";
    String verifynamefielddata="Your good name please";
    String verifyphonefield="//div[@class='component-field']/div[3]/p[1]";
    String verifyphonefielddata="Your phone number please";
    String verifyemailfield="//div[@class='component-field']/div[5]/p[1]";
    String verifyemailfielddata="Your email id please";
    String verifyscriptingfieldverbatim="//div[@class='component-field']/div[8]/p[1]/b[1]";
    String verifyscriptingfieldverbatimdata="Verbatim";
    String verifyscriptingfield="//div[@class='component-field']/div[8]/p[1]";
    String verifyscriptingfielddata="Verbatim\nCan you please tell your company name";
    
    //all field are visible 
    String verifynameinput="//div[@class='component-field']/div[2]/input[1]";
    String verifyphoneinput="//div[@class='component-field']/div[4]/div[1]/input[1]";
    String verifyemailinput="//div[@class='component-field']/div[6]/input[1]";
    String verifymessageinput="//div[@class='component-field']/div[7]/textarea[1]";
    String verifycompanyinput="//div[@class='component-field']/div[10]/input[1]";
    String verifysinglelinetextinput="//div[@class='component-field']/div[12]/input[1]";
    String verifyfirstnameinput="//div[@class='component-field']/div[13]/input[1]";
    String verifylastnameinput="//div[@class='component-field']/div[14]/input[1]";
    String verifydateinput="//div[@class='component-field']/div[15]/div[1]/input[1]";
    String verifycityinput="//div[@class='component-field']/div[16]/input[1]";
    String verifystateinput="//div[@class='component-field']/div[17]//select[1]";
    String verifyzipcodeinput="//div[@class='component-field']/div[18]/input[1]";
    String verifyaddress1input="//div[@class='component-field']/div[19]/input[1]";
    String verifydropdowninput="//div[@class='component-field']/div[21]//select[1]";
    String verifycountryinput="//div[@class='component-field']/div[22]/input[1]";
    String verifyprefered="//div[@class='component-field']/div[23]/label[1]";
    String verifycustomphoneinput="//div[@class='component-field']/div[25]//input[1]";
    String verifyaddress2input="//div[@class='component-field']/div[26]/input[1]";
    String setrepeatselect="//div[@class='component-field']/div[27]/ol[1]/li[1]/label[1]/span[1]";
    String calltransferselect="//div[@class='component-field']/div[27]/ol[1]/li[2]/label[1]/span[1]";
    String calltransferyesselect="//div[@class='component-field']/div[27]/div[8]/ol[1]/li[1]/label[1]/span[1]";
    String verifyfinishcall="//div[@class='component-field']/div[27]/div[8]/div[7]/i[1]";
    
    //empty branch
    String emptybranchalert="//div[@class='popup-Container']//div[@class='popupMiddle']/p[1]";
    String alertok="//div[@class='popup-Container']/div[3]/button[1]";
    String selectemptybtranch="//div[@class='tree_view']/ul[1]/li[1]/ul[1]/li[5]/h3[1]/div[1]";
    String deletebranch="//div[@class='tree_view']/ul[1]/li[1]/ul[1]/li[5]/h3[1]/div[1]/cite[1]";
    
}
