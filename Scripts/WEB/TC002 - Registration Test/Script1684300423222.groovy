import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://magento.softwaretestingboard.com')

WebUI.click(findTestObject('WEB Element/Register Element/menu_createAccount'))

WebUI.waitForElementVisible(findTestObject('WEB Element/Register Element/input_firstName'), 0)

WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_lastName'), lastName)

WebUI.scrollToElement(findTestObject('Object Repository/WEB Element/Register Element/input_email'), 0)

WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_email'), email)

WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_password'), password)

WebUI.scrollToElement(findTestObject('Object Repository/WEB Element/Register Element/button_createAccount'), 0)

WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_confirmPassword'), password)

WebUI.click(findTestObject('Object Repository/WEB Element/Register Element/button_createAccount'))

WebUI.delay(10)

String randomMail = RandomStringUtils.randomAlphabetic(10) + '@email.com'

println('ini value email random: ' + randomMail)

if (WebUI.waitForElementPresent(findTestObject('WEB Element/Register Element/text_accountAlreadyExist'), 2)) {
	WebUI.scrollToElement(findTestObject('Object Repository/WEB Element/Register Element/button_createAccount'), 0)

	WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_email'), randomMail)

	WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_password'), password)

	WebUI.setText(findTestObject('Object Repository/WEB Element/Register Element/input_confirmPassword'), password)

	WebUI.click(findTestObject('Object Repository/WEB Element/Register Element/button_createAccount'))

	WebUI.verifyElementPresent(findTestObject('WEB Element/Register Element/text_accountSuccessCreated'), 10)

	WebUI.click(findTestObject('WEB Element/Register Element/button_dropdownMenu'))

	WebUI.click(findTestObject('Object Repository/WEB Element/Register Element/a_Sign Out'))

} else {
	WebUI.click(findTestObject('WEB Element/Register Element/button_dropdownMenu'))
	
	WebUI.click(findTestObject('Object Repository/WEB Element/Register Element/a_Sign Out'))
}

