package seleniumPackage;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.testng.annotations.Test;

public class NetworkLogs {



	@Test
	public void openUrl() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devtools.addListener(Network.requestWillBeSent(), request ->
		{
				//	System.out.println(request.getRequest().getUrl());

		});

		devtools.addListener(Network.responseReceived(), response ->
		{
			//System.out.println(response.getResponse().getStatus());
			if(response.getResponse().getStatus().toString().equals("204")) {
				System.out.println(response.getResponse().getUrl());
			}
			
		});
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.quit();
	}

}
