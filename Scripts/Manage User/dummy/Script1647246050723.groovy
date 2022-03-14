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

String chars = 'abcdefghijklmnopqrstuvwxyz'

String nums = '01234567890'

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://dev.bekindhub.org/')

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind/input_Email_email'), 'admin@bekindhub.org')

WebUI.setEncryptedText(findTestObject('Object Repository/Dummy/Page_Bekind/input_Password_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.click(findTestObject('Object Repository/Dummy/Page_Bekind/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Dummy/Page_Bekind - Overview/span_Manage User'))

WebUI.click(findTestObject('Object Repository/Dummy/Page_Bekind - List User/a_Create User'))

WebUI.click(findTestObject('Object Repository/Dummy/Page_Bekind - List User/a_Bekind Admin'))

String FullName = randomString(chars, 12)

String Email = randomString(chars, 8) + '@bekind.org'

String Address = randomString(chars, 36)

String About = randomString(chars, 24)

String phoneNumber = '08' + randomString(nums, 9)

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/input__full_name'), FullName)

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/input__email'), Email)

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/input__phone_number'), phoneNumber)

//WebUI.setText(findTestObject('Page_Bekind - Create Admin/span_Choose Pronvince_select2-selection__arrow'), 'Aceh')
WebUI.selectOptionByLabel(findTestObject('Page_Bekind - Create Admin/Province_IDN'), 'Kabupaten Aceh Selatan', false)

WebUI.selectOptionByLabel(findTestObject('Page_Bekind - Create Admin/City_Aceh'), 'Kabupaten Aceh Selatan', false)

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/textarea_Address_address'), Address)

WebUI.setText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/textarea_About_about'), About)

WebUI.setEncryptedText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/input__password'), '8SQVv/p9jVTHLrggi8kCzw==')

WebUI.setEncryptedText(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/input__cPassword'), '8SQVv/p9jVTHLrggi8kCzw==')

WebUI.click(findTestObject('Object Repository/Dummy/Page_Bekind - Create Admin/button_Kirim'))

static void jQ_click(String selector, String iFrameSelector = null) {
    comment('jQ_click (Page_Bekind - Create Admin/span_Choose Pronvince_select2-selection__arrow)' + selector)

    String js = '$(arguments[0]).click();'

    if (iFrameSelector) {
        js = '$(arguments[1]).contents().find(arguments[0]).click();'
    }
    
    WebUI.executeJavaScript(js, Arrays.asList(selector, iFrameSelector))
}

static String randomString(String chars, int length) {
    Random rand = new Random()

    StringBuilder sb = new StringBuilder()

    for (int i = 0; i < length; i++) {
        sb.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return sb.toString()
}

