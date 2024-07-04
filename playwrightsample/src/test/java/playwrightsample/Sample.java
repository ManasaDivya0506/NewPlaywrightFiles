package playwrightsample;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright pw = Playwright.create();
		Browser b= pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	//	BrowserContent bc = b.newContext();
		Page pg = b.newPage();
		pg.navigate("https://uat.mortgages.hsbc.com.au");
		
		
		

	}

}
