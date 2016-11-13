package edu.cccu.isd.cafepossystem.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
	private String path;
	public  ArrayList<String> textData = null;
	
	public ReadFile (String file_path) {
			this.path = file_path;
			try {
				this.textData=OpenFile();
			} catch (IOException e) {
				
			}
			
   }
		
	/**
	 * Read the item from the imported itemlist
	 * @return textData    the formated item in the list 
	*/
	private ArrayList<String> OpenFile() throws IOException{
		
		FileReader fr = new FileReader (path);
		BufferedReader textReader = new BufferedReader (fr);
		
		ArrayList<String> textData = new ArrayList<>();
		
		int i = 0 ; 
	    
		while (true){
					
		    String data = textReader.readLine();
		    
		    if (data == null){
		    	break;
		    } else {		    	
		    	textData.add(data);
		  
		    	i = i + 1;
		    }	
		}				
		textReader.close();
	
		return textData;
	}
	


	
	

}
