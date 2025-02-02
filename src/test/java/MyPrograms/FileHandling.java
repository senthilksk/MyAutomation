package MyPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

public class FileHandling {


	@Test
	public File createFile() {

		File newFile = new File("Java.txt");
		try {
			if(newFile.createNewFile())
				System.out.println("File created");
			else
				System.out.println("File exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFile;
	}

	@Test
	public void writeFile() {

		FileWriter filewriter;
		try {
			filewriter = new FileWriter(createFile());
			filewriter.write("Writing in a created file");
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void readFileScanner() {

		Scanner Reader = null;
		try {
			Reader = new Scanner(createFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Traversing File Data
		while (Reader.hasNextLine()) {
			String data = Reader.nextLine();
			System.out.println(data);
		}

		Reader.close();
	}




}
