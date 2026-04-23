
import java.util.Arrays;

public class Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    // Measure sorting time
    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    // Measure search time
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    // Run all experiments
    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("\n===== ARRAY SIZE: " + size + " =====");

            // Generate arrays
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, size);
            Arrays.sort(sortedArray);

            // ---- SORTING TESTS ----
            long insertionTime = measureSortTime(randomArray, "basic");
            long mergeTime = measureSortTime(randomArray, "advanced");

            System.out.println("Insertion Sort (random): " + insertionTime + " ns");
            System.out.println("Merge Sort (random): " + mergeTime + " ns");

            long insertionSortedTime = measureSortTime(sortedArray, "basic");
            long mergeSortedTime = measureSortTime(sortedArray, "advanced");

            System.out.println("Insertion Sort (sorted): " + insertionSortedTime + " ns");
            System.out.println("Merge Sort (sorted): " + mergeSortedTime + " ns");

            // ---- SEARCH TEST ----
            Arrays.sort(randomArray); // Binary search needs sorted array
            int target = randomArray[size / 2];

            long searchTime = measureSearchTime(randomArray, target);
            System.out.println("Binary Search time: " + searchTime + " ns");
        }
    }
}