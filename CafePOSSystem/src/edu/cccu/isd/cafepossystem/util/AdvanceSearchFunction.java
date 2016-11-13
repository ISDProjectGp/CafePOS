package edu.cccu.isd.cafepossystem.util;

import java.util.ArrayList;

//!----Static class , not require to new instance // 

public class AdvanceSearchFunction {
	
	// Update every time to update the list // 
	/**
	 * To return the searching list according to the string input
	 * @param  args             the string to be find 
	 * @return suggestionList   A list store the samilier names of items
	*/
	public static ArrayList<Integer> searchRelatedItems(String args){
		
		ArrayList<Integer> suggestionList = new ArrayList<Integer>();
		
		if (Singleton.itemList !=null){
			
		  for (int i=0;i<Singleton.itemList.size()-1;i++){
			  if (Singleton.itemList.getFoodName(i).startsWith(args)){
				  
				  suggestionList.add(i);
				  System.out.println(Singleton.itemList.getFoodName(i));
			  
			  }
		  	  
		  }
		  return suggestionList;
		} else {
			// return the error dialog that the itemlist is null // 
		}
		 return null;
	}
}
				  
  