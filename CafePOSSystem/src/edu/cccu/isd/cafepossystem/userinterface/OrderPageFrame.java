package edu.cccu.isd.cafepossystem.userinterface;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.itextpdf.text.DocumentException;

import edu.cccu.isd.cafepossystem.util.AdvanceSearchFunction;
import edu.cccu.isd.cafepossystem.util.Singleton;

public class OrderPageFrame extends BaseFrame {
	
	static Integer tableNum;
	TablePageFrame tablePageFrame;
	UserTableModel  UserTableModel ;
    Integer Head;
    OrderPageFrame orderPageFrame;
    
	final JPanel listOfDrink = new JPanel();		
	final JPanel listOfCake = new JPanel();
	final JPanel listOfMainDish = new JPanel();
	  JPanel temp =  new JPanel();

    // Each time create table page frame need to set up the frame name as well as return the CoverPageFrame , tableNo from mother frame // 
	public OrderPageFrame(String frameName,Integer tableNo,TablePageFrame tablePageFrame) {
		super(frameName);
		
		
		this.tableNum = tableNo;
		this.tablePageFrame = tablePageFrame;
		this.Head =Singleton.tableInUsingList.getTable(tableNum).getFoodList().size();
		this.orderPageFrame=this;
		setSize( 825 , 700 );	
		setLayout(null);
		
		initOrderPageFrame();
	
	}
	
	public void initOrderPageFrame(){
	
			
		JLabel top = new JLabel("Food / Drink  List");
		top.setFont(new Font("Apple Chancery",Font.PLAIN,50));
		top.setBounds(0,0,700,100);
		
		JButton topright = new JButton("Back");
		topright.setBounds(700,0,100,100);
			
		final JTextField ed = new JTextField(10);
		ed.setBounds(405,70,200,30);
		
		
		ed.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
				  
				  orderPageFrame.remove(temp);
				 if (!ed.getText().equals("")){
				  temp =  setTure(ed.getText());
				  orderPageFrame.add(temp);
				  listOfDrink.setVisible(false);
				  listOfCake.setVisible(false);
				  listOfMainDish.setVisible(false);		
				  temp.setBounds(400,250,425,400);				  				 
				  temp.setVisible(true);
				  revalidate();
				 } else {
					 listOfDrink.setVisible(true);	 
				 }
			       
			  }
			});
		
		
		UserTableModel = new UserTableModel();
		final JTable orderList = new JTable(UserTableModel);
		
		//orderList.addMouseListener(new java.awt.event.MouseAdapter() {
		//    @Override
		//    public void mouseClicked(java.awt.event.MouseEvent evt) {
		 //       final int row = orderList.rowAtPoint(evt.getPoint());
		 //       int col = orderList.columnAtPoint(evt.getPoint());
		 //       if (row >=0 ) {
		  //      	 SwingUtilities.invokeLater(new Runnable(){
		 //		        @Override public void run() {
		 //		        	 UserTableModel.removeRow(row);
		//		        	  invalidate();
		//		        	  Singleton.tableInUsingList.getTable(tableNum).RemoveFood(UserTableModel.userData.get(row).get(0), amount);
		//		        	  System.out.println(row);		        	
		 //		        }
		// 		      });
		//        	 
		//        }
		//    }
		//});
		
		JScrollPane scrollPane = new JScrollPane(orderList);
		scrollPane.setBounds(0,100,400,600);
		add(scrollPane);
		
	
		
		
		JButton drinkList[] = new JButton[6];
		JButton cakeList[] = new JButton[5];
		JButton mainDishList[] = new JButton[5];
		setList(drinkList,cakeList,mainDishList);
		for (int i = 0 ; i < drinkList.length ; i++){listOfDrink.add(drinkList[i]);}
		listOfDrink.setBounds(400,250,425,400);

		for (int i = 0 ; i < cakeList.length ; i++){listOfCake.add(cakeList[i]);}
		listOfCake.setBounds(400,250,425,400);
		
		for (int i = 0 ; i < mainDishList.length ; i++){listOfMainDish.add(mainDishList[i]);}
		listOfMainDish.setBounds(400,250,425,400);
		
		listOfDrink.setVisible(true);
		listOfCake.setVisible(false);
		listOfMainDish.setVisible(false);
		
		
		JPanel righttopP = new JPanel();
		JButton drink = new JButton("Drink");
		drink.setPreferredSize(new Dimension(127,100));
		
		drink.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				listOfDrink.setVisible(true);
				listOfCake.setVisible(false);
				listOfMainDish.setVisible(false);
			
			}
		});
		
		JButton cake = new JButton("Cake");
		cake.setPreferredSize(new Dimension(127,100));
		cake.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				listOfDrink.setVisible(false);
				listOfCake.setVisible(true);
				listOfMainDish.setVisible(false);
				
			}
		});
		
		JButton mainDish = new JButton("Main Dish");
		mainDish.setPreferredSize(new Dimension(127,100));
		mainDish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				listOfDrink.setVisible(false);
				listOfCake.setVisible(false);
				listOfMainDish.setVisible(true);
			
			}
		});
		
		righttopP.add(drink);
		righttopP.add(cake);
		righttopP.add(mainDish);
		righttopP.setBounds(400,100,400,100);
		
		
		add(listOfDrink);
		add(listOfCake);
		add(listOfMainDish);
		add(listOfMainDish);
		add(topright);
		add(top);
		add(ed);
		add(righttopP);
		setVisible(true);
		
		topright.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e)
		    {     setVisible(false);
		           System.out.println(tablePageFrame);
		           tablePageFrame.returnValueFromNewTable(Head, Singleton.tableInUsingList.getTable(tableNum).getFoodList().size(), tableNum);
		           try {
					Singleton.printpdf.printFoodList(Head, Singleton.tableInUsingList.getTable(tableNum).getFoodList().size(), tableNum);
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    
		    }
		});
	
	}	
	
	public  JPanel setTure(String edText){
		
	    JPanel tempDish = new JPanel();
		AdvanceSearchFunction.searchRelatedItems(edText);
		final Integer AMOUNT = AdvanceSearchFunction.searchRelatedItems(edText).size(); 
		final OrderButton[] tem = new OrderButton[AMOUNT];
		for (int i = 0 ; i < AMOUNT; i++) 
		{	
			int t = AdvanceSearchFunction.searchRelatedItems(edText).get(i);
			if (Singleton.itemList.getFoodName(AdvanceSearchFunction.searchRelatedItems(edText).get(i)).indexOf(" ")>3){
			  System.out.println(t);
			  String foodName = "<html><center>"+Singleton.itemList.getFoodName(t).substring(0, Singleton.itemList.getFoodName(t).indexOf(" "))+"<br>"+Singleton.itemList.getFoodName(t).substring(Singleton.itemList.getFoodName(t).indexOf(" "), Singleton.itemList.getFoodName(t).length())+"</center></html>";
			  tem[i] = new OrderButton(
						foodName,AdvanceSearchFunction.searchRelatedItems(edText).get(i));
			  
			} else {
				tem[i] = new OrderButton(
						Singleton.itemList.getFoodName(t),AdvanceSearchFunction.searchRelatedItems(edText).get(i));
				
			}
		} 
		
		for (int i = 0 ; i < AMOUNT ; i++){
			tem[i].setPreferredSize(new Dimension(133,133));
			tem[i].setBackground(Color.CYAN);
			tem[i].setOpaque(true);
			final int[] j = new int[1];
			j[0] = i;
			tem[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{						
						String input = JOptionPane.showInputDialog("Input the Amount:");
						int inputValue = Integer.parseInt(input);
						
						System.out.println(Singleton.itemList.getFoodName(tem[j[0]].gettemint()));
						while (inputValue <= 0 ){
							input = JOptionPane.showInputDialog("Invalid!Input the Amount again:");
							inputValue = Integer.parseInt(input);
							
							
						}
						Singleton.tableInUsingList.getTable(tableNum).addFood(tem[j[0]].gettemint(), inputValue);
						returnValueFromNewTable(tem[j[0]].gettemint(),inputValue);
						} catch (NumberFormatException input){
							JOptionPane.showMessageDialog(null, "Invalid Input");
						}
				}
			});
		}
		
		for (int i = 0 ; i < AMOUNT ; i++){
			
			tempDish.add(tem[i]);
		
		}
				
				
	return tempDish;
		
		
	}
	
	public void setList(JButton drink[],JButton cake[],JButton mainD[]){
		final Integer AMOUNT_OF_DRINK = 6; 
		for (int i = 0 ; i < AMOUNT_OF_DRINK ; i++) 
		{	
			if (Singleton.itemList.getFoodName(i).indexOf(" ")>3){
			  String foodName = "<html><center>"+Singleton.itemList.getFoodName(i).substring(0, Singleton.itemList.getFoodName(i).indexOf(" "))+"<br>"+Singleton.itemList.getFoodName(i).substring(Singleton.itemList.getFoodName(i).indexOf(" "), Singleton.itemList.getFoodName(i).length())+"</center></html>";
			  drink[i] = new JButton(
						foodName);
			  
			} else {
				drink[i] = new JButton (
						Singleton.itemList.getFoodName(i));
				
			}
		}
		
		final Integer AMOUNT_OF_CAKE = 5; 
		for (int i = AMOUNT_OF_DRINK ; i < AMOUNT_OF_CAKE+AMOUNT_OF_DRINK ; i++) 
		{	
			if (Singleton.itemList.getFoodName(i).indexOf(" ")>3){
			  String foodName = "<html><center>"+Singleton.itemList.getFoodName(i).substring(0, Singleton.itemList.getFoodName(i).indexOf(" "))+"<br>"+Singleton.itemList.getFoodName(i).substring(Singleton.itemList.getFoodName(i).indexOf(" "), Singleton.itemList.getFoodName(i).length())+"</center></html>";
				cake[i-AMOUNT_OF_DRINK] = new JButton (
						foodName);
			} else {
				cake[i-AMOUNT_OF_DRINK] = new JButton (
						Singleton.itemList.getFoodName(i));
				
			}
		}
		for (int i = AMOUNT_OF_CAKE+AMOUNT_OF_DRINK ; i < Singleton.itemList.size() ; i++) 
		{	
			if (Singleton.itemList.getFoodName(i).indexOf(" ")>3){
			  String foodName = "<html><center>"+Singleton.itemList.getFoodName(i).substring(0, Singleton.itemList.getFoodName(i).indexOf(" "))+"<br>"+Singleton.itemList.getFoodName(i).substring(Singleton.itemList.getFoodName(i).indexOf(" "), Singleton.itemList.getFoodName(i).length())+"</center></html>";
			  mainD[i-AMOUNT_OF_CAKE-AMOUNT_OF_DRINK] = new JButton (
						foodName);
			} else {
				mainD[i-AMOUNT_OF_CAKE-AMOUNT_OF_DRINK] = new JButton (
						Singleton.itemList.getFoodName(i));
				
			}
		}
		
		for (int i = 0 ; i < drink.length ; i++ ){
			drink[i].setPreferredSize(new Dimension(133,133));
			drink[i].setBackground(Color.green);
			drink[i].setOpaque(true);
			final int[] j = new int[1];
			j[0] = i;
			drink[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						String input = JOptionPane.showInputDialog("Input the Amount:");
						int inputValue = Integer.parseInt(input);
						
						System.out.println(Singleton.itemList.getFoodName(j[0]));
						while (inputValue <= 0 ){
							input = JOptionPane.showInputDialog("Invalid!Input the Amount again:");
							inputValue = Integer.parseInt(input);
							
						
						}
						Singleton.tableInUsingList.getTable(tableNum).addFood(j[0], inputValue);
						returnValueFromNewTable(j[0],inputValue);
					} catch (NumberFormatException input){
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}
				}
			});
		
		}
		for (int i = 0 ; i < cake.length ; i++){
			cake[i].setPreferredSize(new Dimension(133,133));
			cake[i].setBackground(Color.pink);
			cake[i].setOpaque(true);
			final int[] j = new int[1];
			j[0] = i;
			cake[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						String input = JOptionPane.showInputDialog("Input the Amount:");
						int inputValue = Integer.parseInt(input);
						
						System.out.println(Singleton.itemList.getFoodName(j[0]+AMOUNT_OF_DRINK));
						while (inputValue <= 0 ){
							input = JOptionPane.showInputDialog("Invalid!Input the Amount again:");
							inputValue = Integer.parseInt(input);
						
							
						}
						Singleton.tableInUsingList.getTable(tableNum).addFood(j[0]+AMOUNT_OF_DRINK, inputValue);
						returnValueFromNewTable(j[0]+AMOUNT_OF_DRINK,inputValue);
						} catch (NumberFormatException input){
							JOptionPane.showMessageDialog(null, "Invalid Input");
						}
				}
			});
		}
		
		for (int i = 0 ; i < mainD.length ; i++){
			mainD[i].setPreferredSize(new Dimension(133,133));
			mainD[i].setBackground(Color.orange);
			mainD[i].setOpaque(true);
			final int[] j = new int[1];
			j[0] = i;
			mainD[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						String input = JOptionPane.showInputDialog("Input the Amount:");
						int inputValue = Integer.parseInt(input);
						System.out.println(Singleton.itemList.getFoodName(j[0]+AMOUNT_OF_DRINK+AMOUNT_OF_DRINK));
						while (inputValue <= 0 ){
							input = JOptionPane.showInputDialog("Invalid!Input the Amount again:");
							inputValue = Integer.parseInt(input);
							
							
						}
						Singleton.tableInUsingList.getTable(tableNum).addFood(j[0]+AMOUNT_OF_DRINK+AMOUNT_OF_DRINK, inputValue);
						returnValueFromNewTable(j[0]+AMOUNT_OF_DRINK+AMOUNT_OF_DRINK,inputValue);
						} catch (NumberFormatException input){
							JOptionPane.showMessageDialog(null, "Invalid Input");
						}
					    
				}
			});
		}
		
	}
	
	 public void returnValueFromNewTable(final int foodType,final int amount){
		 SwingUtilities.invokeLater(new Runnable(){
		        @Override public void run() {
		        	  UserTableModel.addRow(Arrays.asList(Singleton.itemList.getFoodName(foodType),Singleton.itemList.getCost(foodType),amount));
		   		   
		        	  invalidate();		        	
		        }
		      });
		 
		
	}

}
