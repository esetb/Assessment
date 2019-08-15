/**
 * 
 */
package ie.eamonnsweeney.app.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * The Class FileIOController.
 *
 * @author Eamonn A. Sweeney
 */
public class FileIOController {

	/**
	 * Read text from a file to a string.
	 *
	 * @param filePath the file path
	 * @return the string
	 */
	public String readTextFile(File filePath) {
		String text = "";
		String line = null;
		
		if (filePath.length() == 0) {
			return text;
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
			line = null;
		    while ((line = reader.readLine()) != null) {
		    	text += (line + "\n");
		    }
		} catch (IOException e) {
        	e.printStackTrace();
			System.exit(0);
		}
		
		return text;
	}
	
	/**
	 * Read generic array list.
	 *
	 * @param filePath the file path
	 * @return the array list
	 */
	public ArrayList<?> readGenericArrayList(File filePath) {
		ArrayList<?> array = new ArrayList<>();
		
		try (FileInputStream fis = new FileInputStream(filePath); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			array = (ArrayList<?>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return array;
	}

	/**
	 * Write generic array list.
	 *
	 * @param array the array
	 * @param filePath the file path
	 */
	public void writeGenericArrayList(ArrayList<?> array, File filePath) {
		try (FileOutputStream fos = new FileOutputStream(filePath);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(array);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
