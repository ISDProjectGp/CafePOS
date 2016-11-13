package edu.cccu.isd.cafepossystem.util;

import java.util.LinkedHashMap;

import edu.cccu.isd.cafepossystem.io.ReadFile;

public class ItemList extends LinkedHashMap<String, Double> {

	private static final long serialVersionUID = 1L;

	// To import the itemlist , txt path is required //  
	public ItemList(String path){
		
		        super();		
		        //  read the itemListHere  // 
				ReadFile readFile = new ReadFile(path);
				if (readFile.textData!=null) { 

					int i = 0 ;				
					while (i<readFile.textData.size()-2) {	
					//Get the food name and the price from the txt and imput to the itemlist //
				  
					put(readFile.textData.get(i), Double.parseDouble(readFile.textData.get(i+1)));			
					i = i+2;					
					
					}	
					
				} else {
					// fail to import the item list , return error // 
				}
		
	}
     /**
   	 * Get the cost of the food from the food list
   	 * @param  foodType   the the food type no.  
   	 * @return Cost       the cost of that food 
   	 */ 
	public double getCost(int foodType){
		
		return (double) values().toArray()[foodType];
	}
	 /**
   	 * Get the name of the food from the food list
   	 * @param  foodType   the the food type no.  
   	 * @return Name       the name of that food 
   	 */ 
	public String getFoodName(int foodType){
		
		return (String) keySet().toArray()[foodType];
	}
	
}
