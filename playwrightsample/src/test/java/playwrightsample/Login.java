package playwrightsample;
import com.microsoft.playwright.*;
import com.microsoft.playwright.impl.junit.BrowserContextExtension;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dimension screenssize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenssize.getWidth();
		int height = (int)screenssize.getHeight();
		
		      Playwright playwright = Playwright.create();
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		      Page page = context.newPage();
		      page.navigate("https://uat.mortgages.hsbc.com.au");
		      page.locator("text=Broker log on").click();
		      page.locator("#email").fill("manasadivya.v@gmail.com");
		      page.locator("#password").fill("nAman@2804");
		      page.locator("#next").click();
		     // page.pause();
		      page.waitForTimeout(20000);
		      page.getByLabel("Verify").click();
		      //************************ Navigating to Request*********************//
		      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Requests")).click();
		      page.frameLocator("xpath=//iframe").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("New request")).click();
		      page.frameLocator("xpath=//iframe").locator("#reqtypesel").selectOption("pricing");
		      page.frameLocator("xpath=//iframe").locator("#reqsubtypesel").selectOption("newdeal");
		      page.frameLocator("xpath=//iframe").locator("#appExists").selectOption("appNo");
		      page.frameLocator("xpath=//iframe").locator("#prosp1").click();
		      page.frameLocator("xpath=//iframe").locator("#prosp1").fill("Manasa");
		      page.frameLocator("xpath=//iframe").locator("#prosp1").press("Tab");
		      //****************** Adding Security details *******************************//
		      page.frameLocator("xpath=//iframe").locator("//div[@id='securitysection']/div/div/button").click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByLabel("Type", new FrameLocator.GetByLabelOptions().setExact(true)).selectOption("Property");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByLabel("Value").fill("500000");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByLabel("Purpose").selectOption("Owner occupied");
		      page.frameLocator("xpath=//iframe").locator("//div[@id='myModalSecurity']/div/div/div[@class='modal-item-button']/button[@class='primaryButton']").click();
		      //****************** Adding Loan details *******************************//
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("xpath=//div[@id='loannew']/button").click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#loanlimit").fill("250000");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#productinfo").selectOption("1|Package Fixed 5 Year");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#fixedrate").selectOption("yes");
		      page.frameLocator("xpath=//iframe").locator("//div[@id='myModalLoanInfo']/div/div/div[@class='modal-item-button']/button[@class='primaryButton']").click();
		      //************* Calculate offer ************************************//
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Calculate totals")).click();
		      //************* Adding loans for Pricing Offer section***************************//
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Add loans for pricing")).click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#loanSelSearch").click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#loan1").check();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Select")).click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#competitoroffer").selectOption("compNo");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#reqendrate").fill("6");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#reqendrate").press("Tab");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("//div[@id='myModalLoanPricing']/div/div[@class='modal-item-button']/button[@class='primaryButton']").click();
		      //**************** Clicking Request offer **********************//
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Request offer")).click();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#tdval1").selectOption("Accept Offer");
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#check").check();
		      page.frameLocator("iframe[title=\"__extensions_host_frame\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Submit")).click();
		      page.waitForTimeout(20000);
		      String SR = page.frameLocator("iframe[title=\"__extensions_host_frame\"]").locator("#generatedNum").textContent();
		      System.out.println("Service Requested created and number is " +SR);
		      
		    }
		  }

