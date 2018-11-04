package WSMProject.WSMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public abstract class CommonTestCase {
	public static WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://edev.framgia.vn/en");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void end() {
	//	driver.quit();
	}

	@DataProvider
	public static Object[][] SetLogin() {

		return new Object[][] { { "nguyen.thi.ngoc@framgia.com.edev", "1234567" } };

	}
	
	public static Object[][] SetChangePassword() {

		return new Object[][] { { "nguyen.thi.ngoc@framgia.com.edev", "1234567", "123456" } };

	}

	public void testLogin(String email, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wsm-btn btn-login']")));
		WebElement btnLogin = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btnLogin.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='user_email']"));
		txtEmail.sendKeys(email);

		WebElement txtPass = driver.findElement(By.xpath("//input[@id='user_password']"));
		txtPass.sendKeys(pass);

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[@class='text-center pd-top-20']/button[@type='submit']"));
		buttonLogin.submit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void logOut (){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@class='avatar']")));

		userPhoto.click();
		
		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
	}
	
	public void navigateChangePassword (String email, String pass){
		testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@class='avatar']")));
		userPhoto.click();
		WebElement btn_Account = driver.findElement(By.xpath("//a[@class='button-account' and contains(text(),'Account')]"));
		btn_Account.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Change password')]")));
		WebElement btn_ChangePassword = driver.findElement(By.xpath("//a[contains(text(),'Change password')]"));
		btn_ChangePassword.click();
	}
	
}