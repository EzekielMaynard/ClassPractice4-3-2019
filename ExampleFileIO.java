package inClassFileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;

public class ExampleFileIO {
	public static void main (String []args) {
		ExampleFileIO fio = new ExampleFileIO();
		fio.playingWithFiles();
		fio.usingTextFiles();
	}

	public void playingWithFiles() {
		//Writing a Byte File		
		try {
		OutputStream byteFile = Files.newOutputStream(Paths.get("src/myFirstFile.bin"), StandardOpenOption.CREATE);
		byteFile.write(117);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading from a Byte File
		try {
			InputStream byteFile = Files.newInputStream(Paths.get("src/myFirstFile.bin"));
			System.out.println("Value in byte file is: " + byteFile.read());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void usingTextFiles() {
		//Writing text file
		try{
		BufferedWriter textFile = Files.newBufferedWriter(Paths.get("src/TextFile.bin"), StandardOpenOption.CREATE);
		textFile.write("Bugs Bunny 90 80\n");
		textFile.write("Daffy Duck 70 85\n");
		textFile.write("Daisy Duck 95 85\n");
		textFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Reading text file
		try {
		BufferedReader textFile = Files.newBufferedReader(Paths.get("src/TextFile.bin"));
		String tempLine = textFile.readLine();
		while (tempLine!=null) {
			System.out.println(tempLine);
			tempLine = textFile.readLine();
		}
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
}
