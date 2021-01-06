package com.test.page;

import java.util.HashSet;
import java.util.Iterator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

import com.test.ObjectRepos.EggTimerPageRepos;
import com.test.config.Setup;

//This class corresponds to the Web elements and actions related to EggTimer Page
public class EggTimerPage extends Setup {
	EggTimerPageRepos pageRepos;
	HashSet<Long> actualTimer= new HashSet<Long>();	
	
	public EggTimerPage() {		
		pageRepos= new EggTimerPageRepos(driver);
	}
	
	public void navigateTo(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Url Navigation not successful...");
			e.printStackTrace();
		}		
	}
	
	public String getPageTitle() {
		try {
			String pageTitle= driver.getTitle();
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public boolean verifyPage() {
		try {
			WebElement timeTxtBox=pageRepos.getTimerTextBoxElement();
			if(timeTxtBox.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean provideTimer(String time) {
		try {
			WebElement timeTxtBox=pageRepos.getTimerTextBoxElement();
			if(timeTxtBox.isDisplayed()) {
				timeTxtBox.sendKeys(Keys.CLEAR);
				timeTxtBox.sendKeys(time);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean clickStartButton() {
		try {
			WebElement startBtn=pageRepos.getElementByButtonName("Start");
			String toolTipValue= startBtn.getAttribute("data-tip");
			if(toolTipValue.isEmpty()) {
				startBtn.click();
				return true;
			}				
			else 
				return false;				
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public void verifyTimer(String time) {
		HashSet<String> timerHashSet= new HashSet<String>();
		try {
			String title=driver.getTitle();			
			while(!title.equals("time expired!")) {
				if(!title.isEmpty())
					timerHashSet.add(title);				
				title=driver.getTitle();					
			}
			Thread.sleep(2000);			
		} 
		catch (UnhandledAlertException | InterruptedException e) {
			
		}
		finally  {	
			System.out.println(timerHashSet);
			generateHashSetWithSeconds(timerHashSet);
	    } 			
	}
	
	private void generateHashSetWithSeconds(HashSet<String> customSet) {
		Iterator<String> it = customSet.iterator();
	     while(it.hasNext()){
	        String[] mixedTimer=it.next().split(":");
	        long timerSeconds=(Integer.parseInt(mixedTimer[0])*3600)+(Integer.parseInt(mixedTimer[1])*60)+(Integer.parseInt(mixedTimer[2]));
	        actualTimer.add(timerSeconds);
	     }
	     System.out.println(actualTimer);
	}
	
	public boolean validateTimer(String time) {	
		if(time.contains("hour") && time.contains("minutes")) {
			time=String.valueOf((Long.parseLong(time.split(" ")[0])*3600)+Long.parseLong(time.split(" ")[2])*60);
		}
		else if(time.contains("hour")) {
			time=String.valueOf(Long.parseLong(time.split(" ")[0])*3600);
		}
		else if(time.contains("minutes") && time.contains("second")) {
			time=String.valueOf((Long.parseLong(time.split(" ")[0])*60)+Long.parseLong(time.split(" ")[2]));
		}	
		else if(time.contains("minutes")) {
			time=String.valueOf((Long.parseLong(time.split(" ")[0])*60));
		}
		if(time.contains("m")) {
			time=String.valueOf(Long.parseLong(time.substring(0, time.indexOf("m")))*60);
		}
		for (long i = 0; i < Long.parseLong(time)-1; i++) {
			if(!actualTimer.contains(i)) {
				System.out.println("Missing value in Set::"+i);
				return false;	
			}											
		}			
		return true;
	}	
}
