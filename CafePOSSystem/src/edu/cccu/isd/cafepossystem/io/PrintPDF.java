/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */
 
package edu.cccu.isd.cafepossystem.io;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import edu.cccu.isd.cafepossystem.util.Caculation;
import edu.cccu.isd.cafepossystem.util.Singleton;
 

public class PrintPDF {
	
	private String path; 

	public PrintPDF(String file_path){  

    	this.path = file_path ;
    }
 
   /**
     * Creates a PDF document.
     * @param     head         the head of the temp foodlist  
     * @param     tails        the tails of the temp foodlist  
     * @param     tableNum     the number of that table
     * @param     tails
     * @throws    DocumentException 
     * @throws    IOException 
     */   
  public void printFoodList(int head ,int tails ,int tableNum)throws DocumentException, IOException {
    	
    	String timeAndDate = Calendar.getInstance().getTime().toString();
    	timeAndDate =  timeAndDate.replaceAll(" ","_");
    	timeAndDate =  timeAndDate.replaceAll(":","_");
    	String absolutePath = path+ "\\" + tableNum + "_" +timeAndDate+".pdf";
    	
    	Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(absolutePath));  
    	
        document.open();        
        document.add(new Paragraph(" Order List ")); 
        document.add(new Paragraph("Table : "+tableNum + "           Time : "+Calendar.getInstance().getTime().toString()));
 
        
        for (int i=head;i<tails;i++){
         
   		 Integer foodType = Singleton.tableInUsingList.getTable(tableNum).getFood(i).getFoodType();   		 
   		 
   		 document.add(new Paragraph(i-head+1+ ".   Food : "+Singleton.itemList.getFoodName(foodType))); 
   		 document.add(new Paragraph(i-head+1+ ".   Amount : "+Singleton.tableInUsingList.getTable(tableNum).getFood(i).getFoodQuantity()));  
   		 document.add(new Paragraph("                                                           ")); 
   	    } 
        
       
        
        document.close();
    }
    
  /**
   * Creates a PDF document.
   * @param tableNo         the number of that table
   * @param discountPercent the discount percentage 
   * @throws    DocumentException 
   * @throws    IOException 
   */   
  public void printInvoice(int tableNo,int discountPercent) throws DocumentException, IOException {
    	
    	String timeAndDate = Calendar.getInstance().getTime().toString();
    	timeAndDate =  timeAndDate.replaceAll(" ","_");
    	timeAndDate =  timeAndDate.replaceAll(":","_");
    	String absolutePath = path+ "\\" + tableNo + "_" +timeAndDate+".pdf";
    	
    	Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(absolutePath));  
    	int tempin = tableNo+1; 
        document.open();        
        
        document.add(new Paragraph(" Invoice ")); 
        document.add(new Paragraph("Table : "+tempin));
        document.add(new Paragraph("Number of People : "+Singleton.tableInUsingList.getTable(tableNo).getNumberOfPeople()));
        document.add(new Paragraph("Starting Time : "+Singleton.tableInUsingList.getTable(tableNo).getTimeStamp()));
        document.add(new Paragraph("Leaving Time : "+Calendar.getInstance().getTime().toString()));
        document.add(new Paragraph("                                                           ")); 
        document.add(new Paragraph(" FoodList "));  
      
   
        for (int i=0;i<Singleton.tableInUsingList.getTable(tableNo).getFoodList().size();i++){
            
      		 Integer foodType = Singleton.tableInUsingList.getTable(tableNo).getFood(i).getFoodType();   		 
      		 
      		 document.add(new Paragraph(i+1+ ".   Food : "+Singleton.itemList.getFoodName(foodType))); 
      		 document.add(new Paragraph(i+1+ ".   Amount : "+Singleton.tableInUsingList.getTable(tableNo).getFood(i).getFoodQuantity()));  
      		 document.add(new Paragraph("                                                           ")); 
      		 
      	    } 
     
        
        document.add(new Paragraph("Total : $"+Caculation.getSubTotal(Singleton.tableInUsingList.getTable(tableNo))));
        document.add(new Paragraph("Charge After discount : $"+Caculation.setDiscountPolicy(Singleton.tableInUsingList.getTable(tableNo),discountPercent)));
        document.add(new Paragraph("Total (Including the service charge) : $"+Caculation.getTotal(Singleton.tableInUsingList.getTable(tableNo),discountPercent)));
        document.add(new Paragraph("ServiceCharge : $"+Caculation.getServiceCharge(Singleton.tableInUsingList.getTable(tableNo),discountPercent)));
        document.add(new Paragraph("Average Spending : $"+Caculation.getAverageSpending(Singleton.tableInUsingList.getTable(tableNo),discountPercent)));    
        
        document.close();
    }
    
   
    
    
}