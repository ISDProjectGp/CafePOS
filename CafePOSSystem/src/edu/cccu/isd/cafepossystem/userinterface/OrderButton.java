package edu.cccu.isd.cafepossystem.userinterface;

import javax.swing.JButton;

public class OrderButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer tmpint;
	
	public OrderButton (String name,Integer tenin){
		
		super(name);
		
		//¦^¶ÇCoverpageframe//
		this.tmpint = tenin;
	
		
	}
	
	/**
	 * Return the temp int of the order button
	 * @return tmpint  the temp integer
	*/
	public Integer gettemint(){
		
		return tmpint;
		
		
	}
	
	
}
