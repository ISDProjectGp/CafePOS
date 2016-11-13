package edu.cccu.isd.cafepossystem.util;

import java.util.HashMap;

public class TableInUsingList extends HashMap<Integer, Table> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Add a new table into the tableInUsingList 
	 * @param tableNum        the table no. of the new table
	 * @param numberOfPeople  the amount of the people of the new table
	 */
	public void addTable(int tableNum,int numberOfPeople){
		
		if (!containsKey(tableNum))
		{
		put(tableNum,new Table(numberOfPeople));
		} else {
			//    Return a dialog that the table with the specific table number is occupied   //
		}
				
}

	/**
	 * Delete the table from the tableInUsingList
	 * @param tableNum        the table no. of the table 
	 */
	public void releaseTable(int tableNum){
		
		if (containsKey(tableNum))
		{
			remove(tableNum);
		
		} else {
	        // Return a dialog that the table is empty   //
	    }
}
 
	/**
	 * Get the table from the tableInUsingList 
	 * @param tableNum        the table no. of the table 
	 */
	public Table getTable(int tableNum){
		
		if (containsKey(tableNum))
		
		{
		   return get(tableNum);
		} 
		// Return a dialog that No such table  //
		return null;
	    
	}

}
