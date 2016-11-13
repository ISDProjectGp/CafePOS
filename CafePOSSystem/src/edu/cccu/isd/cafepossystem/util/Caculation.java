package edu.cccu.isd.cafepossystem.util;

//!----Static class , not require to new instance // 

public class Caculation {                                  
				
	/**
	 * Get the subtotal of table
	 * @param  table       the table 
	 * @return subTotal    the total cost of all food at that table
	*/
	public static double getSubTotal(Table table){
		
		double subTotal = 0;
		
		for (int i=0;i<=table.getFoodList().size()-1;i++){
			
			subTotal += Singleton.itemList.getCost(table.getFood(i).getFoodType())*table.getFood(i).getFoodQuantity();    	
			
		}		
			
		return subTotal;
	}
	
	/**
	 * Set up the discount policy and get the subtotal after discounting
	 * @param   table                      the table 
	 * @param   discountNum                discount percentage
	 * @return  the fee atfer discounting  subtotal*discount
	 */   
   public static double setDiscountPolicy(Table table,int discountNum){
	
	   double subTotal = getSubTotal(table);
	   double chargeAfterDiscount = 0;
	  
	   chargeAfterDiscount = subTotal*((double)discountNum/100);
	   
	   return Math.round(chargeAfterDiscount * 100.0) / 100.0;
	   	   		   	   
   }
   
	/**
	 * Get the total after discounting (including the service fee)
	 * @param   table                      the table 
	 * @param   discountNum                discount percentage
	 * @return  the total                  total including the service fee
	 */   
   public static double getTotal(Table table,int discountNum){
			   			
		return Math.round(setDiscountPolicy(table,discountNum)*1.1 * 100.0) / 100.0;
	}
   
   /**
	* Get the service fee after discounting
	* @param   table                      the table 
	* @param   discountNum                discount percentage
	* @return  the service fee            the service fee
	*/  
   public static double getServiceCharge(Table table,int discountNum){
			
 		return Math.round(setDiscountPolicy(table,discountNum)*0.1 * 100.0) / 100.0 ;
 	}
 
   /**
    * Get the average spending of the total 
    * @param   table                      the table 
	* @param   discountNum                discount percentage
 	* @return  the average spending       total / number of people
 	*/  
   public static double getAverageSpending(Table table,int discountNum){
		
		return Math.round(getTotal(table,discountNum)/table.getNumberOfPeople() * 100.0) / 100.0 ;
	}
   
}
