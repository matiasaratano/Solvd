package homework;

public class SortAlgorithm {

	public static void main(String[] args) {

		int[] a = { 3, 4, 5, 9, 1, 8 };
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}

	}

	private static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}

			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;

		}
	}

}
