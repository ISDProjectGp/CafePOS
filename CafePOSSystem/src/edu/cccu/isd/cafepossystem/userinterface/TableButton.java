package edu.cccu.isd.cafepossystem.userinterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import edu.cccu.isd.cafepossystem.io.PictureLoader;
import edu.cccu.isd.cafepossystem.util.Singleton;

public class TableButton extends JButton {
	
	Integer ArrayIndex;              
	CoverPageFrame converPageFrame; // use to Update Mother Frame //
	
	public TableButton (Icon iconPic,Integer i,CoverPageFrame converPageFrame){
		
		super(iconPic);
		
		// return Coverpageframe//	
		this.converPageFrame = converPageFrame;
		this.ArrayIndex = i;
		
		// Basic Setting of the TableButton // 
		tableButtonSetting();
		
		// Init the Action Listener //
		initaActionListener();
	}
	
	/**
	 * Basic Setting of the TableButton
	 */
	public void tableButtonSetting(){
				
		setPreferredSize(new Dimension(140,71));		
		
	}
	
	/**
	 * Init the Action Listener
	 */
	public void initaActionListener(){
			
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (Singleton.tableInUsingList.getTable(ArrayIndex)==null){
				
			    // kick the empty table , add the table to the tableInUsingList , go to table page frame // 		
				Integer  numberOfPeople=0;
					
				while (numberOfPeople <= 0){			  
					String  userInputString = JOptionPane.showInputDialog("Please enter the customer number of table again:");				  
					numberOfPeople = Integer.parseInt(userInputString);				  
				}
				
				Singleton.tableInUsingList.addTable(ArrayIndex, numberOfPeople);				
				setIcon(PictureLoader.tableInUse[ArrayIndex]);		
				System.out.println(converPageFrame);
				
				
	   		    converPageFrame.updateUI();	   		        			
	   		    converPageFrame.updateUIInUse(ArrayIndex);
				
				
				TablePageFrame tablePage = new TablePageFrame("TablePage",ArrayIndex,converPageFrame); 
				
				}
				else{
					// the table is not empty , go to table page frame    //  	
					TablePageFrame tablePage = new TablePageFrame("TablePage",ArrayIndex,converPageFrame);
					}
			}
		});
	}
}
