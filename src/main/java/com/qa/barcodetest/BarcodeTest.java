package com.qa.barcodetest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import Util.jirapolicy;

public class BarcodeTest {
	
	@jirapolicy(loginTicketReady=true)
	@Test
	public void test() throws IOException, NotFoundException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\users\\gmurugan\\Downloads\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://barcode.tec-it.com/en/");
		
		String barcode=driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barcode);
		
		URL url=new URL(barcode);
		BufferedImage bufered=ImageIO.read(url);
		
		LuminanceSource source=new BufferedImageLuminanceSource(bufered);
		BinaryBitmap binary=new BinaryBitmap(new HybridBinarizer(source));
		
		Result result=new MultiFormatReader().decode(binary);
		System.out.println(result.getText());
		
	}
	@Test
	public void run() {
		Assert.assertEquals(true,false);
	}

}
