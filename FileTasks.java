package Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class FileTasks {

	public static void main(String[] args) {

		FileTasks obj = new FileTasks();
		obj.countAndCopy();

	}

	void countAndCopy() {
		String filePath = "C:/Users/home/eclipse-workspace_new/javaProject1/src/Assignment/FileTasks.java";

		try {
			getCount(filePath);
			System.out.println("\nEnter the distination path for the copied file..");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String copyFilePath = reader.readLine();
			copyFile(filePath, copyFilePath);
		} catch (FileAlreadyExistsException e) {
			System.out.println("File Already Exists... Please give new path");
		} catch (NoSuchFileException e) {
			System.out.println("Wrong path... Please give new path");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void getCount(String path) throws IOException {
		try (BufferedReader file = new BufferedReader(new FileReader(path))) {
			int lineCount = 0, characterCount = 0;
			String currentLine = file.readLine();
			while (currentLine != null) {
				lineCount++;
				String[] words = currentLine.split(" ");
				for (String word : words) {
					characterCount = characterCount + word.length();
				}
				currentLine = file.readLine();
			}
			System.out.println("Number of lines = " + lineCount);
			System.out.println("Number of characters = " + characterCount);
		}
	}

	void copyFile(String filePath, String copyFilePath) throws IOException {
		File originalFile = new File(filePath);
		File copyFile = new File(copyFilePath);
		Files.copy(originalFile.toPath(), copyFile.toPath());
		System.out.println("File successfully copied to " + copyFile.getAbsolutePath());
	}

}
