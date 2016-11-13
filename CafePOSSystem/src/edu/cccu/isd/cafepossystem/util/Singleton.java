package edu.cccu.isd.cafepossystem.util;

import edu.cccu.isd.cafepossystem.io.PrintPDF;

//!---Static class , no need to create a new instance ----!// 

public class Singleton {
	
	public static TableInUsingList tableInUsingList = new TableInUsingList();     // tableInUsingList - store a the table which is not empty //   
	public static ItemList itemList = null;                                       // itemlist - store the item that import from the itemtxt  (It is required to initTheCostList at the start of the program ¡Aotherwise return null)// 
	public static PrintPDF printpdf = null;
	
	/**
	 * Initialize the items and the tableInUsing list  
	 * @param txtPath   the path of the itemlisttxt
	 */
	public static void initTheCostList(String txtPath){
		 
		itemList = new ItemList(txtPath);
	

	}	
	/**
	 * Initialize the path of the PDF 
	 * @param pdfPath   the path of the PDF
	 */
	public static void initPrintPDF(String pdfPath){
		
		printpdf = new PrintPDF(pdfPath);	
		
	}
				
}
