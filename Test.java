


import java.util.*; //needed for usage of the List interface

public class Test {

	

	/**
	 * This method is the main method to run your algorithms
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * You must complete the Generator class in order to generate a random
		 * test values You must complete the Algorithms class in order to call
		 * the two algorithms Remember: You need to calculate the time and
		 * number of coils used for each run of each algorithm You can use any
		 * additional method you created in this class
		 */

		System.out.println("*********** Correctness testing ************");
		System.out.println();
		// also provided hand written proof on word doc of different inputs
		Generator gen = new Generator();
		Algorithms alg = new Algorithms();

		List<Integer> orderList = new ArrayList<Integer>();
		// hard code some values to test, these values benefit the first fit
		// algorithm
		orderList.add(60);
		orderList.add(61);
		orderList.add(59);
		orderList.add(41);
		orderList.add(55);
		orderList.add(99);
		orderList.add(50);
		orderList.add(45);

		List<Rope> coils = new ArrayList<Rope>();
		List<Rope> coils2 = new ArrayList<Rope>();
		Rope t = new Rope(120);
		Rope v = new Rope(119);
		Rope e = new Rope(101);
		Rope a = new Rope(150);
		Rope p = new Rope(170);
		Rope l = new Rope(173);
		Rope t2 = new Rope(120);
		Rope v2 = new Rope(119);
		Rope e2 = new Rope(101);
		Rope a2 = new Rope(150);
		Rope p2 = new Rope(170);
		Rope l2 = new Rope(173);

		coils.add(t);
		coils.add(v);
		coils.add(e);
		coils.add(a);
		coils.add(p);
		coils.add(l);
		coils2.add(t2);
		coils2.add(v2);
		coils2.add(e2);
		coils2.add(a2);
		coils2.add(p2);
		coils2.add(l2);

		System.out.println("Ouput expected is 6 coils for next fit and 4 coils for first fit");

		System.out.println("Next fit");
		System.out.println(alg.coilsToString(coils) + "\n");
		System.out.println("Orders = " + alg.ordersToString(orderList) + "\n");
		System.out.println(alg.nextFit(orderList, coils));
		System.out.println("\nFirst fit");
		System.out.println(alg.coilsToString(coils2) + "\n");
		System.out.println("Orders = " + alg.ordersToString(orderList) + "\n");
		System.out.println(alg.firstFit(orderList, coils2));

		System.out.println("************** Main testing **************");

		List<Integer> orderList3 = new ArrayList<Integer>();
		List<Rope> coils3 = new ArrayList<Rope>();
		List<Rope> coils4 = new ArrayList<Rope>();

		coils3 = gen.orderRopeFromManufacturer(10);
		orderList3 = gen.generateMultipleOrders(10);
		for (Rope r : coils3) {

			coils4.add(new Rope(r.getLength()));
			// generate copy list of ropes
		}

		System.out.println("Generated using next fit");
		System.out.println(alg.coilsToString(coils3) + "\n");
		System.out.println("Orders = " + alg.ordersToString(orderList3) + "\n");
		System.out.println(alg.nextFit(orderList3, coils3) + "\n \n");
		System.out.println(alg.coilsToString(coils4) + "\n");
		System.out.println("Orders = " + alg.ordersToString(orderList3) + "\n");
		System.out.println("Generated using first fit");
		System.out.println(alg.firstFit(orderList3, coils4));
		//

		System.out.println("*********** Performance analysis **************");
		System.out.println();
		/*
		 * Here you will need to do performance testing
		 */

		int noOfTests = 4; // total number of tests - you need to CHANGE this
							// value
		int noOfRep = 4; // number of times to run each test - you need to
							// CHANGE this value
		int noOfOrders = 10000; // the number of customer orders needed for the
								// first run - you need to CHANGE this value
		int increment = 10000; // the increment in the number of orders - you
								// need
								// to CHANGE this value

		performanceTesting(noOfTests, noOfRep, noOfOrders, increment);

	}

	/**
	 * performanceTesting (comparing the two algorithms in term of time and
	 * total number of coils used)
	 * 
	 * @param noOfTests
	 *            - the number of tests
	 * @param noOfRep
	 *            - the number of repetitions for each test
	 * @param noOfOrders
	 *            - the number of orders in the first order sequence
	 * @param increment
	 *            - increment of the number of orders
	 *
	 */
	public static void performanceTesting(int noOfTests, int noOfRep, int noOfOrders, int increment) {
		Generator gen = new Generator();
		Algorithms alg = new Algorithms();

		for (int j = 0; j < noOfTests; j++) {
			int input = noOfOrders;
			input += (j * increment);
			List<Integer> orderList4 = new ArrayList<Integer>();
			List<Rope> coils5 = new ArrayList<Rope>();
			List<Rope> coils6 = new ArrayList<Rope>();

			coils5 = gen.orderRopeFromManufacturer(input); // change these
															// values for
															// other test
			orderList4 = gen.generateMultipleOrders(input);
			for (Rope r : coils5) {

				coils6.add(new Rope(r.getLength()));
				// make copy list of ropes to test same data
			}

			long totalTime;
			long startTime = System.currentTimeMillis();
			System.out.println("Generated using next fit");
			System.out.println(alg.nextFit(orderList4, coils5) + "\n \n");

			long endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("The test took " + (endTime - startTime) + " milliseconds\n \n");

			long totalTime2;
			long startTime2 = System.currentTimeMillis();
			System.out.println("Generated using first fit");
			System.out.println(alg.firstFit(orderList4, coils6));

			long endTime2 = System.currentTimeMillis();
			totalTime2 = endTime2 - startTime2;
			System.out.println("The test took " + (endTime2 - startTime2) + " milliseconds");
			//
			//

			/*
			 * Here you will need to set up and run your Performance analysis
			 * You are expected to run several tests (e.g. noOfTests=5) of your
			 * programs for, 10000, 20000, 30000, 40000, 50000 orders
			 * (noOfOrders=10000, increment=10000) so that one can see how the
			 * algorithms perform for large datasets.
			 * 
			 * You are expected to run the same test a number of times to ensure
			 * accurate result (noOfRep=4). In this case, you need to calculate
			 * the average time and coils needed for each run
			 */

		}

	}

}
