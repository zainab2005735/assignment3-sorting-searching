public class Searcher {

    // BINARY SEARCH
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // target found
            if (arr[mid] == target) {
                return mid;
            }

            // search right half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // search left half
            else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }
}