package edu.cccu.isd.cafepossystem.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.itextpdf.text.DocumentException;

import edu.cccu.isd.cafepossystem.util.Caculation;
import edu.cccu.isd.cafepossystem.util.Singleton;

public class TablePageFrame extends BaseFrame{
	
	Integer tableNo;
	CoverPageFrame converPageFrame;
	TablePageFrame tablePageFrame;
	UserTableModel  UserTableModel;
	Integer discountPercent = 100 ;

	public TablePageFrame(String frameName,Integer tableNo,CoverPageFrame converPageFrame) {
		super(frameName);
		
		// return CoverPageFrame , tableNo// 
		this.converPageFrame = converPageFrame;
		this.tablePageFrame = this;
		this.tableNo = tableNo;
		
		// Init the UI of the coverPageFrame // 
		initTablePageFrame();
		// Basic Setting of the CoverPageFrame // 
		setSize(840,700);
		setVisible(true);
		
	}
	// init the table Page UI 
	/**
	* Init the UI of the coverPageFrame   
	*/	
	public void initTablePageFrame(){
				
		UserTableModel = new UserTableModel();
		JTable orderList = new JTable(UserTableModel);
		initFoodList(tableNo);
			
		JScrollPane scrollPane = new JScrollPane(orderList);
		scrollPane.setBounds(0,300,825,200);
		add(scrollPane);
		
		// set Number of people and table number JLabels // 
		JPanel toppart = new JPanel();
		toppart.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label1 = new JLabel("Table " + (tableNo+1) + "   Customers : " + Singleton.tableInUsingList.getTable(tableNo).getNumberOfPeople() );
		label1.setFont(new Font("Apple Chancery", Font.PLAIN,40));
		toppart.add(label1);

		JPanel northp = new JPanel();
		northp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//  set below Function Button // 
		JButton []btn = new JButton[4] ;
		btn[0] = new JButton("Order");
		btn[1] = new JButton("Bill");
		btn[2] = new JButton("Discount");
		btn[3] = new JButton("Exit");
		
		
		
		
		for (int i = 0 ; i < btn.length ; i++){
		btn[i].setPreferredSize(new Dimension(200,180));
		btn[i].setFont(new Font ("Apple Chancery",Font.PLAIN,36));
		northp.add(btn[i]);
		}
		//// 
		
		add(toppart,BorderLayout.NORTH);
		add(northp, BorderLayout.SOUTH);
		
		// set button action listener , Go to order page // 
		btn[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{ 
				OrderPageFrame orderPageFrame = new OrderPageFrame("OrderFrame",tableNo,tablePageFrame);   
				}
		});
		
		// set button action listener , Caculate the total and release the table  // 
		btn[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				
				System.out.println(Singleton.tableInUsingList.getTable(tableNo));
				// !---- still not functionable  // 
				String strToShow = "SubTotal : $"+Caculation.getSubTotal(Singleton.tableInUsingList.getTable(tableNo)) + "\n Charge After discount : $" +
						Caculation.setDiscountPolicy(Singleton.tableInUsingList.getTable(tableNo),discountPercent)  + "\n Total (Including service charges) : $" +
						Caculation.getTotal(Singleton.tableInUsingList.getTable(tableNo),discountPercent)+ "\n ServiceCharge : $" +
						Caculation.getServiceCharge(Singleton.tableInUsingList.getTable(tableNo),discountPercent)+ "\n Average Spending : $"+
						Caculation.getAverageSpending(Singleton.tableInUsingList.getTable(tableNo),discountPercent);
				try {
					Singleton.printpdf.printInvoice(tableNo,discountPercent);
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, strToShow);
				
				Singleton.tableInUsingList.releaseTable(tableNo);
				converPageFrame.updateUI(tableNo);
				converPageFrame.updateUI();
				
				// !---- still not functionable  // 
				
				setVisible(false);
			}
		});
		
		// set button action listener , Set up the discount policy // 
		btn[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String strToShow = "Please input discount again(%):"+ "\n"+ " Now Discount " +  discountPercent  +" % " ;
				String strToShow2 = "Invalid!Please input discount again(%): "+ "\n"+ " Now Discount (%)" +  discountPercent   ;
				try{
				   
				   String inputDiscount = JOptionPane.showInputDialog(strToShow);
				   int inputValue = Integer.parseInt(inputDiscount) ;
				   int dicount = inputValue ;
				while (inputValue<=0){
					inputDiscount = JOptionPane.showInputDialog(strToShow2);
					inputValue = Integer.parseInt(inputDiscount) ;
					dicount = inputValue ;
				}
				discountPercent = dicount;
				}catch(NumberFormatException dicount){
					JOptionPane.showMessageDialog(null, "Invalid Input!");
					}
				
			}
		});
		
		// set button action listener ,Exit // 	
		btn[3].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {      setVisible(false);    }
		});
		
		
			
	
	
	}
	
	public void initFoodList(Integer tableNum){
		
		
       for (int i=0;i<Singleton.tableInUsingList.getTable(tableNum).getFoodList().size();i++){
    	Integer foodType = Singleton.tableInUsingList.getTable(tableNum).getFood(i).getFoodType();
		UserTableModel.addRow(Arrays.asList(Singleton.itemList.getFoodName(foodType),Singleton.itemList.getCost(foodType),Singleton.tableInUsingList.getTable(tableNum).getFood(i).getFoodQuantity()));
       }
		
		
	}
	
	 public void returnValueFromNewTable(final Integer head ,final Integer tails ,final Integer tableNo){
		 SwingUtilities.invokeLater(new Runnable(){
		        @Override public void run() {
		        	 for (int i=head;i<tails;i++){
		        		 Integer foodType = Singleton.tableInUsingList.getTable(tableNo).getFood(i).getFoodType();
		        		  UserTableModel.addRow(Arrays.asList(Singleton.itemList.getFoodName(foodType),Singleton.itemList.getCost(foodType),Singleton.tableInUsingList.getTable(tableNo).getFood(i).getFoodQuantity()));
		        	 }
		        	  invalidate();		        	
		        }
		      });
	 }
	

}
