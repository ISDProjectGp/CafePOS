package edu.cccu.isd.cafepossystem.util;

import java.util.Calendar;
import java.util.Date;

public class Food {
	
	private int foodType = 0 ;                        // The type of the food // 
	private int foodQuantity = 0 ;                    // The amount of the food  //
	private Date timeStamp;                           // The time when order this food //  
	
	// To create the instance of food , it is required to set up the type and the amount of the food , the timeStamp is caculated by the system //  
	public Food(int foodType ,int foodQuantity){
		
		this.setFoodQuantity(foodQuantity);
		this.setFoodType(foodType);
		this.setTimeStamp(Calendar.getInstance().getTime()) ;
	}
	/**
	 * Get the order time of the food 
	 * @return the time   
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Set the order time of the food 
	 * @param timeStamp   order time of the food
	 */
	private void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Get the the food type
	 * @return foodType the food type no.  
	 */
	public int getFoodType() {
		return foodType;
	}

	/**
	 * Set the food type
	 * @param foodQuantity   type of food
	 */
	private void setFoodType(int foodType) {
		this.foodType = foodType;
	}

	/**
	 * Get the amount of the food 
	 * @return foodQuantity   amount of the food
	 */
	public int getFoodQuantity() {
		return foodQuantity;
	}

	/**
	 * Set the amount of the food 
	 * @param foodQuantity   amount of food
	 */
	private void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

}
