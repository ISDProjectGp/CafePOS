package edu.cccu.isd.cafepossystem.io;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private String filePath = null ;
	private String fileChooserStr = null;

	public FileChooser(boolean Isdirectory){
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	
		if (Isdirectory){			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooserStr = "Set the PDF path"; 
			
		} else {
			fileChooserStr = "Import the menu"; 
			
		}
						
		int result = fileChooser.showDialog(FileChooser.this , fileChooserStr);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    this.filePath = selectedFile.getAbsolutePath();
		}
		
	}
	
	/**
	 * Get the filePath
	 * @return the filePath
	 */
	public String getFilePath(){
		
		return this.filePath ;
				
	}
	
}