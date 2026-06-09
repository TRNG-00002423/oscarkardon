package Week2.Thursday.exercise_algorithims.starter_code;


/**
 * Pair exercise — build sorted array, pick target, time both searches.
 * TODO: complete main after SearchLib is implemented.
 */
public class SearchBenchmark {

    public static void main(String[] args) {
        // TODO: size N, fill sorted even integers, pick target, time SearchLib.linearSearch vs binarySearch
        System.out.println("Implement benchmark");
        int N = Integer.parseInt(args[0]);
        int[] sorted = buildSortedEvens(N);
        int target = sorted[(int) (Math.random() * N)];
        // int target = sorted[N - 1]; //make target the last value in sorted so its worst case for linear
        long start = System.nanoTime();

        int indexLinearSearch = SearchLib.linearSearch(sorted, target);
        long linearTime = System.nanoTime() - start;

        start = System.nanoTime();
        int indexBinarySearch = SearchLib.binarySearch(sorted, target);
        long binaryTime = System.nanoTime() - start;

        assert(indexBinarySearch == target);
        assert(indexLinearSearch == target);

        double linearMs = linearTime / 1000000.0;
        double binaryMs = binaryTime / 1000000.0;
        System.out.println("Linear Search: " + linearMs + " ms");
        System.out.println("Binary Search: " + binaryMs + " ms");
    
        start = System.nanoTime();
        indexLinearSearch = SearchLib.linearSearch(sorted, target);
        linearTime = System.nanoTime() - start;

        start = System.nanoTime();
        indexBinarySearch = SearchLib.binarySearch(sorted, target);
        binaryTime = System.nanoTime() - start;

        assert(indexBinarySearch == target);
        assert(indexLinearSearch == target);

        linearMs = linearTime / 1000000.0;
        binaryMs = binaryTime / 1000000.0;
        System.out.println("Linear Search: " + linearMs + " ms");
        System.out.println("Binary Search: " + binaryMs + " ms");
    }

    static int[] buildSortedEvens(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
}