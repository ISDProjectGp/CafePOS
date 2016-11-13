package edu.cccu.isd.cafepossystem.io;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//!----Static class , not require to new instance // 

public class PictureLoader {
	
	static final String TABLE_IN_USING_PIC_NAME = "tablenotinuse";
	static final String FILE_FORMAT = ".png";
	static final String TABLE_IN_USE_PIC_NAME = "tableinuse";
	public static final Integer MAX_TABLE_AMOUNT =20;
	public static final Integer MIN_TABLE_AMOUNT =0;

	
	public static ImageIcon[] tableInUse= new ImageIcon[MAX_TABLE_AMOUNT];
	public static ImageIcon[] tableNotInUse = new ImageIcon[MAX_TABLE_AMOUNT];

	/**
	 * To load the all the button local resource 
	 */
	public static void createTableButton(){
			
			final String TABLE_NOT_IN_USE_PIC_NAME = "tablenotinuse";
			final String FILE_FORMAT = ".png";
			final String TABLE_IN_USE_PIC_NAME = "tableinuse";
			final Integer MAX_TABLE_AMOUNT =20;
			
			for  (int i = 0 ; i < MAX_TABLE_AMOUNT ; i++){
				tableInUse[i] = new ImageIcon(picLoader(TABLE_IN_USE_PIC_NAME+(i+1)+FILE_FORMAT));
				tableNotInUse[i] = new ImageIcon(picLoader(TABLE_NOT_IN_USE_PIC_NAME+(i+1)+FILE_FORMAT));
			}
	  }
			
	/**
	 * To load the a specific local resource
	 * @param picName  the resource name 
	 */
	public static Image picLoader(String picName){
				
				InputStream input = ClassLoader.getSystemResourceAsStream(picName);
				try {
					Image image = ImageIO.read(input);
					return 	image ;
				} catch (IOException e) {
					//  Return a error dialog , Cannot load the image // 
				}
				
				return 	null ;
				
				
			}

}
