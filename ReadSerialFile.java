package assignment3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.*;

public class ReadSerialFile {

	public static void main(String[] args) {
		
		InputStream file;
		try {
			file = new FileInputStream("D:/CrawlerData/indexTest.ser");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream (buffer);
			//deserialize the List
			@SuppressWarnings("unchecked")
			HashMap<String,HashMap<String,Object>> table =
			(HashMap<String, HashMap<String, Object>>) input.readObject();
			//display its data
			System.out.println(table.size());
			Scanner scan = new Scanner(System.in);
			
//			while(true){
//				System.out.println("Enter the token.");
//				String temp = scan.nextLine();
//				if (table.containsKey(temp)){
//					System.out.println("Found!!!");
//				}
//				else{
//				System.out.println("Not Present!!!");
//				}
//			}
			
			for (Map.Entry<String, HashMap<String, Object>> entry : table.entrySet()){	
				System.out.printf("%s\t" ,entry.getKey());
				HashMap<String, Object> tableNew = entry.getValue();
				//for (HashMap<String, Object>> entry1 : tableNew.entrySet()){
				for (Map.Entry<String, Object> entry1 : tableNew.entrySet()){
					System.out.printf("%s\t" ,"--->");
					System.out.printf("%s\t" ,entry1.getKey());
					System.out.println(" " + entry1.getValue().Locations + " " + entry1.getValue().TF + " " +
							entry1.getValue().IDF + " " + entry1.getValue().Score);
				}
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
		
		
		
		
	}

	




