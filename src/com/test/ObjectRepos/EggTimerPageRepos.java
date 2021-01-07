package com.test.ObjectRepos;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Object Repository for EggTimer Page. This class is third step for POM model
public class EggTimerPageRepos {
	WebElement timerTextBox;
	WebElement startButton;
	WebDriver driver;
	
	public EggTimerPageRepos(WebDriver driver) {		
		this.driver=driver;
	}
	
	public WebElement getTimerTextBoxElement() {
		timerTextBox= driver.findElement(By.id("EggTimer-start-time-input-text"));
		return timerTextBox;
	}
	
	public WebElement getStartButtonElement() {
		startButton= driver.findElement(By.className("validTime"));
		return startButton;
	}
	
	public WebElement getElementByButtonName(String btnName) {
		List<WebElement> allButtons=driver.findElements(By.tagName("button"));
		for (Iterator<WebElement> iterator = allButtons.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if(webElement.getText().equals(btnName))
				return webElement;
			
		}
		return null;
	}
}
