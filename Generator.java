
/**
* The Generator class generates coils of rope and customer orders 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
	// This variable represents the longest possible length of rope that a
	// customer can order
	private final int MAX_ORDER_LENGTH = 100;

	// These variables represent the longest and smallest possible coils of rope
	// that the manufacturers can supply
	private final int MIN_ROPE_LENGTH = 100;
	private final int MAX_ROPE_LENGTH = 200;

	

	/**
	 * This method will generate a list of orders of random lengths between the
	 * min and max order sizes (currently 1 and 100m)
	 * 
	 * @param numberOfOrders:
	 *            the number of customer orders to generate
	 * @return a list of customer orders
	 */
	public List<Integer> generateMultipleOrders(int numberOfOrders) {
		Random r = new Random();
		List<Integer> orderList = new ArrayList<Integer>();

		int sum = 0;
	

		for (int i = 0; i < numberOfOrders; i++) {
			int next = r.nextInt(101) + 1;
			orderList.add(next);
			sum += next;
		}

		
		System.out.println("Sum of orders " + (sum - 1) + "\n");
		return orderList;
	}

	/**
	 * This method will generate a list of new coils of rope from the
	 * manufacturer of random lengths between the min and max order sizes
	 * (currently 100 and 200m)
	 * 
	 * @param numberOfCoils:
	 *            the number of ropes to generate
	 * @return a list of coils of rope supplied by the manufacturer
	 * 
	 */

	public List<Rope> orderRopeFromManufacturer(int numberOfCoils) {

		List<Rope> coils = new ArrayList<Rope>();
		// You need to use the Rope class provided to represent a coil of rope
		Random r = new Random();
		int sum = 0;
		// maybe create a getter and setter for sum may be useful
		System.out.println("Size of coils");
		for (int i = 0; i < numberOfCoils; i++) {
			int next = r.nextInt(100) + 100;
			Rope temp = new Rope(1);
			temp.setLength(next);
			coils.add(temp);
			sum += next;
			
			// System.out.print(temp.getLength() + ", ");

		}
		System.out.println(sum);
		return coils;
	}

	public Generator() {
		
		// TODO Auto-generated constructor stub
	}

}
