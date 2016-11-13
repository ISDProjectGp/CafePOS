package edu.cccu.isd.cafepossystem.userinterface;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BaseFrame extends JFrame {


	public BaseFrame(String frameName){
		
		super(frameName);		
						
	}
	
	/**
	 * @param picName the resource which be loaded to memory
	 * @return the image 
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
