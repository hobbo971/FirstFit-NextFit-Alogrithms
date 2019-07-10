
import java.util.*;

public class Algorithms {

	public Algorithms() {

	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param orders:
	 *            a list of integers representing customer orders
	 * @param coils
	 *            : a list of ropes representing available coils of ropes from
	 *            the manufacturer
	 * @return the number of coils used to fulfil all customer orders
	 */
	public int nextFit(List<Integer> orders, List<Rope> coils) {
		// System.out.println(coilsToString(coils));
		// System.out.println("Orders = " +ordersToString(orders));
		int pointer = 0;//a pointer to the current coil
		int coilsUsed = 1;
		Rope r = new Rope(1); // Initialise a rope
		// set r length to index i of coils
		r = coils.get(pointer);
		for (int i = 0; i < orders.size(); i++) {

			// if rope i of coil is greater then order i
			if (r.getLength() - orders.get(i).intValue() > 0) {

				r.cut(orders.get(i));
				if (r.getLength() <= 5) {
					coils.remove(pointer);// if r equals pointer when removed, then r needs
					pointer--; // to change

				}

			} else {

				// if rope cant be cut move onto next rope
				pointer++;
				// set r to the new length
				r = coils.get(pointer);
				// log change of rope
				coilsUsed++;
				// if rope wasnt cut still need to complete order so keep index
				// the same
				i--;
			}

		}
		System.out.println("\n number of used coils :");
		return coilsUsed;
	}

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param orders:
	 *            a list of integers representing customer orders
	 * @param coils
	 *            : a list of ropes representing available coils of ropes from
	 *            the manufacturer
	 * @return the number of coils used to fulfil all customer orders
	 */
	public int firstFit(List<Integer> orders, List<Rope> coils) {

		// System.out.println(coilsToString(coils));
		// System.out.println("Orders = " + ordersToString(orders));
		int pointer = 0; // pointer to the current coil
		int coilsUsed = 1;
		Rope r = new Rope(1); // Initialise a rope
		// set r length to index i of coils
		r = coils.get(pointer);
		for (int i = 0; i < orders.size(); i++) {

			// if rope i of coil is greater then order i
			// check current coils for fit
			if (r.getLength() - orders.get(i).intValue() > 0) {

				r.cut(orders.get(i));
				if (r.getLength() <= 5) {

					// coils.get(pointer).getLength());
					coils.remove(pointer);// if r equals pointer when removed, then r needs
									// to change

				}

			} else {
				// check all previous coils for fit
				for (int n = 0; n < coils.subList(0, pointer).size(); n++) {

					r = coils.get(n);// set r to start of previous coils

					if (r.getLength() - orders.get(i).intValue() >= 0) {

						r.cut(orders.get(i));
						i++; // increment onto next order
						pointer--; // stop the coil increasing as new one was not
								// needed
						coilsUsed--;// stop the coilUsed increasing further down as new one
									// was not needed
						if (r.getLength() <= 5) {

							coils.remove(n);
							pointer--; // shift pointer as element of list been removed
						}
						break;
					}
				}
				// if rope cant be cut move onto next rope
				pointer++;
				// set r to the new length
				r = coils.get(pointer);
				// log change of rope

				coilsUsed++;
				// if rope wasnt cut still need to complete order so keep index
				// the same
				i--;
			}

		}
		System.out.println("\n number of used coils :");
		return coilsUsed;
	}

	public static String coilsToString(List<Rope> list) {

		String t = " ";
		for (int i = 0; i < list.size(); i++) {

			t = t + list.get(i).toString();

		}

		return t;

	}

	public static String ordersToString(List<Integer> list) {

		String t = "";
		for (int i = 0; i < list.size(); i++) {

			t = t + list.get(i).toString() + "  , ";

		}

		return t;

	}
}
