import java.util.Random;

public class Sorter {

    // Generate random array of given size
    public int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000); // numbers 0–999
        }
        return arr;
    }

    // Print array (useful for small arrays)
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // BASIC SORT → INSERTION SORT
    public void basicSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];        // current element
            int j = i - 1;

            // Shift elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert element in correct position
            arr[j + 1] = key;
        }
    }

    // ADVANCED SORT → MERGE SORT
    public void advancedSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursive Merge Sort
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // divide
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // merge
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted halves
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}