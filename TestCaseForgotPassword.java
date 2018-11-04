package WSMProject.WSMProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCaseForgotPassword extends CommonTestCase {
//	WebDriverWait wait = new WebDriverWait(driver, 10);
	// Check component of Forgot Password screen.
/*	@Test(priority = 1, dataProvider = "SetLogin")
	public void testComponentForgotPasswordScreen(String email, String pass) {
		super.navigateChangePassword(email, pass);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement lbl_TitleChangePasswordScreen= driver.findElement(By.xpath("//div[@class='panel-heading']/*[contains(text(),'Password Changed')]"));		
		assertEquals(lbl_TitleChangePasswordScreen.getText(), "Password Changed");
		
		WebElement lbl_Password= driver.findElement(By.xpath("//*[@class='col-md-3 control-label' and .='Password']"));		
		assertEquals(lbl_Password.getText(), "Password");
		
		WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));		
		assertTrue(txt_Password.isDisplayed());	
		
		WebElement lbl_PasswordConfirmation = driver.findElement(By.xpath("//*[@class='col-md-3 control-label' and .='Password confirmation']"));		
		assertEquals(lbl_PasswordConfirmation.getText(), "Password confirmation");
		
		WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
		assertTrue(txt_PasswordConfirmation.isDisplayed());							
		
		WebElement btn_OK = driver.findElement(By.xpath("//input[@type='submit']"));	
		assertEquals(btn_OK.getAttribute("value"), "Update");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Check change password successfully
	@Test(priority = 2, dataProvider = "SetLogin")
	public void testChangePasswordSuccessfully(String email, String pass) {
		String newpass = "123456";
		super.navigateChangePassword(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement txt_CurrentPassword= driver.findElement(By.xpath("//*[@id='user_current_password']"));	
		txt_CurrentPassword.sendKeys(pass);
		
		WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));	
		txt_Password.sendKeys(newpass);
		
		WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
		txt_PasswordConfirmation.sendKeys(newpass);
		
		WebElement btn_OK = driver.findElement(By.xpath("//*[@name='commit']"));		
		btn_OK.click();
		
		WebElement msg_SuccessfulChangePasswordConfirmation = driver.findElement(By.xpath("//*[contains(text(),'Your account has been updated successfully.']"));
		assertEquals(btn_OK.getText(), "Your account has been updated successfully.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Check navigate to Working Calendar
		@Test(priority = 3, dataProvider = "SetLogin")
		public void testNavigateToWorkingCalendar(String email, String pass) {
			String newpass = "123456";
			super.navigateChangePassword(email, pass);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			WebElement txt_CurrentPassword= driver.findElement(By.xpath("//*[@id='user_current_password']"));	
			txt_CurrentPassword.sendKeys(pass);
			
			WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));	
			txt_Password.sendKeys(newpass);
			
			WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
			txt_PasswordConfirmation.sendKeys(newpass);
			
			WebElement btn_OK = driver.findElement(By.xpath("//*[@name='commit']"));		
			btn_OK.click();
			
			WebElement lbl_WorkingCalendar = driver.findElement(By.xpath("//*[contains(text(),'Total of times for fining')]"));
			assertEquals(lbl_WorkingCalendar.getText(), "Total of times for fining:");
			
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
		// Check relogin
				@Test(priority = 4, dataProvider = "SetLogin")
				public void testrelogin(String email, String pass) {
					String newpass = "123456";
					super.navigateChangePassword(email, pass);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					
					WebElement txt_CurrentPassword= driver.findElement(By.xpath("//*[@id='user_current_password']"));	
					txt_CurrentPassword.sendKeys(pass);
					
					WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));	
					txt_Password.sendKeys(newpass);
					
					WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
					txt_PasswordConfirmation.sendKeys(newpass);
					
					WebElement btn_OK = driver.findElement(By.xpath("//*[@name='commit']"));		
					btn_OK.click();
					
					super.logOut();
					super.testLogin(email, newpass);
		//			WebElement msg_LogIn = driver.findElement(By.xpath("//*[@id='flash-message']"));
		//			assertSame(msg_LogIn.getText(), "Signed in successfully.");
					WebElement lbl_WorkingCalendar = driver.findElement(By.xpath("//*[contains(text(),'Total of times for fining')]"));
					assertEquals(lbl_WorkingCalendar.getText(), "Total of times for fining:");
					super.logOut();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
				// Check Login With Old Password
				@Test(priority = 5, dataProvider = "SetLogin")
				public void testLoginWithOldPassword(String email, String pass) {
					String newpass = "1234567";
					super.navigateChangePassword(email, pass);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					
					WebElement txt_CurrentPassword= driver.findElement(By.xpath("//*[@id='user_current_password']"));	
					txt_CurrentPassword.sendKeys(pass);
					
					WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));	
					txt_Password.sendKeys(newpass);
					
					WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
					txt_PasswordConfirmation.sendKeys(newpass);
					
					WebElement btn_OK = driver.findElement(By.xpath("//*[@name='commit']"));		
					btn_OK.click();
					
					super.logOut();
					super.testLogin(email, pass);
					
					WebElement msg_Error = driver.findElement(By.xpath("//*[contains(text(),'Invalid email or password.')]"));		
					assertTrue(msg_Error.isDisplayed());	
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	*/			
				// Check max/minlength Password 
					@Test(priority = 6, dataProvider = "SetLogin")
					public void testMaxMinPassword(String email, String pass) {
						super.navigateChangePassword(email, pass);
//						WebDriverWait wait = new WebDriverWait(driver, 10);		
				//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
						WebElement btn_OK = driver.findElement(By.xpath("//input[@type='submit']"));	
						btn_OK.click();
						WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));		
						txt_Password.sendKeys("1");
						
						WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
						txt_PasswordConfirmation.sendKeys("GeneralInformationGeneralInformationGeneralInformationGeneralInformationGeneralInformationGeneralInformationGeneralInformation123");	
						
						WebElement msgError_Password= driver.findElement(By.xpath("//*[@id='user_password-error']"));		
						assertEquals(msgError_Password.getText(), "Please enter at least 6 characters");
														
						WebElement msgError_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation-error']"));		
						assertEquals(msgError_PasswordConfirmation.getText(), "Please enter max 128 characters");		
						logOut();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
					// Check match Password 
					@Test(priority = 7, dataProvider = "SetLogin")
					public void testMatchPassword(String email, String pass) {
						super.navigateChangePassword(email, pass);
//						WebDriverWait wait = new WebDriverWait(driver, 10);		
					//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
						WebElement btn_OK = driver.findElement(By.xpath("//input[@type='submit']"));	
						btn_OK.click();
						WebElement txt_Password= driver.findElement(By.xpath("//*[@id='user_password']"));		
						txt_Password.sendKeys("12345678");
						
						WebElement txt_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));		
						txt_PasswordConfirmation.sendKeys("87654321");	
																				
						WebElement msgError_PasswordConfirmation = driver.findElement(By.xpath("//*[@id='user_password_confirmation-error']"));		
						assertEquals(msgError_PasswordConfirmation.getText(), "Password cannot match");		
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
}