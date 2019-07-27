/**
 * 
 */
package ie.eamonnsweeney.app.models;


/**
 * @author Eamonn A. Sweeney
 *
 */
public class Menu {
	private String name;
	private String[] items;
	private String renderedMenu;
	
	/**
	 * 
	 */
	public Menu(String name, String[] items) {
		this.name = name;
		this.items = items;
	}
	
	/**
	 * 
	 */
	public String getRenderedMenu() {
		if (renderedMenu != null) {
			return renderedMenu;
		}
		
		renderMenu();
		return renderedMenu;
	}
	
	/**
	 * 
	 */
	private void renderMenu() {
		renderedMenu = "" + name;
		for (int i = 0 ; i < items.length ; i++) {
			renderedMenu += ("\n" + (i + 1) + ". " + items[i]); 
		}
	}
	
	/**
	 * @return 
	 * 
	 */
	@Override
	public String toString() {
		if (renderedMenu != null) {
			return renderedMenu;
		}
		
		renderMenu();
		return renderedMenu;
	}
	
}
