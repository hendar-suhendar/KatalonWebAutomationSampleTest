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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

public class verify_tables {

	@Keyword
	def verify_row1_of_table(no_column_get,expected_value) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		table: for (int i = 0; i < 1; i++) {

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			println(Cols.get(no_column_get).getText())

			new services.Operations().verifyTextPresent(Cols.get(no_column_get).getText(),expected_value)
		}
	}

	@Keyword
	def verify_row1_and_table(no_row,no_column,expected_value) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		table: for (int i = 0; i < Rows.size(); i++) {

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			if(i==no_row){
				println(Cols.get(no_column).getText())
				new services.Operations().verifyTextPresent(Cols.get(no_column).getText(),expected_value)
				table:break
			}
		}
	}
	@Keyword
	def get_txt_row1_column(no_column) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		table: for (int i = 0; i < 1; i++) {

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

			return Cols.get(no_column).getText()
		}
	}

	@Keyword
	def datatableActionByRows(no_column,expected_value,action_column,unique_object) {
		/*Example input:
		 no_column = 10
		 String expected_value = 'Waiting For Approval'
		 def action_column = 11
		 def unique_object = "//*[@class ='view view-icon']"
		 */
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		table: for (int i = 0; i < Rows.size(); i++) {

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			println(Cols.get(no_column).getText())

			if (Cols.get(no_column).getText().equalsIgnoreCase(expected_value)) {

				Cols.get(action_column).findElement(By.xpath(unique_object)).click()
				table:break
			}
		}
	}

	@Keyword
	def datatableActionByCencel(no_column,expected_value,no_column2,expected_value2,action_column) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		table: for (int i = 0; i < Rows.size(); i++) {

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			println(Cols.get(no_column).getText())
			println(Cols.get(no_column2).getText())
			if (Cols.get(no_column).getText().equalsIgnoreCase(expected_value) && Cols.get(no_column2).getText().equalsIgnoreCase(expected_value2)) {
				def tag1 = action_column+1
				def tag2 = i+1
				Cols.get(action_column).findElement(By.xpath("//table/tbody/tr["+tag2+"]/td["+tag1+"]/div/div/span["+tag2+"]")).click()
				table:break
			}
		}
	}
}
