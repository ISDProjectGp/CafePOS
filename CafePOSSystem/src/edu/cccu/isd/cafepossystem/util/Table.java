package edu.cccu.isd.cafepossystem.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Table {
	
	private int numberOfPeople = 0 ;                   // Number of people on that table   //            
	private List<Food> foodList = null;                // To store the fodd    //
	private Date timeStamp;                            // The time for the table started to be occupied // 
	 
	// To create the instance of table , it is required to set up the number of people , the timeStamp is caculated by the system ,//
	// at the same time ,it will create a list to store the food of that table                                                     // 
    public Table(int numberOfPeople){
		
		this.numberOfPeople=numberOfPeople;
		this.foodList = new ArrayList<Food>();
		this.timeStamp = Calendar.getInstance().getTime() ;
		
	}

	/**
	 * Add new order food to the food list
	 * @param foodType   the food type no. 
	 * @param amount     the amount of the food
	 */
	public void addFood(int foodType,int amount){
		
		foodList.add(new Food(foodType,amount));
		
	}
	
	/**
	 * Remove the ordered food from the food list
	 * @param foodType   the food type no. 
	 * @param amount     the amount of the food
	 */
    public void RemoveFood(int foodType,int amount){
		
		foodList.remove(new Food(foodType,amount));
	}

    /**
	 * Get the food list 
	 * @return foodList    the list that contain the ordered food 
	 */ 
    public List<Food> getFoodList(){
		return this.foodList;   	
    	
    }

    /**
   	 * Get the amount of the people of the table
   	 * @return numberOfPeople    the amount of the people on that table  
   	 */ 
    public int getNumberOfPeople(){
		return this.numberOfPeople;
    	
    }

    /**
   	 * Get the food from the food list 
   	 * @param  Order      the order no.
   	 * @return Food       the food with the specific order no. 
   	 */ 
    public Food getFood(int Order){  	
    	return foodList.get(Order);
    }

    /**
   	 * Get the table time 
   	 * @return the time when open the table 
   	 */ 
    public Date getTimeStamp() {
		return timeStamp;
	}
         
}
