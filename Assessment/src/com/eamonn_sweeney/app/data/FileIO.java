/**
 * File Input/Output
 */
package com.eamonn_sweeney.app.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/* readArrayList(File filepath)
 * writeArrayList(ArrayList array, File filepath)
 * readFileAsString(File filePath)
 */

/**
 * @author Eamonn A. Sweeney
 *
 */
public class FileIO {
	
	private File dataDir;

	/**
	 * 
	 */
	public FileIO() {
		this.dataDir = new File(System.getProperty("user.dir").concat(
				"/src/com/eamonn_sweeney/app/data/files"));
	}
	
	/**
	 * @param dataDir
	 */
	public FileIO(File dataDir) {
		this.dataDir = dataDir;
	}
	
	/**
	 * @return the dataDir
	 */
	public File getDataDir() {
		return dataDir;
	}
	
	/**
	 * 
	 */
	public ArrayList<?> readArrayListFromFile(File fileName) {
		File filePath = new File(getDataDir() + "/" + fileName);
		ArrayList<?> array = new ArrayList<>();
		try { 
			FileInputStream fin= new FileInputStream (filePath);
			ObjectInputStream ois = new ObjectInputStream(fin);
			array = (ArrayList<?>) ois.readObject();
			fin.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	/**
	 * 
	 */
	public void writeArrayListToFile(ArrayList<?> array, File fileName) {
		File filePath = new File(getDataDir() + "/" + fileName);
		try { 
			FileOutputStream fout= new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(array);
			fout.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
}
