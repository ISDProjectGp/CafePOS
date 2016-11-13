package edu.cccu.isd.cafepossystem.userinterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.cccu.isd.cafepossystem.io.PictureLoader;
import edu.cccu.isd.cafepossystem.util.Singleton;

public class CoverPageFrame extends BaseFrame{
	 
	TableButton[] tableButton = new TableButton[PictureLoader.MAX_TABLE_AMOUNT] ;           //  The Table Buttons //
	
	CoverPageFrame ConverPageFrame ;                                                        // return CoverPageFrame //   
	JLabel picOfTableNotInUse = new JLabel(new ImageIcon(picLoader("tablenotinuse.png")));  // Picture of Table Not In Use // 
	JLabel picOfTableInUse = new JLabel (new ImageIcon(picLoader("tableinuse.png")));       // Picture of Table In Use // 

	// each time create CoverPageFrame object need to set up Frame name// 
	public CoverPageFrame(String frameName) {
		
		super(frameName);
		
		// return CoverPageFrame // 
		this.ConverPageFrame = this;
		
		// Init the UI of the CoverPageFrame // 
		initCoverPageFrame();
		
		// Basic Setting of the CoverPageFrame // 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(825,700);
		setVisible(true);		
		
	}
	
	// init coverpage ui // 
	/**
	 * Init the UI of the coverPageFrame   
	 */	
	public void initCoverPageFrame(){
			
		// init all Table Button pic to ram // 
		PictureLoader.createTableButton();
		
		// set Background image // 
	    setContentPane(new JLabel(new ImageIcon(picLoader("tasse-a-cafe-6_1.png"))));
	    
	    // set  Cafe image // 
		JLabel cafeI = new JLabel(new ImageIcon(picLoader("tasse-a-cafe-6_3.png")));
		cafeI.setBounds(100 ,400, 300, 270);
				
		JLabel rTime = new JLabel();
		rTime.setBounds(600,0,200,30);
		
		// setTable button Panel //
		JPanel table = new JPanel();
		table.setLayout(new FlowLayout(FlowLayout.LEFT));
		table.setBounds(0,30,650,380);

		// set  icons that indicate the number of the table which are using or not using   // 
		picOfTableNotInUse.setText(" "+PictureLoader.MAX_TABLE_AMOUNT);
		picOfTableNotInUse.setPreferredSize(new Dimension(180,71));
		picOfTableNotInUse.setBounds(440,500,180,71);
		
		picOfTableInUse.setText(" "+PictureLoader.MIN_TABLE_AMOUNT);
		picOfTableInUse.setPreferredSize(new Dimension(180,71));
		picOfTableInUse.setBounds(440,580,180,71);
		//        
		
		// set Time label // 
		JLabel top = new JLabel(new Date().toString().substring(0, 10));
		top.setFont(new Font ("Apple Chancery",Font.PLAIN,25));
		top.setBounds(0, 0, 200, 30);
     	
		// set Table Button // 
		for (int i = 0 ; i < 20 ; i++ ){
			tableButton[i] = new TableButton(PictureLoader.tableNotInUse[i],i, ConverPageFrame);									
			table.add(tableButton[i]);
		}
		
		
		add(top);
		add(cafeI);
		add(table);
		add(picOfTableNotInUse);
		add(picOfTableInUse);
	                 	
	}
	
	/**
	 * Refresh the UI Icons (That indicate the number of the table which are using or not using)   
	 */	
	public void updateUI(){
		
		picOfTableNotInUse.setText(""+(PictureLoader.MAX_TABLE_AMOUNT-Singleton.tableInUsingList.size()));
		picOfTableInUse.setText(""+Singleton.tableInUsingList.size());
					
	}
	
	/**
	 * Refresh the UI Icons (TableButton Not in use)   
	 */	
	public void updateUI(Integer tableNo){	
		
		tableButton[tableNo].setIcon(PictureLoader.tableNotInUse[tableNo]);
		
	}
	
	/**
	 * Refresh the UI Icons (TableButton in use)   
	 */	
	public void updateUIInUse(Integer tableNo){
			
		tableButton[tableNo].setIcon(PictureLoader.tableInUse[tableNo]);
		
	}			
}
