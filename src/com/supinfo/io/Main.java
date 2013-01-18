package com.supinfo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		doItWithBytes();
		doItWithChars();
	}
	
	public static void doItWithBytes() throws IOException {
		System.out.println("\nDo it with Bytes : \n");
		byte[] buffer = new byte[11];
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("toto.txt");
			
			File file = new File("toto2-bytes.txt");
			
			if(file.exists())
				file.delete();
			
			file.createNewFile();
			
			fos = new FileOutputStream(file);
			
			while(fis.read(buffer) > -1) {
				System.out.print(new String(buffer));
				
				fos.write(buffer);
				
				buffer = new byte[buffer.length];
			}
			
			fos.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(fis != null) fis.close();
			if(fos != null) fos.close();
		}
	}
	
	
	public static void doItWithChars() throws IOException {
		System.out.println("\nDo it with Chars : \n");
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader("toto.txt"));
			
			File file = new File("toto2-chars.txt");
			
			if(file.exists())
				file.delete();
			
			file.createNewFile();
			
			writer = new PrintWriter(file);
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				
				writer.println(line);
			}
			
			writer.flush();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(reader != null) reader.close();
			if(writer != null) writer.close();
		}
	}

}