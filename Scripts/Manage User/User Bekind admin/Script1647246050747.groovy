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
import org.openqa.selenium.Keys as Keys

static String randomString(String chars, int length) {
	Random rand = new Random()

	StringBuilder sb = new StringBuilder()

	for (int i = 0; i < length; i++) {
		sb.append(chars.charAt(rand.nextInt(chars.length())))
	}
	
	return sb.toString()
}


WebUI.callTestCase(findTestCase('Login/Test Case Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - List User/a_Create User'))

WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - List User/a_Bekind Admin'))

String Fullname = randomString(chars, 16)

String Email = randomString(chars, 10) + '@gmail.com'

String phoneNumber = '08' + randomString(nums, 9)

WebUI.setText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/input__full_name'), 
    Fullname)

WebUI.setText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/input__email'), Email)

WebUI.setText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/input__phone_number'), 
    phoneNumber)

WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/span_Choose Pronvince'))

WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/span_Kabupaten Kepulauan Seribu'))

WebUI.setText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/textarea_Address_address'), 
    'lorem ipsum is dummy text')

WebUI.setEncryptedText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/input__password'), 
    '8SQVv/p9jVTHLrggi8kCzw==')

WebUI.setEncryptedText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/input__cPassword'), 
    '8SQVv/p9jVTr42PP0SyOXg==')

WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/button_Kirim'))

//WebUI.verifyElementText(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - Create Admin/ berhasil di masukkan'), 
//    '')
WebUI.click(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - List User/a_Manage Campaign'))

//WebUI.rightClick(findTestObject('Object Repository/Create User Bekind Admin/Page_Bekind - List User/div_vika rahmawati'))