/**
 * PART OBJECT
 * Object file created from the data presented in parts.exe
 * 
 * Date created - 23rd january
 * @author Anirudha Nandi
 */
public class Part {

	// instance variables
	private String partName;
	private double partPrice;
	private int partQuantity;

	/**
	 * Only constructor for the part class. Creates object and initiates instance variables.
	 * Only one part object exists for a given Part name. All parts of the same name have the same price. The part object also stores the part quantity.
	 *
	 * @param name Unique name of the part. Each part in parts.exe has a unique name
	 * @param price Decimal value for the price of one part
	 * @param quantity Current quantity of a given part. 
	 */
	public Part(String name, double price, int quantity) {
		//assign values
		setPartName(name);
		setPartPrice(price);
		setPartQuantity(quantity);
	}
	
	/**
	 * Compares an external part's unique name and sees if it matches with this.name. Hence checking if the parts are the same
	 *
	 * @param other Compares this object with another part. Takes the other part as the parameter.
	 * @return boolean Returns the values or 'true' or false' depending on whether the two parts are the same or nah.
	 */
	public boolean equals(Part otherPart) {
		if (otherPart.partName == this.partName)
			return true;
		else
			return false;
	}

	/**
	 * Converts important object information into a string. Method used to print information in a user friendly way.
	 *
	 * @return value Returns the value to be printed.
	 */
	public String toString() {
		String value;
		value = "PART NAME:  " + this.partName + "  PART PRICE:  " + this.partPrice + "  PART QUANTITY:   "
				+ this.partQuantity + "\n";
		return value;
	}

	/**
	 * Sets the part name to the given value
	 * 
	 * @param newValue new name value
	 */
	public void setPartName(String newValue) {
		this.partName = newValue;
	}

	/**
	 * Sets the part price to the given value
	 * 
	 * @param newValue new price value, taken as a double
	 */
	public void setPartPrice(double newValue) {
		this.partPrice = newValue;
	}

	/**
	 * Sets the part quantity to the given value
	 * 
	 * @param newValue new quantity value
	 */
	public void setPartQuantity(int newValue) {
		this.partQuantity = newValue;
	}

	/**
	 * Returns the part name
	 */
	public String getPartName() {
		return this.partName;
	}

	/**
	 * Returns the part price
	 */
	public double getPartPrice() {
		return this.partPrice;
	}

	/**
	 * Returns the part quantity
	 */
	public int getPartQuantity() {
		return this.partQuantity;
	}
}
