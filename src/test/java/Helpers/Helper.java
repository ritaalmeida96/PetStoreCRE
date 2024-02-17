package Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void takeScreenshot(WebDriver driver, String fileName) {
		// Verifique se o WebDriver suporta captura de tela
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

			// Capture a screenshot como um arquivo
			File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

			// Especifique o caminho onde você deseja salvar o screenshot
			String screenshotDirectory = "screenshots/";
			Path screenshotPath = Paths.get(screenshotDirectory, fileName + ".png");

			try {
				// Mova o arquivo de screenshot para o diretório especificado
				Files.move(screenshot.toPath(), screenshotPath);
				System.out.println("Screenshot salvo em: " + screenshotPath.toString());
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} else {
			System.out.println("WebDriver não suporta captura de tela.");
		}
	}

	public static String generateRandomID() {
		// Get current time in seconds
		long currentTimeSeconds = Instant.now().getEpochSecond();

		// Generate a random number
		long randomNumber = (long) (Math.random() * 1000000); // Adjust the range as needed

		// Combine the "ID" prefix with the random number
		String randomID = "ID" + currentTimeSeconds + randomNumber;

		return randomID;
	}

	public static String generateRandomVisaNumber() {
		Random rand = new Random();

		// Generate random digits for the 16-digit number
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int digit = rand.nextInt(10); // Generate a random digit (0-9)
			sb.append(digit);

			// Add space after every 3 digits except for the last group
			if ((i + 1) % 4 == 0 && i != 15) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static String generateRandomExpiryDate() {
	       Random rand = new Random();

	        // Generate a random month (1-12)
	        int month = rand.nextInt(12) + 1;

	        // Generate a random year between the current year and the next 10 years
	        int currentYear = LocalDate.now().getYear();
	        int year = currentYear + rand.nextInt(10);

	        // Format the date as MM/YYYY
	        String monthString = String.format("%02d", month); // Ensure two digits for month
	        String yearString = String.format("%04d", year); // Ensure four digits for year

	        return monthString + "/" + yearString;
	}
}