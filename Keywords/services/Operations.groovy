package services

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.util.KeywordUtil

import org.openqa.selenium.By
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Robot
import java.awt.event.KeyEvent


public class Operations {


	@Keyword
	/*example input : text="my name is jon",strReplace="jon",strReplacement="jhon"
	 *result : "my name is jhon"  */
	def strReplace(String text,strReplace,strReplacement ){
		String str = text.replaceFirst(strReplace,strReplacement);
		return str
	}
	@Keyword
	def strToSingleTabAndSpace(String text){
		def dlTab = text.replaceAll("[\n\r]", " ");
		def str = dlTab.replaceAll(" +", " ");

		return str
	}


	@Keyword
	def strToGetNumberOnly(String text){

		String value = text.replaceAll("[^0-9]", "")
		int bil = Integer.parseInt(value)
		return (bil)
	}


	@Keyword

	def strToDouble(String jumlah){
		String bilangan = jumlah.replaceAll("[^0-9]", "")
		String bilBulat = bilangan.substring(0,bilangan.length()-2)
		String bilPecahan = bilangan.substring(bilangan.length()-2,bilangan.length())
		//convert string
		double value = Double.valueOf(bilBulat +'.'+bilPecahan)

		return(value)

	}

	@Keyword
	def getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Keyword
	def getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Keyword
	def getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Keyword
	//mobile touch swipe Page Up
	def TapOnPageUp() {
		def device_Height = Mobile.getDeviceHeight()
		println('Height :'+device_Height)
		def device_Width = Mobile.getDeviceWidth()
		println('Width :'+device_Width)
		int startX = device_Width / 2
		println('startX :'+startX)
		int endX = startX
		println('endX :'+endX)
		int startY = device_Height * 0.30
		println('startY :'+device_Height)
		int endY = device_Height * 0.70
		println('endY :'+endY)

		Mobile.swipe(startX, startY, endX, endY)

	}


	@Keyword
	//mobile touch swipe Page down
	def TapOnPageDown() {
		def device_Height = Mobile.getDeviceHeight()
		println('Height :'+device_Height)
		def device_Width = Mobile.getDeviceWidth()
		println('Width :'+device_Width)
		int startX = device_Width / 2
		println('startX :'+startX)
		int endX = startX
		println('endX :'+endX)
		int startY = device_Height * 0.30
		println('startY :'+device_Height)
		int endY = device_Height * 0.70
		println('endY :'+endY)

		Mobile.swipe(startX, endY, endX, startY)

	}
	@Keyword
	//mobile touch swipe Page down
	def SetOnPageDown(setY) {
		def device_Height = Mobile.getDeviceHeight()
		println('Height :'+device_Height)
		def device_Width = Mobile.getDeviceWidth()
		println('Width :'+device_Width)
		int startX = device_Width / 2
		println('startX :'+startX)
		int endX = startX
		println('endX :'+endX)
		int startY = device_Height * 0.30
		println('startY :'+device_Height)
		int endY = device_Height * setY
		println('endY :'+endY)

		Mobile.swipe(startX, endY, endX, startY)

	}

}
