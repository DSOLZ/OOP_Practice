public class Sort {

	public static void InsertionSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) { // try to insert nums[i] into sorted zone
			int key = nums[i];
			int j = i - 1; // j is the index for each number in the sorted zone
			while (j >= 0 && nums[j] > key) { // try to compare key with nums[j]
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = key;
		}

	}

	public static void SelectionSort(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) { // select the min between index i to n-1
			int min = nums[i];
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < min) {
					min = nums[j];
					minIndex = j;
				}
			}

			int temp = nums[minIndex]; // swap min with index i
			nums[minIndex] = nums[i];
			nums[i] = temp;

		}

	}

	public static void BubbleSort(int[] nums) {

		int n = nums.length;
		for (int i = 0; i < n; i++) { // try to bubble the min between index i and n-1 to i
			for (int j = n - 1; j > i; j--) {	// from tail to i + 1
				if (nums[j] < nums[j - 1]) {	//bubble j with j-1
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {

		int[] arr1 = { 4, 6, 2, 3, 1, 7, 8, 5, 9, 0 };
		int[] arr2 = { 4, 6, 2, 3, 1, 7, 8, 5, 9, 0 };
		int[] arr3 = { 4, 6, 2, 3, 1, 7, 8, 5, 9, 0 };

		InsertionSort(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();

		SelectionSort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		BubbleSort(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();

	}

}