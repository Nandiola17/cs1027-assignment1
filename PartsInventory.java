
import java.io.*;

/**
 * Creates an inventory object that keeps track of parts objects.
 * Has getter methods but no setter methods as variables should not be changed after being initialised in one of the two contructors
 * @author Nandi
 */
public class PartsInventory {

	private Part[] partList;
	private int numberOfParts;
	private final int DEFAULT_SIZE = 3;

/**
 * Constructor class with just one paramater. 
 * Initialises variables and creates a partsinventory object
 * Uses DEFAULT_SIZE value instead of a custom value
 * 
 * @param filename Takes the local path of the filename as parameter, used to open filereader object
 * @throws NumberFormatException Used for conversion
 * @throws IOException When trying to read files
 */
	public PartsInventory(String filename) throws NumberFormatException, IOException {

		// initialize variables
		partList = new Part[DEFAULT_SIZE];
		numberOfParts = 0;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
 		
		//start parsing through parts.txt
		String temp = "";
		String[] tempArray = null;
		
		//check if string is null 
		while ((temp = br.readLine()) != null) {
			tempArray = temp.split("\\s+");
			
			//assign values for clarity
			String name = tempArray[0];
			double price = Double.parseDouble(tempArray[1]);
			int quantity = Integer.parseInt(tempArray[2]);

			//call add part
			addPart( name, price, quantity);
		}

		// end of for loop
		br.close();
	}

	/**
	 * Constructor class with two paramaters. 
	 * Initialises variables and creates a partsinventory object
	 * Uses custom value for the length of the array
	 * 
	 * @param filename Takes the local path of the filename as parameter, used to open filereader object
	 * @param num Takes the inital number of values of parts be read. Howeever if the number of parts in parts.exe is more than the parts in array, the list will use expandcapacity() to accomodate the extra parts
	 * @throws NumberFormatException Used for conversion
	 * @throws IOException When trying to read files
	 */
	public PartsInventory(String filename, int num) throws NumberFormatException, IOException {

		// "However, make this smaller than the number of unique Part (5) in
		// Part.txt so the TA can see that your helper method"
		if (num > 5) {
			num = 2;
		}

		// intialise variables
		partList = new Part[num];
		numberOfParts = 0;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		String temp = "";
		String[] tempArray = null;

		//while loop+ check for null value
		while ((temp = br.readLine()) != null) {
			tempArray = temp.split("\\s+");

			//assign values
			String name = tempArray[0];
			double price = Double.parseDouble(tempArray[1]);
			int quantity = Integer.parseInt(tempArray[2]);

			//call add part
			addPart( name, price, quantity);
		}

		// end of for loop
		br.close();
	}

	/**
	 * Getter method: returns number of parts
	 * @return numberOfParts
	 */
	public int getNumberOfParts() {
		return numberOfParts;
	}

	/**
	 * creates part with parameter + adds it to the list
	 * only place where list is expanded
	 * increments the numberofparts counter
	 * 
	 * @param name name of the part to be added
	 * @param price price of the part being added
	 * @param quantity quantity of the part being added
	 */
	private void addPart(String name, double price, int quantity) {
		Part temp = new Part(name, price, quantity); //new part
		if (numberOfParts == partList.length) {
			expandCapacity(); //if u hit capacity, increase capacity
		}
		// execute this regardless
		partList[numberOfParts] = temp;
		// increase counter
		numberOfParts++;
	}

	
	/**
	 * expands list capacity by one
	 * only method where array length is being changed
	 */
	private void expandCapacity() {
		Part[] src = partList;
		Part[] dest = new Part[partList.length + 1];

		// copy same elements
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}
		// initialise last element as null
		dest[partList.length] = null;

		// set the new array as the global variable
		partList = dest;
	}

	/**
	 *  searches for the part and returns the index
	 *  left public for use by other classes
	 * @param partName Search criteria. Unique partname that will be searched for in the inventory
	 * @return index returns the index value at which a match was found
	 */
	public int searchPart(String partName) {
		// search using for loop
		for (int i = 0; i < partList.length; i++) {
			if (partList[i].getPartName().equals(partName)) {
				return i;
			}
		}
		return -1; // returns -1 by default
	}

	/**
	 *  gets the part object for the given index
	 * @param index index from which the part needs to be extracted
	 * @return Part returns a Part object from the partlist
	 */
	public Part getPartObject(int index) {
		return partList[index];
	}

	/**
	 *  converts object to string information
	 */
	public String toString() {
		String value = "INVENTORY:\n";

		for (int i = 0; i < partList.length; i++) {
			value = value + partList[i].toString();
		}

		return value;
	}

	/**
	 *  removes part and then decreases the size of the array
	 * @param target index to delete part from
	 */
	public void removePart(Part target) {
		int targetIndex = 0;
		// look for target
		for (int i = 0; i < partList.length; i++) {
			if (target.equals(partList[i])) {
				// find the target index
				targetIndex = i;
			}
		}
		// create temp lists
		Part[] dest = new Part[numberOfParts - 1];
		Part[] src = partList;
		// delete and swap
		src[targetIndex] = null;
		src[targetIndex] = src[numberOfParts - 1];

		//copy arrays
		for (int i = 0; i < (numberOfParts - 1); i++) {
			dest[i] = src[i];
		}
		// save as global list
		partList = dest;
		//decrement counter	
		numberOfParts--;
	}

}
