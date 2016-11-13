package edu.cccu.isd.cafepossystem.main;

import javax.swing.JOptionPane;

import edu.cccu.isd.cafepossystem.io.FileChooser;
import edu.cccu.isd.cafepossystem.userinterface.CoverPageFrame;
import edu.cccu.isd.cafepossystem.util.Singleton;

public class Main {

	// start the program from here 
	public static void main(String[] args) {
				
		String menuFilePath = importMenuPath();
		String pdfFilePath = importPDFPath();
		if (menuFilePath!=null && pdfFilePath!=null){
			//The user choose the right file path , the program will be continue // 
			Singleton.initTheCostList(menuFilePath);                                                             // Init the itemList         //
			Singleton.initPrintPDF(pdfFilePath);
			CoverPageFrame coverpageframe = new CoverPageFrame("Cover");                                         // Create the User-Interface // 
			
		} else {
			 //The user choose the wrong file path , the program will be terminated// 
			 String strToShow = "Wrong file path , Please restart the program ";
			 JOptionPane.showMessageDialog(null, strToShow);			
		}
	
	}
	
	/**
	 * Get the path of the itemListtxt
	 * @return path  the path of the itemListtxt
	 */
	public static String importMenuPath(){
					
		FileChooser fileChooser = new FileChooser(false);
		return fileChooser.getFilePath();		
	}
	/**
	 * Set the file path of PDF file
	 * @return path  the path of PDF file
	 */
	public static String importPDFPath(){
		
		FileChooser fileChooser = new FileChooser(true);
		return fileChooser.getFilePath();		
	}

}
