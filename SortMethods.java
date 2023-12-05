/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Charles Chang
 *	@since	November 30, 2023
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(Integer [] arr) {
		for (int outer = arr.length - 1; outer > 0; outer --)
			for (int inner = 0; inner < outer; inner ++) 
				if (arr[inner].compareTo(arr[inner + 1]) > 0)
					swap(arr, inner, inner + 1);
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(Integer[] arr, int x, int y) {
		Integer temp = arr[x];
		arr[x] = arr[y]; 
		arr[y] = temp;
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSort(Integer [] arr) {
		for (int outer = arr.length - 1; outer > 0; outer --) {
			int highest = 0;
			for (int inner = 0; inner <= outer; inner ++) {
				if (arr[inner].compareTo(arr[highest]) > 0) 
					highest = inner;
			}
			swap(arr, highest, outer);
			highest = 0;
		}
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(Integer [] arr) {
		for (int outer = 1; outer < arr.length; outer ++) {
			int inner = outer - 1;
			while (inner >= 0 && arr[inner + 1].compareTo(arr[inner]) < 0) {
				swap(arr, inner, inner + 1);
				inner --;
			}
		}
	}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void mergeSort(Integer [] arr) {
		arr = mergeSplit(0, arr.length - 1, arr);
	}
	
	/**
	 *  Split helper method for merge. If end - start indices = 1 or 2,
	 * 	break the loop.
	 * 	@param	int		start index
	 * 	@param	int		end index
	 * 	@param	Integer[]	array to split
	 * 	@return Integer[]	merged array
	 */
	public Integer[] mergeSplit(int start, int end, Integer[] arr) {
		// Find middle to split
		int splitIndex = (start + end) / 2;
		// Array for each half
		Integer[] firstHalf;
		Integer[] secondHalf;
		// First half
		if (splitIndex - start > 1) {
			firstHalf = mergeSplit(start, splitIndex, arr);
		} else if (splitIndex == start) {
			firstHalf = new Integer[] {arr[start]};
		} else {
			// Swap if needed
			if (arr[start].compareTo(arr[start + 1]) > 0)
				swap(arr, start, start + 1);
			firstHalf = new Integer[] {arr[start], arr[start + 1]};
		}
		// Second half
		if (end - (splitIndex + 1) > 1) {
			secondHalf = mergeSplit(splitIndex + 1, end, arr);
		} else if (splitIndex + 1 == end) {
			secondHalf = new Integer[] {arr[end]};
		} else {
			if (arr[splitIndex + 1].compareTo(arr[splitIndex + 2]) > 0)
				swap(arr, splitIndex + 1, splitIndex + 2);
			secondHalf = new Integer[] {arr[end  - 1], arr[end]};
		}
		// Output Array
		Integer[] output = new Integer[firstHalf.length + secondHalf.length];
		return output;
	}
	
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(Integer[] arr) {
		if (arr.length == 0) System.out.print("(");
		else System.out.printf("( %4d", arr[0]);
		for (int a = 1; a < arr.length; a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
			else System.out.printf(", %4d", arr[a]);
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
	public void run() {
		Integer[] arr = new Integer[10];
		// Fill arr with random numbers
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nBubble Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		bubbleSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
		
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nSelection Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		selectionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nInsertion Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		insertionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();


		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

	}
}
