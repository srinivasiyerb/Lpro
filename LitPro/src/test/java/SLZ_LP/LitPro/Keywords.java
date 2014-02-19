package SLZ_LP.LitPro;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert; 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
// testng
import org.testng.Assert;

import util.TestUtil;

public class Keywords extends AppTest{
	public static String MainwindowID;
	public static String Dropdowndata;
	
	// navigate  
	public static String navigate(){
		APPICATION_LOGS.debug("Executing Navigate");
		if(wbdv == null){
			if(CONFIG.getProperty("testBrowser").equals("Firefox")){
			//	hudv = new HtmlUnitDriver();
				//wbdv = new ChromeDriver();
				//System.out.println("test1");
				wbdv = new FirefoxDriver();
				driver = new EventFiringWebDriver(wbdv);
				driver.manage().window().maximize();
				driver.navigate().to(CONFIG.getProperty(object));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			
			
		driver.navigate().to(CONFIG.getProperty(object));
		//System.out.println("Test2");
		}	
			return "Pass";
		
	}
	
	
	public static String implicitWait(){
		APPICATION_LOGS.debug("Executing clickLink");
		try{
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while having implicit wait -"+ object + t.getMessage());
			return "Fail - Implicit wait did not get executed";
		}
		
		return "Pass";
	}
	
	
			
	public static String clickLinkText(){
		APPICATION_LOGS.debug("Executing clickLink");
		try{
		driver.findElement(By.linkText(OR.getProperty(object))).click();
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while clicking on link -"+ object + t.getMessage());
			return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	

	public static String Findelement(){
		APPICATION_LOGS.debug("Finding Element on runtime");
		try{
		driver.findElement(By.id(OR.getProperty(object))).click();
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while finding an element -"+ object + t.getMessage());
			return "Fail - Element Not Found";
		}
		
		return "Pass";
	}
	
	public static String Driverclose(){
		APPICATION_LOGS.debug("Closing the tabbed window");
		try{
		driver.close();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		//System.out.println("alert1");
		al.accept();
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while finding an element -"+ object + t.getMessage());
			return "Fail - Element Not Found";
		}
		
		return "Pass";
	}	
	
	public static String Alertclose(){
		APPICATION_LOGS.debug("Closing the Alert window");
		try{
		
			Alert al = driver.switchTo().alert();
			
			al.accept();

//System.out.println("alert2");
		}catch(Throwable t){
			// report error
			APPICATION_LOGS.debug("Error while closing the Alert -"+ object + t.getMessage());
			return "Fail - Element Not Found";
		}
		
		return "Pass";
	}
	
	public static String verifyText(){
		APPICATION_LOGS.debug("Executing verifyText");
		String expected=APPTEXT.getProperty(object);
//		System.out.println(expected);
		String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
//		System.out.println(actual);
		APPICATION_LOGS.debug(expected);
		APPICATION_LOGS.debug(actual);
		try{
			Assert.assertEquals(actual.trim() , expected.trim());
		}catch(Throwable t){
			// error
			APPICATION_LOGS.debug("Error in text - "+object);
			APPICATION_LOGS.debug("Actual - "+actual);
			APPICATION_LOGS.debug("Expected -"+ expected);
			return "Fail -"+ t.getMessage(); 
			
		}
		
		return "Pass";
		
	}
	
	public static String input() throws InterruptedException{
		
		APPICATION_LOGS.debug("Executing input Keyword");
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name, testRepeat);
//		System.out.println(data_column_name);
//		Updating the newly created Organization
		if(data_column_name.equals("OrganizationName")){
			String Odate = TestUtil.now("ddMMMhhmm");
			data=data+"_Smoke School_"+Odate;
			testData.setCellData("TC03", "SchoolName", 2, "");
			testData.setCellData("TC03", "SchoolName", 2, data);
//			Thread.sleep(2000L);
			testData.setCellData("TC04", "CustomerName", 2, "");
			testData.setCellData("TC04", "CustomerName", 2, data);
//			Thread.sleep(2000L);
			testData.setCellData("TC05", "AccountName", 2, "");
			testData.setCellData("TC05", "AccountName", 2, data);
			
		}
		
		if(data_column_name.equals("Email")){
			String Edate = TestUtil.now("ddyy.hhmmssaaa");
			data=data+Edate+"@mailinator.com";
			
		}
//		Updating the invoice number field
		if(data_column_name.equals("InvoiceNumber")){
			String Idate = TestUtil.now("ddyyhhmmss");
			data=Idate;
			testData.setCellData("TC03", "InvoiceNumber", 2, "");
//			Thread.sleep(2000L);
			testData.setCellData("TC03", "InvoiceNumber", 2, data);
//			Thread.sleep(3000L);
			
		}
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	public static String clickButton(){
		APPICATION_LOGS.debug("Executing click Keyword");
		
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	public static String windowHandler2(){
		APPICATION_LOGS.debug("Executing WindowHandler Keyword");
		
		
		try{
			Set<String> windowids = driver.getWindowHandles();
//			String windowids = driver.getTitle();
			Iterator<String> iter= windowids.iterator();
//			System.out.println(windowids);
			windowids = driver.getWindowHandles();
			 iter= windowids.iterator();
			 String mainWindowId=iter.next();
			 //System.out.println(iter.next());
			 String tabbedWindowId=iter.next();
			 driver.switchTo().window(tabbedWindowId);
			 
//			System.out.println(mainWindowId);
//			System.out.println(tabbedWindowId);
			 
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	
	public static String windowHandler1(){
		APPICATION_LOGS.debug("Executing WindowHandler Keyword");
		
		try{
			Set<String> windowids = driver.getWindowHandles();
			Iterator<String> iter= windowids.iterator();
			windowids = driver.getWindowHandles();
			String nextWindowId=null;
			for (String Winid: windowids)
			{
				nextWindowId=Winid;
			}
			
			MainwindowID=iter.next();
			System.out.println("Window Handler  = "+MainwindowID);
			driver.switchTo().window(nextWindowId);
			
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String MainWinfocus(){
		
		APPICATION_LOGS.debug("Executing Main Window Focus Keyword");
		
		try{
			
			Thread.sleep(3000);
			System.out.println("From Alert: Before Switching = "+MainwindowID);
			//System.out.println(MainwindowID);
			driver.switchTo().window(MainwindowID);
			System.out.println("From Alert: After Switching = "+MainwindowID);
			//System.out.println(MainwindowID);
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while foucusing to the Main Window-"+ object + t.getMessage());
				
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
		
	}
	
	
	public static String clickEnter(){
		APPICATION_LOGS.debug("Executing clickEnter Keyword");
				
		try{
			String enterPressed = Keys.chord(Keys.RETURN);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(enterPressed);
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Enter Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	

	
	public static String clickEsc(){
		APPICATION_LOGS.debug("Executing clickEsc Keyword");
				
		try{
			String escPressed = Keys.chord(Keys.ESCAPE);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(escPressed);
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Escape Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	public static String MovetoElement(){
		APPICATION_LOGS.debug("Executing MovetoElement Keyword");
				
		try{
			WebElement ElemOnScreen = driver.findElement(By.xpath(OR.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.moveToElement(ElemOnScreen).build().perform();
//			ElemOnScreen.isEnabled();
			ElemOnScreen.click();	
		}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clearing the field -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();

			}
			
			return "Pass";
	}
	

	
	public static String clearAll(){
		APPICATION_LOGS.debug("Executing clearAll Keyword");
				
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).clear();
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clearing the field -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	
	
	public static String clickDropDown(Object[] params ){
		APPICATION_LOGS.debug("Executing clickDropDown Keyword");
				
		try{
			
			Integer value = null;
			if (params != null) {
				if (params.length == 1) {
					value = new Integer((String) params[0]);
				}
			}
			
			WebElement dropdown= driver.findElement(By.xpath(OR.getProperty(object)));
			dropdown.click();
			List<WebElement> dropdownvalues = dropdown.findElements(By.tagName("option"));
//			System.out.println(dropdownvalues.size());
			for (int i=0 ; i<dropdownvalues.size() ; i++){
//				System.out.println(dropdownvalues.get(i).getText());
			}
			if (value != null) {
				Dropdowndata = dropdownvalues.get(value).getText();
				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Dropdowndata);
				
			}
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while selecting the values from Dropdown -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	
	public static String rostersUpload(){
//		clickDropDown(0);
		APPICATION_LOGS.debug("Executing rostersUpload Keyword");
		String StudentRoster= System.getProperty("user.dir")+"/config/Student_Details.csv";
		String TeacherRoster= System.getProperty("user.dir")+"/config/Teacher_Details.csv";
		
		try{
			
			if(Dropdowndata.equals("Student")){
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(StudentRoster);
			}else if(Dropdowndata.equals("Teacher")){
				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(TeacherRoster);
			}
			
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while Rosters Upload -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	
	public static String applyPermissionsDropDown(){
		APPICATION_LOGS.debug("Executing applyPermissionsDropDown Keyword");
				
		try{
			
			WebElement dropdown= driver.findElement(By.xpath(OR.getProperty(object)));
			dropdown.click();
			List<WebElement> dropdownvalues = dropdown.findElements(By.tagName("option"));
//			System.out.println(dropdownvalues.size());
			for (int i=0 ; i<dropdownvalues.size() ; i++){
//				System.out.println(dropdownvalues.get(i).getText());
			}
			String Dropdowndata = dropdownvalues.get(1).getText();
			
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Dropdowndata);
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Enter Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	public static String allDropDownvalues(){
		APPICATION_LOGS.debug("Executing clickDropDown Keyword");
				
		try{
			
			WebElement dropdown= driver.findElement(By.xpath(OR.getProperty(object)));
			dropdown.click();
			List<WebElement> dropdownvalues = dropdown.findElements(By.tagName("option"));
//			System.out.println(dropdownvalues.size());
			for (int i=0 ; i<dropdownvalues.size() ; i++){
//				System.out.println(dropdownvalues.get(i).getText());
				String Dropdowndata = dropdownvalues.get(i).getText();
//				System.out.println(Dropdowndata);
				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Dropdowndata);
			}
			
					
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on Enter Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
	
	public static String select(){
		APPICATION_LOGS.debug("Executing select Keyword");
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		
		
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String clickCheckBox(){
     APPICATION_LOGS.debug("Executing clickCheckBox Keyword");
		
		try{
//			driver.findElement(By.xpath(OR.getProperty(object)));
			
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			driver.findElement(By.xpath(OR.getProperty(object))).isSelected();
			}catch(Throwable t){
				// report error
				APPICATION_LOGS.debug("Error while clicking on checkbox -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String Wait() throws NumberFormatException, InterruptedException{
	     APPICATION_LOGS.debug("Executing wait");
	  // extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
	     Thread.sleep(Long.parseLong(data));
	     return "Pass";
	}


		
	

}
