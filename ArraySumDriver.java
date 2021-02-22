// Tsegazeab Berhie
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		System.out.println("Sum of the first three numbers");
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		System.out.println("Sum of the first Five numbers");
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
		
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	
	public static int sumOfArray(Integer[] arr, int num) {
		
		if(num==0) {
			return 0;
		} else {
			return  sumOfArray(arr,num-1)+arr[num-1];
		}
	}
}