/**
 * 
 */
package ie.eamonnsweeney.app.views;

import ie.eamonnsweeney.app.models.Menu;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class ConsoleView {

	/**
	 * 
	 */
	public void display(Menu menu) {
		System.out.println(menu.getRenderedMenu());
	}
	
}
