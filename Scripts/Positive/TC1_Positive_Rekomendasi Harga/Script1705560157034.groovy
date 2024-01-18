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

'Buka Web BTN Property'
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.Base_URL)

'Masukkan Pemasukkan Total'
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga/Input_Penghasilan Total'),Penghasilan_Total)
WebUI.takeScreenshot()

'Masukkan Pengeluaran'
WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga/Input_Pengeluaran'),Pengeluaran)
WebUI.takeScreenshot()

'Pilih Jangka Waktu'
WebUI.selectOptionByLabel(findTestObject('Page_Hitung Harga/Select_Jangka Waktu'),Jangka_Waktu, true)
WebUI.takeScreenshot()

'Klik Tombol Hitung'
WebUI.click(findTestObject("Object Repository/Page_Hitung Harga/button_Hitung"))

'Vaerifikasi Hasil berasil menampilkan rekomendasi harga yang sesuai dengan perhitungan formula'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Hitung Harga/Title_Harga Properti Maksimal'), 0)

/* Formula yang digunakan saat ini */
String value = Jangka_Waktu.replaceAll("[^0-9]", "")
def bil_Penghasilan_Total = Double.parseDouble(Penghasilan_Total)
def bil_Pengeluaran = Double.parseDouble(Pengeluaran)
def bil = Integer.parseInt(value)
def hasil = bil_Penghasilan_Total - bil_Pengeluaran
def bil_hasil = hasil * bil * 4
println(bil_hasil)
def valRekomHarga = WebUI.getText(findTestObject("Page_Hitung Harga/Result_Rekomendasi Harga"))
String hasil_RekomHarga = valRekomHarga.replaceAll("[^0-9]", "")
WebUI.verifyEqual(hasil_RekomHarga, hasil_RekomHarga)
WebUI.takeScreenshot()


WebUI.closeBrowser()

